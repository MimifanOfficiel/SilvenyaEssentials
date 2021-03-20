package fr.mimifan.silvenya.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandMaintenance implements CommandExecutor {

	private Main main;
	
	public CommandMaintenance(Main main) {
		this.main = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if (args.length == 0) {
			player.sendMessage(main.getConfig().getString("prefixs.maintenance").replace("&", "§").replace(">", "»") + "La maintenance est actuellement en " + main.getConfig().getString("maintenance.stat") + " §f!");
		}
		if (args.length == 1) {
			if(args[0].equalsIgnoreCase("off")) {
				Bukkit.broadcastMessage(main.getConfig().getString("prefixs.maintenance").replace("&", "§").replace(">", "»") + "La maintenance est maintenant désactivée !");
				main.getConfig().set("maintenance.stat", "off");
			} 
			if (args[0].equalsIgnoreCase("on")) {
				Bukkit.broadcastMessage(main.getConfig().getString("prefixs.maintenance").replace("&", "§").replace(">", "»") + "La maintenance est maintenant activée !");
				main.getConfig().set("maintenance.stat", "on");

				Bukkit.getOnlinePlayers().forEach(players -> {
					if (players.hasPermission(main.getConfig().getString("maintenance.bypass"))) {
						players.sendMessage("");
					} else {
						players.kickPlayer(main.getConfig().getString("maintenance.kickmsg").replace("&", "§").replace(">", "»"));
					} 
				});
			} 
			if (!args[0].equalsIgnoreCase("off") && !args[0].equalsIgnoreCase("on")) {
				player.sendMessage(main.getConfig().getString("prefixs.maintenance").replace("&", "§").replace(">", "»") + "Utilisation: §b/maintenance on/off §f!");
			}
		} 
		return false;
	}
}