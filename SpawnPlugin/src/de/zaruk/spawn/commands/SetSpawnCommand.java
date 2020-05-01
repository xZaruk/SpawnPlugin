package de.zaruk.spawn.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zaruk.spawn.core.SpawnPlugin;

public class SetSpawnCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(sender.hasPermission("spawn.setspawn")) {
				SpawnPlugin.api.setSpawn(p.getLocation());
				p.sendMessage("§aSpawn gesetzt");
			} else {
				p.sendMessage("§cDafür hast du keine Rechte");
			}
		} else {
			sender.sendMessage("§cNur für Spieler");
		}
		return false;
	}

}
