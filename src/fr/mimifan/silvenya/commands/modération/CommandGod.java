package fr.mimifan.silvenya.commands.modération;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import fr.mimifan.silvenya.Main;

public class CommandGod implements CommandExecutor, Listener {

	private Main main;
	
	public CommandGod(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			if(sender instanceof Player) {
				Player player = (Player)sender;
				String playername = player.getName();
				if(main.getGod().containsKey(playername)) {
					player.setInvulnerable(false);
					player.sendMessage(main.getConfig().getString("god.god_off").replace("&", "§").replace(">", "»"));
					main.getGod().remove(playername);
					return true;
			}
				if(!main.getGod().containsKey(playername)) {
					player.setInvulnerable(true);
					player.sendMessage(main.getConfig().getString("god.god_on").replace("&", "§").replace(">", "»"));
					main.getGod().put(playername, true);
					return true;
				}
			}
			
		}
		if(args.length == 1) {
			if(sender instanceof Player) {
				Player player = (Player)sender;
				String playername = player.getName();
			if(args[0].equalsIgnoreCase("on")) {
				player.setInvulnerable(true);
				player.sendMessage(main.getConfig().getString("god.god_on").replace("&", "§").replace(">", "»"));
				main.getGod().put(playername, true);
				return true;
			}
			if(args[0].equalsIgnoreCase("off")) {
				player.setInvulnerable(false);
				player.sendMessage(main.getConfig().getString("god.god_off").replace("&", "§").replace(">", "»"));
				main.getGod().remove(playername);
				return true;
			}
		}
			if(!args[0].equalsIgnoreCase("on") && !args[0].equalsIgnoreCase("off")) {
				Player player = (Player)sender;
				String playername = player.getName();
				Player target = Bukkit.getPlayer(args[0]);
				String targetname = target.getName();
				if(target != null) {
					if(target.isOnline() && target != sender) {
							if(main.getGod().containsKey(targetname)) {
								target.setInvulnerable(false);
								target.sendMessage(main.getConfig().getString("god.god_off").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.god").replace("&", "§").replace(">", "»") + "§b" + target.getName() + " §fest maintenant invulnérable !");
								main.getGod().remove(targetname);
								return true;
							} else if(!main.getGod().containsKey(targetname)) {
								target.setInvulnerable(true);
								target.sendMessage(main.getConfig().getString("god.god_on").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.god").replace("&", "§").replace(">", "»") + "§b" + target.getName() + " §fn'est plus invulnérable !");
								main.getGod().put(targetname, true);
								return true;
							}
						} else {
							if(main.getGod().containsKey(playername)) {
								player.setInvulnerable(false);
								player.sendMessage(main.getConfig().getString("god.god_off").replace("&", "§").replace(">", "»"));
								main.getGod().remove(playername);
							} else if(!main.getGod().containsKey(playername)) {
								player.setInvulnerable(true);
								player.sendMessage(main.getConfig().getString("god.god_on").replace("&", "§").replace(">", "»"));
								main.getGod().put(playername, true);
							}
						}
					}
				} 
			}
		if(args.length == 2) {
			Player target = Bukkit.getPlayer(args[0]);
			String targetname = target.getName();
			if(args[1].equalsIgnoreCase("on")) {
				if(target != null) {
					if(target.isOnline()) {
						if(target != sender) {
							target.setInvulnerable(true);
							target.sendMessage(main.getConfig().getString("god.god_on").replace("&", "§").replace(">", "»"));
							sender.sendMessage(main.getConfig().getString("prefixs.god").replace("&", "§").replace(">", "»") + "§b" + target.getName() + " §fest maintenant invulnérable !");
							main.getGod().put(targetname, true);
						}
					}
				}
			}
			if(args[1].equalsIgnoreCase("off")) {
				if(target != null) {
					if(target.isOnline()) {
						if(target != sender) {
							target.setInvulnerable(false);
							target.sendMessage(main.getConfig().getString("god.god_off").replace("&", "§").replace(">", "»"));
							sender.sendMessage(main.getConfig().getString("prefixs.god").replace("&", "§").replace(">", "»") + "§b" + target.getName() + " §fn'est plus invulnérable !");
							main.getGod().remove(targetname);
						}
					}
				}
			}
		}
		return false;
	}
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		Entity entity = event.getEntity();
		if(entity instanceof Player) {
			String name = entity.getName();
			if(main.getGod().containsKey(name)) {
				event.setCancelled(true);
			} else if(!main.getGod().containsKey(name)) {
				event.setCancelled(false);
			}
		}
	}

}
