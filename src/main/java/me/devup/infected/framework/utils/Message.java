package me.devup.infected.framework.utils;

import org.bukkit.ChatColor;

public enum Message {
    GAME("&4Game&8> &r%message%"), INFO("&4Info&8> &r%message%"), ERROR("&4Error&8> &r%message%");

    private String format;

    Message(String format) {
        this.format = format;
    }

    public String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', format.replace("%message%", message));
    }

}
