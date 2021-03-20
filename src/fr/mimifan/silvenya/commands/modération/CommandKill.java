package fr.mimifan.silvenya.commands.modération;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandKill implements CommandExecutor {

	private Main main;
	
	public CommandKill(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			player.sendMessage(main.getConfig().getString("killing.kill.no_player").replace("&", "§").replace(">", "»"));
		}
		if(args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				if(target.isOnline()) {
					if(target != sender) {
						if(!target.hasPermission(main.getConfig().getString("killing.kill.not_killed_perm"))) {
							target.setHealth(0.0D);
							player.sendMessage(main.getConfig().getString("prefixs.kill").replace("&", "§").replace(">", "»") + "Vous avez tué le joueur §b" + target.getName() + " §f!");
						} else {
							player.sendMessage(main.getConfig().getString("killing.kill.not_killed").replace("&", "§").replace(">", "»"));
						}
					}
				}
			} else {
				player.sendMessage(main.getConfig().getString("prefixs.kill").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[0] + " §fn'est pas connecté !");
			}
		}
		return false;
	}

}
