package me.devup.infected.plugin.game.listeners.player;

import me.devup.infected.plugin.Infected;
import me.devup.infected.plugin.game.account.Account;
import me.devup.infected.plugin.game.account.AccountManager;
import me.devup.infected.plugin.game.listeners.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

public class PlayerDeath extends Listener {

    public PlayerDeath(Plugin plugin) {
        super(plugin);

        Infected.getPlugin().registerPlugin(this);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if(!(e.getEntity() instanceof Player))
            return;

        if(!(e.getEntity().getKiller() instanceof Player))
            return;

        Player player = e.getEntity(), killer = e.getEntity().getKiller();

        Account playerAccount = AccountManager.getInstance().getAccount(player), killerAccount = AccountManager.getInstance().getAccount(killer);

        playerAccount.setDeaths(playerAccount.getDeaths() + 1);

        killerAccount.setKills(killerAccount.getKills() + 1);

        int flesh = (5 * (killerAccount.getFleshMultiplier() + Infected.getFramework().getServerMultiplier()));

        killerAccount.setFlesh(killerAccount.getFlesh() + flesh);

        // TODO Tell the player they have received the flesh

        e.getDrops().clear();

        e.setDroppedExp(0);
    }
}
