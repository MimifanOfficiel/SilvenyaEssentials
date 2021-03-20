package fr.mimifan.silvenya.commands.téléportation;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandTP implements CommandExecutor {

	private Main main;
	public CommandTP(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			player.sendMessage(main.getConfig().getString("teleportation.tp.noplayer").replace("&", "§").replace(">", "»"));
		}
		if(args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				if(target.isOnline()) {
					player.teleport(target);
					player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez été téléporté à §b" + target.getName());
				}
			} else {
				player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[0] + " §fn'est pas connecté !");
			}
		}
		if(args.length == 2) {
			Player target1 = Bukkit.getPlayer(args[0]);
			Player target2 = Bukkit.getPlayer(args[1]);
			if(target1 != null) {
				if(target2 != null) {
					if(target1.isOnline()) {
						if(target2.isOnline()) {
							if(target1 != sender) {
								if(target2 != sender) {
									target1.teleport(target2);
									player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez téléporté §b" + target1.getName() + " §fà §b" + target2.getName());
									target1.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez été téléporté à §b" + target2.getName() + " §f!");
								} else {
									target1.teleport(target2);
									target1.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez été téléporté à §b" + target2.getName() + " §f!");
								}
							} else {
								target1.teleport(target2);
								player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez été téléporté à §b" + target2.getName() + " §f!");
							}
						}
					}
				} else {
					player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[1] + " §fn'est pas connecté !");
				}
			} else {
				player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[0] + " §fn'est pas connecté !");
			}
			
		}
		return false;
	}

}
