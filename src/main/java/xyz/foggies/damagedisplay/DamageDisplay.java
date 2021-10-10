package xyz.foggies.damagedisplay;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.foggies.damagedisplay.listeners.AttackListener;

import java.util.Arrays;

public final class DamageDisplay extends JavaPlugin {

	private static DamageDisplay plugin;

	@Override
	public void onEnable() {
		plugin = this;
		registerListeners(new AttackListener());
	}

	@Override
	public void onDisable() {

	}

	public void registerListeners(Listener... listeners){
		Arrays.stream(listeners).forEach(listener -> getServer().getPluginManager().registerEvents(listener, this));
	}

	public static DamageDisplay getPlugin() {
		return plugin;
	}
}
