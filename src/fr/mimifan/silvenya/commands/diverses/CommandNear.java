package fr.mimifan.silvenya.commands.diverses;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class CommandNear implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		StringBuilder nearb = new StringBuilder();
		int maxDist = 500;
		for (Entity e : player.getNearbyEntities(maxDist, maxDist, maxDist)) {
			if (e instanceof Player && !((Player)e).getGameMode().equals(GameMode.SPECTATOR)) {
				double distance = (int)player.getLocation().distance(e.getLocation());
				nearb.append("§7" + e.getName() + " (§f" + distance + "m§7) §8, ");
			} 
		} 
		player.sendMessage(nearb.toString()); 
			
		return false;
	}
}
