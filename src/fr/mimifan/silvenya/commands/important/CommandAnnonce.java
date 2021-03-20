package fr.mimifan.silvenya.commands.important;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandAnnonce implements CommandExecutor {

	private Main main;
	
	public CommandAnnonce(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			player.sendMessage(main.getConfig().getString("annonce.no_msg").replace("&", "§").replace(">", "»"));
		}
		if(args.length >= 1) {
			StringBuilder br = new StringBuilder();
			for(String part : args) {
				br.append(" " + part);
			}
			Bukkit.broadcastMessage(main.getConfig().getString("annonce.annonce_prefix").replace("&", "§").replace(">", "»") + br.toString());
		}
		return false;
	}

}
