package fr.mimifan.silvenya.commands.modération;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandFly implements CommandExecutor {

	private Main main;
	
	public CommandFly(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			if(!player.getAllowFlight()) {
				player.setAllowFlight(true);
				player.sendMessage(main.getConfig().getString("mouvements.fly.fly_on").replace("&", "§").replace(">", "»"));
				return true;
			} else {
				player.setAllowFlight(false);
				player.sendMessage(main.getConfig().getString("mouvements.fly.fly_off").replace("&", "§").replace(">", "»"));
				return true;
			}
		}
		if(args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				if(target.isOnline()) {
					if(target != sender) {
						if(target.getAllowFlight()) {
							target.setAllowFlight(false);
							target.sendMessage(main.getConfig().getString("mouvements.fly.fly_off").replace("&", "§").replace(">", "»"));
							player.sendMessage(main.getConfig().getString("prefixs.fly").replace("&", "§").replace(">", "»") + "Le joueur §b" + target.getName() + " §fne peut plus voler !");
							return true;
						} else {
							target.setAllowFlight(true);
							target.sendMessage(main.getConfig().getString("mouvements.fly.fly_on").replace("&", "§").replace(">", "»"));
							player.sendMessage(main.getConfig().getString("prefixs.fly").replace("&", "§").replace(">", "»") + "Le joueur §b" + target.getName() + " §fpeut maintenant voler !");
							return true;
						}
					} else {
						if(player.getAllowFlight()) {
							player.setAllowFlight(false);
							player.sendMessage(main.getConfig().getString("mouvements.fly.fly_off").replace("&", "§").replace(">", "»"));
							return true;
						} else {
							player.setAllowFlight(true);
							player.sendMessage(main.getConfig().getString("mouvements.fly.fly_on").replace("&", "§").replace(">", "»"));
							return true;
						}
					}
				}
			} else {
				player.sendMessage(main.getConfig().getString("prefixs.fly").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[0] + " §fn'est pas connecté !");
			}
		}
		return false;
	}

}
