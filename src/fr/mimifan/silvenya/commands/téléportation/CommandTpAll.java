package fr.mimifan.silvenya.commands.téléportation;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandTpAll implements CommandExecutor {

	private Main main;
	
	public CommandTpAll(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		for (Player players : Bukkit.getOnlinePlayers()) {
			if(players != sender) {
				players.teleport(player.getLocation());
				players.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez été téléporté à §b" + player.getName());
			}
		}
		player.sendMessage(main.getConfig().getString("teleportation.tpall.asked").replace("&", "§").replace(">", "»"));
		return false;
	}

}
