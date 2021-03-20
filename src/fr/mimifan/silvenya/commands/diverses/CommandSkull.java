package fr.mimifan.silvenya.commands.diverses;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandSkull implements CommandExecutor {

	private Main main;
	
	public CommandSkull(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			player.sendMessage(main.getConfig().getString("skull.no_player").replace("&", "§").replace(">", "»"));
		}
		if(args.length == 1) {
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "give " + player.getName() + " player_head " + args[0]);
			return true;
		}
		if(args.length == 2) {
			int quantite = Integer.valueOf(args[1]).intValue();
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "give " + player.getName() + " player_head " + args[0] + " " + quantite);
			return true;
		}
		
		return false;
	}

}
