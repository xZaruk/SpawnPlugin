package de.zaruk.spawn.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import de.zaruk.spawn.core.SpawnPlugin;

public class SpawnListener implements Listener {

	
	@EventHandler
	public void onJoinSpawn(PlayerJoinEvent e) {
		Bukkit.getScheduler().runTaskLater(SpawnPlugin.getPlugin(), new Runnable() {
			
			@Override
			public void run() {
				e.getPlayer().teleport(SpawnPlugin.api.spawnLoc);
			}
		}, 1*2L);
	}
	
	
	@EventHandler
	public void onRespawnSpawn(PlayerRespawnEvent e) {
		e.setRespawnLocation(SpawnPlugin.api.spawnLoc);
	}

}
