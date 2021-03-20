package fr.mimifan.silvenya.commands.modération;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.mimifan.silvenya.Main;

public class CommandStaffChat implements CommandExecutor, Listener {

	private Main main;
	
	public CommandStaffChat(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		String playername = player.getName();
		if(args.length == 0) {
			if(!main.getStaffChat().containsKey(playername)) {
				main.getStaffChat().put(playername, true);
				player.sendMessage(main.getConfig().getString("staffchat.yep").replace("&", "§").replace(">", "»"));
				return true;
			}
			if(main.getStaffChat().containsKey(playername)) {
				if(main.getStaffChat().containsValue(false)) {
					main.getStaffChat().put(playername, true);
					player.sendMessage(main.getConfig().getString("staffchat.yep").replace("&", "§").replace(">", "»"));
					return true;
				}
				if(main.getStaffChat().containsValue(true)) {
					main.getStaffChat().put(playername, false);
					player.sendMessage(main.getConfig().getString("staffchat.nope").replace("&", "§").replace(">", "»"));
					return true;
				}
			}
		}
		if(args.length >= 1) {
			if(args[0].equalsIgnoreCase("on")) {
				main.getStaffChat().put(playername, true);
				player.sendMessage(main.getConfig().getString("staffchat.yep").replace("&", "§").replace(">", "»"));
				return true;
			}
			if(args[0].equalsIgnoreCase("off")) {
				main.getStaffChat().put(playername, false);
				player.sendMessage(main.getConfig().getString("staffchat.nope").replace("&", "§").replace(">", "»"));
				return true;
			}
			if(!args[0].equalsIgnoreCase("on") || !args[0].equalsIgnoreCase("off")) {
				StringBuilder msg = new StringBuilder();
				for(String part : args) {
					msg.append(" " + part);
				}
				for(Player players: Bukkit.getOnlinePlayers()) {
					if(players.hasPermission("silvenya.staffchat")) {
						players.sendMessage(main.getConfig().getString("prefixs.staffchat").replace("&", "§").replace(">", "»") + "§4" + player.getName() + " §f " + msg.toString());
					}
				}
			}
		}
		
		return false;
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String playername = player.getName();
		if(main.getStaffChat().containsKey(playername)) {
			if(main.getStaffChat().containsValue(true)) {
				event.setCancelled(true);
				for(Player players: Bukkit.getOnlinePlayers()) {
					if(players.hasPermission("silvenya.staffchat")) {
						players.sendMessage(main.getConfig().getString("prefixs.staffchat").replace("&", "§").replace(">", "»") + "§4" + player.getName() + " §f " + event.getMessage());
					}
				}
			}
		}
	}

}
