package fr.mimifan.silvenya.commands.spawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandForceSpawn implements CommandExecutor {

	@SuppressWarnings("unused")
	private Main main;
	
	public CommandForceSpawn(Main main) {
		this.main = main;
	}

	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		
		
		return false;
	}

}
