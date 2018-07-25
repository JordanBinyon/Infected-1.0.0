package me.devup.infected.plugin.game.leaderboard.leaderboards;

import me.devup.infected.framework.utils.ItemBuilder;
import me.devup.infected.plugin.Infected;
import me.devup.infected.plugin.game.leaderboard.Leaderboard;
import me.devup.infected.plugin.game.leaderboard.LeaderboardType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.UUID;

public class Monthly extends Leaderboard {

    protected String database = "MonthlyStats";

    /*
     *  Object[0] - player name
     *  Object[1] - kills
     *  Object[2] - deaths
     *  Object[3] - wins
     */
    protected LinkedHashMap<UUID, Object[]> topPlayers = new LinkedHashMap<>();

    public Monthly(LeaderboardType type) {
        super(type);
    }

    @Override
    public void update() {
        topPlayers.clear();

        getInventory().clear();

        obtainLatestStats();

        for(UUID uuid : topPlayers.keySet()) {
            Object[] values = topPlayers.get(uuid);

            ItemStack skull = new ItemBuilder().setMaterial(Material.SKULL_ITEM).setName(ChatColor.translateAlternateColorCodes('&', "&4" + values[0] + " &e - &8[&e" + values[4] + "&8]")).setLore(ChatColor.RED + String.valueOf(values[0]), ChatColor.translateAlternateColorCodes('&', "&eKills &8> &c" + (int) values[1]), ChatColor.translateAlternateColorCodes('&', "&eDeaths &8> &c" + (int) values[2]), ChatColor.translateAlternateColorCodes('&', "&eWins &8> &c" + (int) values[3])).build();
            SkullMeta sm = (SkullMeta) skull.getItemMeta();

            sm.setOwner(String.valueOf(values[0]));

            skull.setItemMeta(sm);

            getInventory().addItem(skull);
        }
    }

    @Override
    public void obtainLatestStats() {
        Infected.getConnector().openConnection();

        String statement = "SELECT * FROM '" + database + "' (SELECT @position:=@position+1 AS position, uuid, name, kills, deaths, wins, (SELECT @position := 0) r ORDER BY kills DESC, deaths DESC, wins DESC) t LIMIT 36";

        PreparedStatement preparedStatement = null;

        ResultSet results = null;

        try {
            preparedStatement = Infected.getConnector().getConnection().prepareStatement(statement);

            results = preparedStatement.executeQuery();

            while(results.next()) {
                topPlayers.put(UUID.fromString(results.getString("uuid")), new Object[] { results.getString("name"), results.getInt("kills"), results.getInt("deaths"), results.getInt("wins"), results.getInt("position")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();

                if(results != null)
                    results.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
