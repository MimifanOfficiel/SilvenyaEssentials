package fr.mimifan.silvenya.commands.diverses;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.mimifan.silvenya.Main;

public class CommandNightVision implements CommandExecutor {

	private Main main;
	
	public CommandNightVision(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			if(player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
				player.removePotionEffect(PotionEffectType.NIGHT_VISION);
				player.sendMessage(main.getConfig().getString("prefixs.nv").replace("&", "§").replace(">", "»") + "Vous n'avez plus NightVision");
			} else {
				player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 255));
				player.sendMessage(main.getConfig().getString("prefixs.nv").replace("&", "§").replace(">", "»") + "Vous avez maintenant NightVision");
			}
		}
		if(args.length == 1){
			if(args[0].equalsIgnoreCase("on")) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 255));
				player.sendMessage(main.getConfig().getString("prefixs.nv").replace("&", "§").replace(">", "»") + "Vous avez maintenant NightVision");
			}
			if(args[0].equalsIgnoreCase("off")) {
				player.removePotionEffect(PotionEffectType.NIGHT_VISION);
				player.sendMessage(main.getConfig().getString("prefixs.nv").replace("&", "§").replace(">", "»") + "Vous n'avez plus NightVision");
			}
			if(!args[0].equalsIgnoreCase("on") || !args[0].equalsIgnoreCase("off")) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null) {
					if(target.isOnline()) {
						if(target != sender) {
							if(target.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
								target.removePotionEffect(PotionEffectType.NIGHT_VISION);
								target.sendMessage(main.getConfig().getString("prefixs.nv").replace("&", "§").replace(">", "»") + "Vous n'avez plus NightVision");
							} else {
								target.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 255));
								target.sendMessage(main.getConfig().getString("prefixs.nv").replace("&", "§").replace(">", "»") + "Vous avez maintenant NightVision");
							}
						} else {
							if(player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
								player.removePotionEffect(PotionEffectType.NIGHT_VISION);
								player.sendMessage(main.getConfig().getString("prefixs.nv").replace("&", "§").replace(">", "»") + "Vous n'avez plus NightVision");
							} else {
								player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 255));
								player.sendMessage(main.getConfig().getString("prefixs.nv").replace("&", "§").replace(">", "»") + "Vous avez maintenant NightVision");
							}
						}
					}
				} else {
					player.sendMessage(main.getConfig().getString("prefixs.nv").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[0] + " §fn'est pas connecté !");
				}
			}
		}
		
		return false;
	}

}
