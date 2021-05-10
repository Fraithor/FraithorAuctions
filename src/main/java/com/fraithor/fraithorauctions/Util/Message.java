package com.fraithor.fraithorauctions.Util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Message {

    private static final String c(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    private static final String p(String str) {
        return c("&7&l[&6&lFraithorAuctions&7]" + str + " ");
    }

    public static void info(String message) {
        System.out.println(p(message));
    }

    public static void player(Player player, String message) {
        player.sendMessage(c(message));
    }

}
