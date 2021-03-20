package fr.mimifan.silvenya.commands.modération;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandIP implements CommandExecutor {

	private Main main;
	
	public CommandIP(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			player.sendMessage(main.getConfig().getString("player_info.ip.no_player").replace("&", "§").replace(">", "»"));
		}
		if(args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				if(target.isOnline()) {
					player.sendMessage(main.getConfig().getString("prefixs.ip").replace("&", "§").replace(">", "»") + "L'adresse IP du joueur §b" + target.getName() +  " §fest §b" + target.getAddress());
				}
			} else {
				player.sendMessage(main.getConfig().getString("prefixs.ip").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[0] + " §fn'est pas connecté !");
			}
		}
		
		return false;
	}

}
