package fr.mimifan.silvenya.commands.important;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandBought implements CommandExecutor {

	private Main main;
	
	public CommandBought(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 2) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				if(target.isOnline()) {
					if(args[1].equalsIgnoreCase("fermier")) {
						Bukkit.broadcastMessage(main.getConfig().getString("prefixs.grades").replace("&", "§").replace(">", "»") + "Merci §2" + target.getName() + " §ed'avoir acheté le grade §2§lFermier §e! Profites-en !");
					}
					if(args[1].equalsIgnoreCase("seigneur")) {
						Bukkit.broadcastMessage(main.getConfig().getString("prefixs.grades").replace("&", "§").replace(">", "»") + "Merci §3" + target.getName() + " §ed'avoir acheté le grade §3§lSeigneur §e! Profites-en !");
					}
				}
			}
		}
		return false;
	}

}
