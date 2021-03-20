package fr.mimifan.silvenya.commands.important;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandClearLag implements CommandExecutor {

	private Main main;
	
	public CommandClearLag(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			player.sendMessage(main.getConfig().getString("clearlag.less_args").replace("&", "§").replace(">", "»"));
		}
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("true")) {
				main.getConfig().set("clearlag.autoclear", true);
				player.sendMessage(main.getConfig().getString("clearlag.put_autoclear_true").replace("&", "§").replace(">", "»"));
			}
			if(args[0].equalsIgnoreCase("false")) {
				main.getConfig().set("clearlag.autoclear", false);
				player.sendMessage(main.getConfig().getString("clearlag.put_autoclear_false").replace("&", "§").replace(">", "»"));
			}
			if(args[0].equalsIgnoreCase("clear")) {
				for (World w : Bukkit.getWorlds()) {
					for (Entity e : w.getEntities()) {
						if (e.getType() != EntityType.PLAYER && e.getType() != EntityType.ARMOR_STAND && e.getType() != EntityType.VILLAGER && e.getType() != EntityType.ENDER_CRYSTAL) {
							e.remove();
						}
					} 
				}
				Bukkit.broadcastMessage(main.getConfig().getString("clearlag.cleared").replace("&", "§").replace(">", "»"));
			}
		}
		return false;
	}

}
