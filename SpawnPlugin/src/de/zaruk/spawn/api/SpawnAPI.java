package de.zaruk.spawn.api;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SpawnAPI {
	
	public Location spawnLoc = null;
	
	public void setSpawn(Location loc) {
		File file = new File("plugins//Spawn//location.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("Location.W", loc.getWorld().getName());
		cfg.set("Location.X", loc.getX());
		cfg.set("Location.Y", loc.getY());
		cfg.set("Location.Z", loc.getZ());
		cfg.set("Location.Yaw", loc.getYaw());
		cfg.set("Location.Pitch", loc.getPitch());
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		spawnLoc = loc;
	}
	
	public void loadSpawnLoc() {
		File file = new File("plugins//Spawn//location.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(cfg.getString("Location.W") != null) { // Abfrage ob der Spawn gesetzt ist
			
		spawnLoc = new Location(Bukkit.getWorld(cfg.getString("Location.W")),
				cfg.getDouble("Location.X"),
				cfg.getDouble("Location.Y"),
				cfg.getDouble("Location.Z"),
				(float) cfg.getDouble("Location.Yaw"),
				(float) cfg.getDouble("Location.Pitch"));
		
		}
	}
	
	public void teleportToSpawn(Player p) {
		if(spawnLoc != null) {
			if(!spawnLoc.getChunk().isLoaded()) {
				spawnLoc.getChunk().load();
			}
			
			p.teleport(spawnLoc);
		}
	}

}
