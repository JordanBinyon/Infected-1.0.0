package me.devup.infected.plugin.game;

import lombok.Getter;
import me.devup.infected.framework.arena.*;
import me.devup.infected.framework.utils.ActionBar;
import me.devup.infected.framework.utils.Message;
import me.devup.infected.framework.utils.PlayerUtils;
import me.devup.infected.plugin.Infected;
import me.devup.infected.plugin.game.account.AccountManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

@Getter
public class Game {

    private Arena arena = new Arena();

    private List<UUID> players = new ArrayList<>();

    protected BukkitTask task = null;

    public Game(String id) {
        arena.getArenaTeams().add(new ArenaTeam("Humans", Color.YELLOW));

        arena.getArenaTeams().add(new ArenaTeam("Infected", Color.RED));

        arena.setId(id);

        arena.setVote(new ArenaVote());
    }

    public void start() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            PlayerUtils.teleportPlayer(player, arena.getMap().getSpawns().get(0).getLocation());

            PlayerUtils.clearInventory(player);

            PlayerUtils.heal(player, true);

            AccountManager.getInstance().getAccount(player).equip();
        }

        task = new BukkitRunnable() {

            int time = 280;

            @Override
            public void run() {
                if(time == 0) {
                    end();

                    Bukkit.getServer().broadcastMessage(Message.GAME.format("&eRescue has arrived &4- &eThe humans win!"));

                    cancel();
                } else {
                    if(time >= 250) {
                        if(time == 250) {
                            infectRandom(3);
                        } else {
                            ActionBar.setActionBar(ChatColor.translateAlternateColorCodes('&', "&4Infection releases in &e"  + time + " &4second&e(&4s&e)"));
                        }
                    } else {
                        ActionBar.sendActionBar(Arrays.asList(getTeam("Humans").toPlayers()), ChatColor.translateAlternateColorCodes('&', "&4Rescue in &e" + time + " &4second&e(&4s&e)"));

                        ActionBar.sendActionBar(Arrays.asList(getTeam("Infected").toPlayers()), ChatColor.translateAlternateColorCodes('&', "&4Humans win in &e" + time + " &4second&e(&4s&e)"));

                        if(checkWin()) {
                            end();

                            Bukkit.getServer().broadcastMessage(Message.GAME.format("&eThe humans have been killed off &4- &eThe infected win!"));

                            cancel();
                        }
                    }
                    time--;
                }
            }
        }.runTaskTimer(Infected.getPlugin(), 20, 20);
    }

    public void end() {
        restMapVote();

        startMapVote();

        for(Player player : Bukkit.getOnlinePlayers()) {
            PlayerUtils.teleportPlayer(player, Infected.getFramework().getLobby());

            PlayerUtils.clearInventory(player);

            PlayerUtils.heal(player, true);
        }

        task = new BukkitRunnable() {

            int time = 120;

            @Override
            public void run() {
                ActionBar.setActionBar(ChatColor.translateAlternateColorCodes('&', "&4Gaming starting in &e"  + time + " &4second&e(&4s&e)"));

                if(time == 0) {
                    if(Bukkit.getOnlinePlayers().size() < 5) {
                        restMapVote();

                        startMapVote();

                        time = 120;

                        Bukkit.broadcastMessage(Message.GAME.format("&eGame failed to find players to start the game &4- &eRestarting search..."));
                    } else {
                        start();

                        cancel();
                    }
                } else {
                    if(time == 60) {
                        arena.setMap(ArenaMapManager.getInstance().getMap(getTopMap()));

                        arena.getVote().setCancelled(true);
                    }
                    time--;
                }
            }
        }.runTaskTimer(Infected.getPlugin(), 20, 20);
    }

    protected void startMapVote() {
        ArenaMap[] maps = ArenaMapManager.getInstance().getRandomMaps(5);

        for(ArenaMap map : maps) {
            arena.getVote().addOption(map.getName());
        }
    }

    protected void restMapVote() {
        arena.getVote().reset();
    }

    protected String getTopMap() {
        return (String) arena.getVote().getTopOptions().toArray()[0];
    }

    protected void infectRandom(int amount) {
        List<UUID> players = new ArrayList<>();

        for (Player player : Bukkit.getOnlinePlayers()) {
            players.add(player.getUniqueId());
        }

        Collections.shuffle(players);

        for(int i = 0; i < amount; i++) {
            infect(Bukkit.getPlayer(players.get(i)));
        }
    }

    public void infect(Player player) {
        if(isHuman(player))
            getTeam("Humans").getPlayers().remove(player.getUniqueId());

        if(!(isInfected(player)))
            getTeam("Infected").getPlayers().add(player.getUniqueId());

        PlayerUtils.heal(player, true);

        AccountManager.getInstance().getAccount(player).equip();

        player.teleport(getRandomSpawn());
    }

    protected boolean checkWin() {
        return getTeam("Humans").getPlayers().isEmpty();
    }

    public boolean isHuman(Player player) {
        if(getTeam("Humans") != null) {
            if(getTeam("Humans").getPlayers().contains(player.getUniqueId())) {
                return true;
            }
        }
        return false;
    }

    public boolean isInfected(Player player) {
        if(getTeam("Infected") != null) {
            if(getTeam("Infected").getPlayers().contains(player.getUniqueId())) {
                return true;
            }
        }
        return false;
    }

    public void removePlayer(Player player) {
        if(isInfected(player))
            getTeam("Infected").getPlayers().remove(player.getUniqueId());

        if(isHuman(player))
            getTeam("Humans").getPlayers().remove(player.getUniqueId());

        if(getPlayers().contains(player.getUniqueId()))
            getPlayers().remove(player.getUniqueId());
    }

    public Location getRandomSpawn() {
        return arena.getMap().getSpawns().get(new Random().nextInt(arena.getMap().getSpawns().size() - 2) + 2).getLocation();
    }

    protected ArenaTeam getTeam(String name) {
        for(ArenaTeam team : arena.getArenaTeams()) {
            if(team.getName().equalsIgnoreCase(name))
                return team;
        }
        return null;
    }

    public void sendMessage(String message) {
        for(ArenaTeam team : arena.getArenaTeams())
            team.sendMessage(message);
    }

}
