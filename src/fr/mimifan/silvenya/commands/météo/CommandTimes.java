package fr.mimifan.silvenya.commands.météo;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandTimes implements CommandExecutor {

	private Main main;
	
	public CommandTimes(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("time")) {
			if(args.length == 0) {
				player.sendMessage(main.getConfig().getString("meteo.time.no_arg").replace("&", "§").replace(">", "»"));
			}
			if(args.length == 1) {
				player.sendMessage(main.getConfig().getString("meteo.time.no_arg").replace("&", "§").replace(">", "»"));
				return true;
			}
			if(args.length == 2 && args[0].equalsIgnoreCase("set")) {
				if(args[1].equalsIgnoreCase("day")) {
					player.getWorld().setTime(1000L);
					player.sendMessage(main.getConfig().getString("meteo.time.day").replace("&", "§").replace(">", "»"));
				}
				if(args[1].equalsIgnoreCase("night")) {
					player.getWorld().setTime(13000L);
					player.sendMessage(main.getConfig().getString("meteo.time.night").replace("&", "§").replace(">", "»"));
				}
				if(!args[1].equalsIgnoreCase("day") && !args[1].equalsIgnoreCase("night")) {
					try {
						int time = Integer.valueOf(args[1]).intValue();
						player.getWorld().setTime(time);
						player.sendMessage(main.getConfig().getString("prefixs.time").replace("&", "§").replace(">", "»") + "Le temps a été défini sur §b" + time + " §f!");
					} catch (NumberFormatException e) {
						player.sendMessage(main.getConfig().getString("meteo.time.no_arg").replace("&", "§").replace(">", "»"));
					}
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("day")) {
			player.getWorld().setTime(1000L);
			player.sendMessage(main.getConfig().getString("meteo.time.day").replace("&", "§").replace(">", "»"));
		}
		if(cmd.getName().equalsIgnoreCase("night")) {
			player.getWorld().setTime(13000L);
			player.sendMessage(main.getConfig().getString("meteo.time.night").replace("&", "§").replace(">", "»"));
		}
		if(cmd.getName().equalsIgnoreCase("sun")) {
			player.getWorld().setStorm(false);
			player.getWorld().setThundering(false);
			player.sendMessage(main.getConfig().getString("meteo.sun").replace("&", "§").replace(">", "»"));
		}
		if(cmd.getName().equalsIgnoreCase("rain")) {
			player.getWorld().setStorm(true);
			player.sendMessage(main.getConfig().getString("meteo.rain").replace("&", "§").replace(">", "»"));
		}
		if(cmd.getName().equalsIgnoreCase("thunder")) {
			player.getWorld().setThundering(true);
			player.sendMessage(main.getConfig().getString("meteo.thunder").replace("&", "§").replace(">", "»"));
		}
		
		return false;
	}

}
