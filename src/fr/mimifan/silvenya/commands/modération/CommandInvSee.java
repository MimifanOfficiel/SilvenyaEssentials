package fr.mimifan.silvenya.commands.modération;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.mimifan.silvenya.Main;

public class CommandInvSee implements CommandExecutor, Listener {

	private Main main;
	
	public CommandInvSee(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			player.sendMessage(main.getConfig().getString("invsee.noplayer").replace("&", "§").replace(">", "»"));
		}
		if(args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				if(target.isOnline()) {
					if(target != sender) {
						if(player.hasPermission("silvenya.bypass.invsee")) {
							Inventory invtarget = target.getInventory();
							player.openInventory(invtarget);
							player.sendMessage(main.getConfig().getString("invsee.opening").replace("&", "§").replace(">", "»") + target.getName());
						} else {
							Inventory inventory = Bukkit.createInventory(target, 36, "Invsee");
							inventory.setContents(target.getInventory().getContents());
							player.openInventory(inventory);
							player.sendMessage(main.getConfig().getString("invsee.opening").replace("&", "§").replace(">", "»") + target.getName());
						}
					} else {
						player.sendMessage(main.getConfig().getString("prefixs.invsee").replace("&", "§").replace(">", "»") + "Vous ne pouvez pas effectuer cette commande sur vous-même");
					}
				}
			} else {
				player.sendMessage(main.getConfig().getString("prefixs.invsee").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[0] + " §fn'est pas connecté !");
			}
		}
		return false;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory inventory = event.getClickedInventory();
		int clickedSlot = event.getSlot();
		ItemStack itemStack = inventory.getItem(clickedSlot);
		if(itemStack.hasItemMeta()) {
			if(event.getView().getTitle().equalsIgnoreCase("Invsee")) {
				if(!player.hasPermission("silvenya.bypass.see")) {
					event.setCancelled(true);
				} else if(player.hasPermission("silvenya.bypass.see")) {
					event.setCancelled(false);
				}
			}
		}
	}

}
