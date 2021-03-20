package fr.mimifan.silvenya.commands.téléportation;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandTPA implements CommandExecutor {

	private Main main;
	
	public CommandTPA(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("tpa")) {
			if(args.length == 0) {
				player.sendMessage(main.getConfig().getString("teleportation.tpa.less_args").replace("&", "§").replace(">", "»"));
			}
			if(args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null) {
					if(target.isOnline()) {
						if(target != sender) {
							if(!main.getTpa().containsKey(player)) {
								main.getTpa().put(target, player);
								player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez envoyé une demande de téléportation à §b" + target.getName());
								target.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez reçu une demande de téléportation de §b" + player.getName());
								target.sendMessage("§b/tpaccept | /tpyes §fpour accepter");
								target.sendMessage("§b/tpno | /tpdeny §fpour refuser");
							}
						} else {
							player.sendMessage(main.getConfig().getString("teleportation.tpa.selfask").replace("&", "§").replace(">", "»"));
						}
					}
				} else {
					player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[0] + " §fn'est pas connecté !");
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("tpahere")) {
			if(args.length == 0) {
				player.sendMessage(main.getConfig().getString("teleportation.tpa.less_args").replace("&", "§").replace(">", "»"));
			}
			if(args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null) {
					if(target.isOnline()) {
						if(target != sender) {
							if(!main.getTpaHere().containsKey(player)) {
								main.getTpaHere().put(target, player);
								player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez envoyé une demande de téléportation à §b" + target.getName());
								target.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "§b" + player.getName() + " §fsouhaite vous téléporter à lui/elle");
								target.sendMessage("§b/tpaccept | /tpyes §fpour accepter");
								target.sendMessage("§b/tpno | /tpdeny §fpour refuser");
							}
						} else {
							player.sendMessage(main.getConfig().getString("teleportation.tpa.selfask").replace("&", "§").replace(">", "»"));
						}
					}
				} else {
					player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[0] + " §fn'est pas connecté !");
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("tpyes") || cmd.getName().equalsIgnoreCase("tpaccept")) {
			if(main.getTpa().containsKey(player)) {
				Player target = (Player)main.getTpa().get(player);
				if(target != null) {
					if(target.isOnline()) {
						if(target != sender) {
							target.teleport(player.getLocation());
							player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez accepté la demande de téléportation de §b" + target.getName());
							target.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "§b" + player.getName() + " §fa accepté votre demande de téléportation");
							main.getTpa().remove(player);
						}
					} else {
						player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "§b" + target.getName() + " §fn'est plus connecté !");
					}
				} else {
					player.sendMessage(main.getConfig().getString("teleportation.tpyes.noask").replace("&", "§").replace(">", "»"));
				}
			} else if(main.getTpaHere().containsKey(player)) {
				Player target = (Player) main.getTpaHere().get(player);
				if(target != null) {
					if(target.isOnline()) {
						if(target != sender) {
							player.teleport(target.getLocation());
							player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez accepté la demande de téléportation de §b" + target.getName());
							target.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "§b" + player.getName() + " §fa accepté votre demande de téléportation");
							main.getTpaHere().remove(player);
						}
					} else {
						player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "§b" + target.getName() + " §fn'est plus connecté !");
					}
				} else {
					player.sendMessage(main.getConfig().getString("teleportation.tpyes.noask").replace("&", "§").replace(">", "»"));
				}
			} else {
				player.sendMessage(main.getConfig().getString("teleportation.tpyes.noask").replace("&", "§").replace(">", "»"));
			}
		}
		if(cmd.getName().equalsIgnoreCase("tpno") || cmd.getName().equalsIgnoreCase("tpdeny")) {
			if(main.getTpa().containsKey(player)) {
				Player target = (Player) main.getTpa().get(player);
				if(target != null) {
					if(target.isOnline()) {
						if(target != sender) {
							main.getTpa().remove(player);
							player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez refusé la demande de téléportation de §b" + target.getName());
							target.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "§b" + player.getName() + " §fa refusé votre demande de téléportation");
						}
					}
				} else {
					player.sendMessage(main.getConfig().getString("teleportation.tpno.noask").replace("&", "§").replace(">", "»"));
				}
			} else if(main.getTpaHere().containsKey(player)) {
				Player target = (Player) main.getTpaHere().get(player);
				if(target != null) {
					if(target.isOnline()) {
						if(target != sender) {
							main.getTpaHere().remove(player);
							player.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez refusé la demande de téléportation de §b" + target.getName());
							target.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "§b" + player.getName() + " §fa refusé votre demande de téléportation");
						}
					}
				} else {
					player.sendMessage(main.getConfig().getString("teleportation.tpno.noask").replace("&", "§").replace(">", "»"));
				}
			} else {
				player.sendMessage(main.getConfig().getString("teleportation.tpno.noask").replace("&", "§").replace(">", "»"));
			}
		}
		if (cmd.getName().equalsIgnoreCase("tpaall")) {
			for (Player targets : Bukkit.getOnlinePlayers()) {
				if (targets != sender && !main.getTpaHere().containsKey(player)) {
					main.getTpaHere().put(targets, player);
					targets.sendMessage(main.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "§b" + player.getName() + "§f souhaite vous téléporter sur lui/elle");
					targets.sendMessage("§b/tpaccept | /tpyes §fpour accepter");
					targets.sendMessage("§b/tpno | /tpdeny §fpour refuser");
				}
			}
			player.sendMessage(main.getConfig().getString("teleportation.tpaall.asked").replace("&", "§").replace(">", "»"));
		}
		
		
		return false;
	}

}
