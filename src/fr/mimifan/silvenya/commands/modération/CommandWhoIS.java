package fr.mimifan.silvenya.commands.modération;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandWhoIS implements CommandExecutor {

	private Main main;
	
	public CommandWhoIS(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			player.sendMessage(main.getConfig().getString("player_info.whois.no_player").replace("&", "§").replace(">", "»"));
		}
		if(args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				if(target.isOnline()) {
					player.sendMessage("§b--------------------- WhoIs " + target.getName() + " ---------------------");
					player.sendMessage(" ");
					player.sendMessage("Pseudo du Joueur: §b" + target.getName());
					player.sendMessage("UUID du Joueur: §b" + target.getUniqueId());
					player.sendMessage("Adresse IP du Joueur: §b" + target.getAddress());
					if (target.isOp()) {
						player.sendMessage("Est op: §bOui");
					} else {
						player.sendMessage("Est op: §bNon");
					} 
					if (target.isFlying()) {
						player.sendMessage("Est en Fly: §bOui");
					} else {
						player.sendMessage("Est en Fly: §bNon");
					} 
					if(target.getGameMode().equals(GameMode.CREATIVE)) {
						player.sendMessage("Mode de Jeu: §bCreative");
					}
					if(target.getGameMode().equals(GameMode.SURVIVAL)) {
						player.sendMessage("Mode de Jeu: §bSurvival");
					}
					if(target.getGameMode().equals(GameMode.ADVENTURE)) {
						player.sendMessage("Mode de Jeu: §bAdventure");
					}
					if(target.getGameMode().equals(GameMode.SPECTATOR)) {
						player.sendMessage("Mode de Jeu: §bSpectateur");
					}
					player.sendMessage(" ");
					player.sendMessage("§b--------------------- WhoIs " + target.getName() + " ---------------------");
				}
			} else {
				player.sendMessage(main.getConfig().getString("prefixs.whois").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[0] + " §fn'est pas connecté !");
			}
		}
		
		return false;
	}

}
