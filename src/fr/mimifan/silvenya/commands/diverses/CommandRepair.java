package fr.mimifan.silvenya.commands.diverses;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.mimifan.silvenya.Main;

public class CommandRepair implements CommandExecutor {

	private Main main;
	
	public CommandRepair(Main main) {
		this.main = main;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		ItemStack hand = player.getItemInHand();
		if(hand != null && hand.getType() != Material.AIR) {
				hand.setDurability((short)-4000);
				player.sendMessage(main.getConfig().getString("repair.repaired").replace("&", "§").replace(">", "»"));
		} else {
			player.sendMessage(main.getConfig().getString("repair.no_item").replace("&", "§").replace(">", "»"));
		}
		return false;
	}

}
