package de.zaruk.spawn.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.zaruk.spawn.api.SpawnAPI;
import de.zaruk.spawn.commands.SetSpawnCommand;
import de.zaruk.spawn.commands.SpawnCommand;
import de.zaruk.spawn.listener.SpawnListener;

public class SpawnPlugin extends JavaPlugin {
	
	public static SpawnPlugin plugin;
	public static SpawnAPI api = new SpawnAPI();
	
	@Override
	public void onEnable() {
		plugin = this;
		Bukkit.getPluginManager().registerEvents(new SpawnListener(), this);
		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("setspawn").setExecutor(new SetSpawnCommand());
		api.loadSpawnLoc();
	}
	
	@Override
	public void onDisable() {
		
		
	}
	
	public static SpawnPlugin getPlugin() {
		return plugin;
	}

}
