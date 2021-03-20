package fr.mimifan.silvenya.commands.gamemodes;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandGMS implements CommandExecutor {
	
	private Main main;
	public CommandGMS(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			player.setGameMode(GameMode.SURVIVAL);
			player.sendMessage(main.getConfig().getString("gamemode.self0").replace("&", "§").replace(">", "»"));
		}
		if(args.length == 1) {
			if(player.hasPermission(main.getConfig().getString("gamemode.othergmperm"))) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null) {
					if(target.isOnline()) {
						if(target != sender) {
							target.setGameMode(GameMode.SURVIVAL);
							target.sendMessage(main.getConfig().getString("gamemode.self0").replace("&", "§").replace(">", "»"));
							player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "§b" + target.getName() + " §fest maintenant en Survie !");
						} else {
							player.setGameMode(GameMode.SURVIVAL);
							player.sendMessage(main.getConfig().getString("gamemode.self0").replace("&", "§").replace(">", "»"));
						}
					}
				} else {
					player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[0] + " §fn'est pas connecté !");
				}
			}
		}
		return false;
	}

}
