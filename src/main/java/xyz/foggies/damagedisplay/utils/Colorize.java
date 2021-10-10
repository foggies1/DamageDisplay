package xyz.foggies.damagedisplay.utils;

import org.bukkit.ChatColor;

/**
 * @author foggies on 10/10/2021.
 * @project DamageDisplay
 */
public class Colorize {

	public static String text(String message){
		return ChatColor.translateAlternateColorCodes('&', message);
	}

}
