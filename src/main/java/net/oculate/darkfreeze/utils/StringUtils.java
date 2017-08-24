package net.oculate.darkfreeze.utils;

import org.bukkit.ChatColor;

public class StringUtils {

    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String repeat(String input, int times) {
        return org.apache.commons.lang.StringUtils.repeat(input, times);
    }

    public static String capitalize(String input) {
        String lower = input.toLowerCase();
        return lower.substring(0, 1).toUpperCase() + lower.substring(1, lower.length());
    }

}