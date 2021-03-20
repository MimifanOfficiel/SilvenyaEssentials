package fr.mimifan.silvenya.commands.météo;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandWeather implements CommandExecutor {

	private Main main;
	
	public CommandWeather(Main main) {
		this.main = main;
	}



	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			player.sendMessage(main.getConfig().getString("meteo.weather.no_arg").replace("&", "§").replace(">", "»"));
		}
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("clear")) {
				player.getWorld().setStorm(false);
				player.getWorld().setThundering(false);
				player.sendMessage(main.getConfig().getString("meteo.weather.clear").replace("&", "§").replace(">", "»"));
			}
			if(args[0].equalsIgnoreCase("rain")) {
				player.getWorld().setStorm(true);
				player.sendMessage(main.getConfig().getString("meteo.weather.rain").replace("&", "§").replace(">", "»"));
			}
			if(args[0].equalsIgnoreCase("thunder")) {
				player.getWorld().setThundering(true);
				player.sendMessage(main.getConfig().getString("meteo.weather.thunder").replace("&", "§").replace(">", "»"));
			}
			if(!args[0].equalsIgnoreCase("rain") && !args[0].equalsIgnoreCase("thunder") && !args[0].equalsIgnoreCase("clear")) {
				player.sendMessage(main.getConfig().getString("meteo.weather.no_arg").replace("&", "§").replace(">", "»"));
			}
		}
		return false;
	}

}
