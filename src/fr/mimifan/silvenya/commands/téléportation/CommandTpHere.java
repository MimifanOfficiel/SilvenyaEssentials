package fr.mimifan.silvenya.commands.téléportation;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandTpHere implements CommandExecutor {

	private Main main;
	
	public CommandTpHere(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			player.sendMessage(main.getConfig().getString("teleportation.tphere.less_args").replace("&", "§").replace(">", "»"));
		}
		if(args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				if(target.isOnline()) {
					if(target != sender) {
						target.teleport(player.getLocation());
						target.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez été téléporté à §b" + target.getName());
						player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez téléporté §b" + target.getName() + " §fsur vous !");
					} else {
						player.sendMessage(main.getConfig().getString("teleportation.tphere.selfask").replace("&", "§").replace(">", "»"));
					}
				}
			} else {
				player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "§b" + args[0] + " §fn'est pas connecté !");
			}
			
		}
		return false;
	}

}
