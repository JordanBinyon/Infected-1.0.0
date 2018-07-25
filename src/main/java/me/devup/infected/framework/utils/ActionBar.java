package me.devup.infected.framework.utils;

import java.util.List;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ActionBar {
	
	public static void sendActionBar(Player player, String message) {
        IChatBaseComponent cbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");

        PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, (byte) 2);
        
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(ppoc);
    }

	public static void setActionBar(String message) {
        for(Player player : Bukkit.getOnlinePlayers()) {
        	sendActionBar(player, message);
        }
    }
	
	public static void sendActionBar(List<Player> players, String message) {
		for(Player player : players) {
			sendActionBar(player, message);
		}
	}

}
