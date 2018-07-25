package me.devup.infected.framework.arena;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class ArenaTeam {

    private String name;

    private Color color;

    private List<UUID> players = new ArrayList<>();

    public ArenaTeam(String name, Color color) {
        this.name = name;

        this.color = color;
    }

    public void sendMessage(String message) {
        for(UUID uuid : players) {
            Bukkit.getPlayer(uuid).sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
    }

    public Player[] toPlayers() {
        Player[] players = new Player[getPlayers().size()];

        int i = 0;

        for(UUID uuid : getPlayers()) {
            players[i] = Bukkit.getPlayer(uuid);

            i++;
        }
        return players;
    }

}
