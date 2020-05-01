package de.zaruk.spawn.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zaruk.spawn.core.SpawnPlugin;

public class SpawnCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(sender.hasPermission("spawn.instanttp")) {
				SpawnPlugin.api.teleportToSpawn(p);
				sender.sendMessage("§aZum Spawn tpt");
			} else {
				sender.sendMessage("§2Teleport in 3 Sekunden");
				
				Bukkit.getScheduler().runTaskLater(SpawnPlugin.getPlugin(), new Runnable() {
					
					@Override
					public void run() {
						
						SpawnPlugin.api.teleportToSpawn(p);
						sender.sendMessage("§aZum Spawn tpt");
						
					}
				}, 3*20);
				
			}
		} else {
			sender.sendMessage("§cBefehl nur für Spieler");
		}
		return false;
	}

}
