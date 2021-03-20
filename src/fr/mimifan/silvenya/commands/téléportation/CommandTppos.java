package fr.mimifan.silvenya.commands.téléportation;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandTppos implements CommandExecutor {

	private Main main;
	public CommandTppos(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length < 3) {
			player.sendMessage(main.getConfig().getString("teleportation.tppos.less_args").replace("&", "§").replace(">", "»"));
		}
		if (args.length == 3) {
			try {
				int x = Integer.valueOf(args[0]);
				int y = Integer.valueOf(args[1]);
				int z = Integer.valueOf(args[2]);
				World world = player.getWorld();
				Location tp = new Location(world, x, y,z);
				player.teleport(tp);
				player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez été téléporté en §b" + x + " " + y + " " + z + " §f!");
			} catch (NumberFormatException e) {
				player.sendMessage(main.getConfig().getString("teleportation.tppos.less_args").replace("&", "§").replace(">", "»"));
			}
		}
		if(args.length == 4) {
			try {
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null) {
					if(target.isOnline()) {
						int x = Integer.valueOf(args[1]);
						int y = Integer.valueOf(args[2]);
						int z = Integer.valueOf(args[3]);
						World world = player.getWorld();
						Location tp = new Location(world, x, y, z);
						target.teleport(tp);
						if(target != sender) {
							target.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez été téléporté en §b" + x + " " + y + " " + z + " §f!");
							player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "§b" + target.getName() + " §fa été téléporté en §b" + x + " " + y + " " + z + " §f!");
						} else {
							player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez été téléporté en §b" + x + " " + y + " " + z + " §f!");
						}
						
					}
				} else {
					player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[0] + " §fn'est pas connecté !");
				}
				
			} catch (NumberFormatException e) {
				player.sendMessage(main.getConfig().getString("teleportation.tppos.less_args").replace("&", "§").replace(">", "»"));
			}
		}
		return false;
	}

}
