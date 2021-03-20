package fr.mimifan.silvenya.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandClear implements CommandExecutor {
	
	private Main main;
	public CommandClear(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length ==0) {
			player.getInventory().clear();
			player.sendMessage(main.getConfig().getString("prefixs.clear").replace(">", "»").replace("&", "§") + "Votre inventaire a été supprimé !");
		}
		if(args.length ==1) {
			if(player.hasPermission("silvenya.clear")) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null) {
					if(target.isOnline()) {
						if(target != sender) {
							target.getInventory().clear();
							player.sendMessage(main.getConfig().getString("prefixs.clear").replace(">", "»").replace("&", "§") + "L'inventaire de §b" + target.getName() + " §fa été supprimé !");
							target.sendMessage(main.getConfig().getString("prefixs.clear").replace(">", "»").replace("&", "§") + "Votre inventaire a été supprimé !");
							return false;
						} else {
							player.sendMessage(main.getConfig().getString("prefixs.clear").replace(">", "»").replace("&", "§") + "Votre inventaire a été supprimé !");
							return false;
						}
					}
				} else {
					player.sendMessage(main.getConfig().getString("prefixs.clear").replace(">", "»").replace("&", "§") + "Le joueur §b" + args[0] + " §fn'est pas connecté !");
					return false;
				}
			} else {
				player.sendMessage(main.getConfig().getString("messages.noperm").replace(">", "»").replace("&", "§"));
				return false;
			}
			
		}
		return false;
	}

}
