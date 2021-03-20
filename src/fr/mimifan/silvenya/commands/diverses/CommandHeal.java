package fr.mimifan.silvenya.commands.diverses;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandHeal implements CommandExecutor {

	private Main main;
	
	public CommandHeal(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("heal")) {
			if(args.length == 0) {
				player.setFoodLevel(20);
				player.setHealth(20.0D);
				player.sendMessage(main.getConfig().getString("heal.healed").replace("&", "§").replace(">", "»"));
			}
			if(args.length == 1) {
				if(player.hasPermission(main.getConfig().getString("heal.heal_other_perm"))) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						if(target.isOnline()) {
							if(target != sender) {
								target.setFoodLevel(20);
								target.setHealth(20.0D);
								target.sendMessage(main.getConfig().getString("heal.healed").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.heal").replace("&", "§").replace(">", "»") + "Vous avez soigné §b" + target.getName() + " §f!");
							} else {
								player.setFoodLevel(20);
								player.setHealth(20.0D);
								player.sendMessage(main.getConfig().getString("heal.healed").replace("&", "§").replace(">", "»"));
							}
						}
					} else {
						player.sendMessage(main.getConfig().getString("prefixs.heal").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[0] + " §fn'est pas connecté !");
					}
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("feed")) {
			if(args.length == 0) {
				player.setFoodLevel(20);
				player.sendMessage(main.getConfig().getString("heal.feeded").replace("&", "§").replace(">", "»"));
			}
			if(args.length == 1) {
				if(player.hasPermission(main.getConfig().getString("heal.feed_other_perm"))) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						if(target.isOnline()) {
							if(target != sender) {
								target.setFoodLevel(20);
								target.sendMessage(main.getConfig().getString("heal.feeded").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.heal").replace("&", "§").replace(">", "»") + "Vous avez nourri §b" + target.getName() + " §f!");
							} else {
								player.setFoodLevel(20);
								player.sendMessage(main.getConfig().getString("heal.feeded").replace("&", "§").replace(">", "»"));
							}
						}
					} else {
						player.sendMessage(main.getConfig().getString("prefixs.heal").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[0] + " §fn'est pas connecté !");
					}
				}
			}
		}
		return false;
	}

}
