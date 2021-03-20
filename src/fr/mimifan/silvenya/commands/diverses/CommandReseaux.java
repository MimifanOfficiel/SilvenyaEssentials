package fr.mimifan.silvenya.commands.diverses;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandReseaux implements CommandExecutor {

	private Main main;
	
	public CommandReseaux(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("discord")) {
			player.sendMessage(main.getConfig().getString("reseaux.discord").replace("&", "§").replace(">", "»"));
		}
		if(cmd.getName().equalsIgnoreCase("vote")) {
			player.sendMessage(main.getConfig().getString("reseaux.vote").replace("&", "§").replace(">", "»"));
		}
		if(cmd.getName().equalsIgnoreCase("site")) {
			player.sendMessage(main.getConfig().getString("reseaux.site").replace("&", "§").replace(">", "»"));
		}
		if(cmd.getName().equalsIgnoreCase("boutique")) {
			player.sendMessage(main.getConfig().getString("reseaux.shop").replace("&", "§").replace(">", "»"));
		}
		
		return false;
	}

}
