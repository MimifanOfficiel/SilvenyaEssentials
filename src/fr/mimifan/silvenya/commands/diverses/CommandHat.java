package fr.mimifan.silvenya.commands.diverses;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.mimifan.silvenya.Main;

public class CommandHat implements CommandExecutor {

	private Main main;
	
	public CommandHat(Main main) {
		this.main = main;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		ItemStack hand = player.getItemInHand();
		ItemStack hat = player.getInventory().getHelmet();
		if(hand == null || hand.getType() == Material.AIR) {
			player.sendMessage(main.getConfig().getString("hat.no_hand").replace("&", "§").replace(">", "»"));
			return true;
		} else {
			player.getInventory().setHelmet(hand);
			player.getInventory().remove(hand);
			if(hat != null && hat.getType() != Material.AIR) {
				player.getInventory().addItem(new ItemStack[] { hat });
			}
		}
		
		
		
		return false;
	}

}
