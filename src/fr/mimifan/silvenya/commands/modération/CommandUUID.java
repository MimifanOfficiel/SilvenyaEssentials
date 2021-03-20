package fr.mimifan.silvenya.commands.modération;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandUUID implements CommandExecutor {

	private Main main;
	
	public CommandUUID(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			player.sendMessage(main.getConfig().getString("player_info.uuid.no_player").replace("&", "§").replace(">", "»"));
		}
		if(args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				if(target.isOnline()) {
					player.sendMessage(main.getConfig().getString("prefixs.uuid").replace("&", "§").replace(">", "»") + "L'UUID du joueur §b" + target.getName() + " §fest §b" + target.getUniqueId());
				}
			} else {
				player.sendMessage(main.getConfig().getString("prefixs.uuid").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[0] + " §fn'est plas connecté !");
			}
		}
		return false;
	}

}
