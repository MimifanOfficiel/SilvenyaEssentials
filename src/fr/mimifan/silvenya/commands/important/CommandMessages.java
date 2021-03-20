package fr.mimifan.silvenya.commands.important;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandMessages implements CommandExecutor {

	private Main main;
	
	public CommandMessages(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("msg")) {
			if(args.length == 0) {
				player.sendMessage(main.getConfig().getString("prefixs.msg").replace("&", "§").replace(">", "»") + "Veuillez indiquer un joueur !");
			}
			if(args.length == 1) {
				player.sendMessage(main.getConfig().getString("prefixs.msg").replace("&", "§").replace(">", "»") + "Veuillez indiquer un message !");
			}
			if(args.length >= 2) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null) {
					if(target.isOnline()) {
				        StringBuilder sb = new StringBuilder();
				        for(int i = 1; i < args.length; i++) {
				            if (i > 0) sb.append(" ");
				            sb.append(args[i]);
				        }
						player.sendMessage("§8§l[§6§lMoi §8> §6§l" + target.getName() + "§8§l] §5" + sb.toString());
						target.sendMessage("§8§l[§6§l" + player.getName() + " §8> §6§lMoi§8§l] §5" + sb.toString());
						main.getMessages().put(target, player);
						return true;
					}
				} else { 
					player.sendMessage(main.getConfig().getString("prefixs.msg").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[0] + " §fn'est pas connecté !");
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("answer")) {
			if(args.length == 0) {
				if(main.getMessages().containsKey(player)) {
					player.sendMessage(main.getConfig().getString("prefixs.msg").replace("&", "§").replace(">", "»") + "Veuillez indiquer un message !");
				} else {
					player.sendMessage(main.getConfig().getString("prefixs.msg").replace("&", "§").replace(">", "»") + "Vous n'avez personne à qui répondre !");
				}
			}
			if(args.length >= 1) {
				if(main.getMessages().containsKey(player)) {
					Player target = (Player) main.getMessages().get(player);
					if(target != null) {
						if(target.isOnline()) {
							StringBuilder msg = new StringBuilder();
							for(String part : args) {
								msg.append(" " + part);
							}
							player.sendMessage("§8§l[§6§lMoi §8> §6§l" + target.getName() + "§8§l] §5" + msg.toString());
							target.sendMessage("§8§l[§6§l" + player.getName() + " §8> §6§lMoi§8§l] §5" + msg.toString());
							main.getMessages().put(target, player);
							return true;
						}
					} else {
						player.sendMessage(main.getConfig().getString("prefixs.msg").replace("&", "§").replace(">", "»") + "Vous n'avez personne à qui répondre !");
					}
				} else {
					player.sendMessage(main.getConfig().getString("prefixs.msg").replace("&", "§").replace(">", "»") + "Vous n'avez personne à qui répondre !");
				}
			}
		}
		
		return false;
	}

}
