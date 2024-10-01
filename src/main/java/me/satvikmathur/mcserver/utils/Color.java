package me.satvikmathur.mcserver.utils;

import org.bukkit.ChatColor;

public class Color {

    public static String cc(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }

}
