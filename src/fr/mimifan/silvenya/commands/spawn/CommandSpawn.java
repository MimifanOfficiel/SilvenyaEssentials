package fr.mimifan.silvenya.commands.spawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandSpawn implements CommandExecutor {

	private Main main;
	
	public CommandSpawn(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			if(main.getConfig().getBoolean("spawn.set") == true) {
				String world = main.getConfig().getString("spawn.world");
				double x = main.getConfig().getDouble("spawn.x");
				double y = main.getConfig().getDouble("spawn.y");
				double z = main.getConfig().getDouble("spawn.z");
				double yaw = main.getConfig().getDouble("spawn.yaw");
				double pitch = main.getConfig().getDouble("spawn.pitch");
				
				Location loc = new Location(Bukkit.getWorld(world), x, y, z);
				loc.setYaw((float)yaw);
				loc.setPitch((float)pitch);
				
				player.teleport(loc);
				player.sendMessage(main.getConfig().getString("spawn.teleported").replace("&", "§").replace(">", "»"));
			} else {
				player.sendMessage(main.getConfig().getString("spawn.not_def").replace("&", "§").replace(">", "»"));
			}
		}
		if(args.length == 1) {
			if(main.getConfig().getBoolean("spawn.set") == true) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null) {
					if(target.isOnline()) {
						if(target != sender) {
							String world = main.getConfig().getString("spawn.world");
							double x = main.getConfig().getDouble("spawn.x");
							double y = main.getConfig().getDouble("spawn.y");
							double z = main.getConfig().getDouble("spawn.z");
							double yaw = main.getConfig().getDouble("spawn.yaw");
							double pitch = main.getConfig().getDouble("spawn.pitch");
							
							Location loc = new Location(Bukkit.getWorld(world), x, y, z);
							loc.setYaw((float)yaw);
							loc.setPitch((float)pitch);
							
							target.teleport(loc);
							target.sendMessage(main.getConfig().getString("spawn.teleported").replace("&", "§").replace(">", "»"));
							player.sendMessage(main.getConfig().getString("prefixs.spawn").replace("&", "§").replace(">", "»") + "§b" + target.getName() + " §fa été téléporté au spawn !");
						} else {
							String world = main.getConfig().getString("spawn.world");
							double x = main.getConfig().getDouble("spawn.x");
							double y = main.getConfig().getDouble("spawn.y");
							double z = main.getConfig().getDouble("spawn.z");
							double yaw = main.getConfig().getDouble("spawn.yaw");
							double pitch = main.getConfig().getDouble("spawn.pitch");
							
							Location loc = new Location(Bukkit.getWorld(world), x, y, z);
							loc.setYaw((float)yaw);
							loc.setPitch((float)pitch);
							
							target.teleport(loc);
							target.sendMessage(main.getConfig().getString("spawn.teleported").replace("&", "§").replace(">", "»"));
						}
					}
				} else {
					player.sendMessage(main.getConfig().getString("prefixs.spawn").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[0] + " §fn'est pas connecté !");
				}
			} else {
				player.sendMessage(main.getConfig().getString("spawn.not_def").replace("&", "§").replace(">", "»"));
			}
		}
		return false;
	}

}
