package fr.mimifan.silvenya.commands.diverses;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandPtime implements CommandExecutor {

	private Main main;
	
	public CommandPtime(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			player.sendMessage(main.getConfig().getString("meteo.ptime.no_arg").replace("&", "§").replace(">", "»"));
		}
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("day")) {
				player.setPlayerTime(1000L, false);
				player.sendMessage(main.getConfig().getString("meteo.ptime.day").replace("&", "§").replace(">", "»"));
			}
			if(args[0].equalsIgnoreCase("night")) {
				player.setPlayerTime(13000L, false);
				player.sendMessage(main.getConfig().getString("meteo.ptime.night").replace("&", "§").replace(">", "»"));
			}
			if(args[0].equalsIgnoreCase("no")) {
				player.resetPlayerTime();
				player.sendMessage(main.getConfig().getString("meteo.ptime.clear").replace("&", "§").replace(">", "»"));
			}
			if(!args[0].equalsIgnoreCase("day") && !args[0].equalsIgnoreCase("night") && !args[0].equalsIgnoreCase("no")) {
				try {
					int time = Integer.valueOf(args[0]).intValue();
					player.setPlayerTime(time, false);
					player.sendMessage(main.getConfig().getString("prefixs.time").replace("&", "§").replace(">", "»") + "Votre temps a été défini à §b" + time);
				} catch(NumberFormatException e) {
					player.sendMessage(main.getConfig().getString("meteo.ptime.use").replace("&", "§").replaceFirst(">", "»"));
				}
			}
		}
		return false;
	}

}
