package fr.mimifan.silvenya.commands.diverses;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandList implements CommandExecutor {

	@SuppressWarnings("unused")
	private Main main;
	
	public CommandList(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		StringBuilder Admin = new StringBuilder();
		StringBuilder SuperModo = new StringBuilder();
		StringBuilder Modo = new StringBuilder();
		StringBuilder Helper = new StringBuilder();
		StringBuilder Seigneur = new StringBuilder();
		StringBuilder Fermier = new StringBuilder();
		StringBuilder Paysan = new StringBuilder();
		int nombre = 0;
		int admin = 0;
		int sm = 0;
		int modo = 0;
		int helper = 0;
		int seigneur = 0;
		int fermier = 0;
		int paysan = 0;
		for(Player players : Bukkit.getOnlinePlayers()) {
			if(!players.isOp()) {
				if(players.hasPermission("nte.admin")) {
					Admin.append("§4" + players.getName() + " §8, ");
					nombre++;
					admin++;
				}
				if(players.hasPermission("nte.supermodo")) {
					SuperModo.append("§9" + players.getName() + " §8, ");
					nombre++;
					sm++;
				}
				if(players.hasPermission("nte.modo")) {
					Modo.append("§9" + players.getName() + " §8, ");
					nombre++;
					modo++;
				}
				if(players.hasPermission("nte.helper")) {
					Helper.append("§a" + players.getName() + " §8, ");
					nombre++;
					helper++;
				}
				if(players.hasPermission("nte.seigneur")) {
					Seigneur.append("§3" + players.getName() + " §8, ");
					nombre++;
					seigneur++;
				}
				if(players.hasPermission("nte.fermier")) {
					Fermier.append("§2" + players.getName() + " §8, ");
					nombre++;
					fermier++;
				}
				if(players.hasPermission("nte.paysan")) {
					Paysan.append("§7" + players.getName() + " §8, ");
					nombre++;
					paysan++;
				}
			} else if(players.isOp()) {
				Admin.append("§4" + players.getName() + " §8, ");
				nombre++;
				admin++;
			}
			
		}
		player.sendMessage("§f--------------- Il y a §b" + nombre + " §fjoueurs connectés ---------------");
		player.sendMessage(" ");
		player.sendMessage("§4" + admin + " Administrateurs §8: " + Admin.toString());
		player.sendMessage("§9" + sm + " Super-Modérateurs §8: " + SuperModo.toString());
		player.sendMessage("§9" + modo + " Modérateurs §8: " + Modo.toString());
		player.sendMessage("§a" + helper + " Guides §8: " + Helper.toString());
		player.sendMessage("§3" + seigneur + " Seigneurs §8: " + Seigneur.toString());
		player.sendMessage("§2" + fermier + " Fermiers §8: " + Fermier.toString());
		player.sendMessage("§7" + paysan + " Paysans §8: " + Paysan.toString());
		player.sendMessage(" ");
		player.sendMessage("§f---------------------------------------------------------");
		
		
		return false;
	}

}
