package fr.mimifan.silvenya.commands.diverses;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CommandTrash implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		Inventory inv = Bukkit.createInventory(null, 36, "Poubelle");
		player.openInventory(inv);
		return false;
	}

}
