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

public class CommandEndSee implements CommandExecutor, Listener {

	private Main main;
	
	public CommandEndSee(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			player.sendMessage(main.getConfig().getString("endsee.no_player").replace("&", "§").replace(">", "»"));
		}
		if(args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				if(target.isOnline()) {
					if(target != sender) {
						if(player.hasPermission("silvenya.bypass;invsee")) {
							Inventory ectarget = target.getEnderChest();
							player.openInventory(ectarget);
							player.sendMessage(main.getConfig().getString("endsee.opening").replace("&", "§").replace(">", "»") + target.getName());
						} else {
							Inventory ec = Bukkit.createInventory(target, 27, "Endsee");
							ec.setContents(target.getEnderChest().getContents());
							player.openInventory(ec);
							player.sendMessage(main.getConfig().getString("endsee.opening").replace("&", "§").replace(">", "»") + target.getName());
						}
					}
					
				}
			} else {
				player.sendMessage(main.getConfig().getString("prefixs.endsee").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[0] + " §fn'est pas connecté !");
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
			if(event.getView().getTitle().equalsIgnoreCase("Endsee")) {
				if(!player.hasPermission("silvenya.bypass.invsee")) {
					event.setCancelled(true);
				} else if(player.hasPermission("silvenya.bypass.invsee")) {
					event.setCancelled(false);
				}
			}
		}
	}

}
