package fr.mimifan.silvenya.commands.diverses;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandSuicide implements CommandExecutor {

	private Main main;
	
	public CommandSuicide(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		player.setHealth(0.0D);
		player.sendMessage(main.getConfig().getString("killing.suicide").replace("&", "§").replace(">", "»"));
		return false;
	}

}
