package fr.mimifan.silvenya.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.mimifan.silvenya.Main;

public class ChatListener implements Listener, CommandExecutor {
	
	private Main main;
	
	public ChatListener(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String message = event.getMessage();
		String admin = main.getConfig().getString("chat.prefixs.admin").replace("&", "§");
		String sm = main.getConfig().getString("chat.prefixs.sm").replace("&", "§");
		String modo = main.getConfig().getString("chat.prefixs.modo").replace("&", "§");
		String helper = main.getConfig().getString("chat.prefixs.helper").replace("&", "§");
		String seigneur = main.getConfig().getString("chat.prefixs.seigneur").replace("&", "§");
		String fermier = main.getConfig().getString("chat.prefixs.fermier").replace("&", "§");
		String paysan = main.getConfig().getString("chat.prefixs.paysan").replace("&", "§");
		if(main.getConfig().getBoolean("chat.locked") == true) {
			if(player.hasPermission(main.getConfig().getString("chat.locked_bypass"))) {
				event.setCancelled(false);
				if(player.hasPermission("nte.admin")) {
					event.setFormat(admin + "§4" + player.getName() + " §8> §f" + message);
				}
				if(player.hasPermission("nte.supermodo")) {
					event.setFormat(sm + "§9" + player.getName() + " §8> §f" + message);
				}
				if(player.hasPermission("nte.modo")) {
					event.setFormat(modo + "§9" + player.getName() + " §8> §f" + message);
				}
				if(player.hasPermission("nte.helper")) {
					event.setFormat(helper + "§a" + player.getName() + " §8> §f" + message);
				}
				if(player.hasPermission("nte.seigneur")) {
					event.setFormat(seigneur + "§3" + player.getName() + " §8> §f" + message);
				}
				if(player.hasPermission("nte.fermier")) {
					event.setFormat(fermier + "§2" + player.getName() + " §8> §f" + message);
				}
				if(player.hasPermission("nte.paysan")) {
					event.setFormat(paysan + "§7" + player.getName() + " §8> §f" + message);
				}
				if(player.isOp()) {
					event.setFormat(admin + "§4" + player.getName() + " §8> §f" + message);
				}
			} else {
				event.setCancelled(true);
				player.sendMessage(main.getConfig().getString("chat.locked_msg").replace("&", "§").replace(">", "»"));
			}
			
		}
		if(main.getConfig().getBoolean("chat.locked") == false) {
			if(player.hasPermission("nte.admin")) {
				event.setFormat(admin + "§4" + player.getName() + " §8> §f" + message);
			}
			if(player.hasPermission("nte.supermodo")) {
				event.setFormat(sm + "§9" + player.getName() + " §8> §f" + message);
			}
			if(player.hasPermission("nte.modo")) {
				event.setFormat(modo + "§9" + player.getName() + " §8> §f" + message);
			}
			if(player.hasPermission("nte.helper")) {
				event.setFormat(helper + "§a" + player.getName() + " §8> §f" + message);
			}
			if(player.hasPermission("nte.seigneur")) {
				event.setFormat(seigneur + "§3" + player.getName() + " §8> §f" + message);
			}
			if(player.hasPermission("nte.fermier")) {
				event.setFormat(fermier + "§2" + player.getName() + " §8> §f" + message);
			}
			if(player.hasPermission("nte.paysan")) {
				event.setFormat(paysan + "§7" + player.getName() + " §8> §f" + message);
			}
			if(player.isOp()) {
				event.setFormat(admin + "§4" + player.getName() + " §8> §f" + message);
			}
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,  String label, String[] args) {
		Player player = (Player)sender;
		List<String> l = new ArrayList<>();
		if(cmd.getName().equalsIgnoreCase("chat")) {
			if(args.length == 0) {
				Inventory inv = Bukkit.createInventory(null, 9, main.getConfig().getString("chat.gui.title").replace("&", "§").replace(">", "»"));
				
				ItemStack clear = new ItemStack(Material.matchMaterial(main.getConfig().getString("chat.gui.items.clear")));
				ItemStack lock = new ItemStack(Material.matchMaterial(main.getConfig().getString("chat.gui.items.lock")));
				ItemStack unlock = new ItemStack(Material.matchMaterial(main.getConfig().getString("chat.gui.items.unlock")));
				ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
				
				
				ItemMeta clearm = clear.getItemMeta();
				ItemMeta lockm = lock.getItemMeta();
				ItemMeta unlockm = unlock.getItemMeta();
				ItemMeta glassm = glass.getItemMeta();
				
				clearm.setDisplayName(main.getConfig().getString("chat.gui.items_name.clear").replace("&", "§").replace(">", "»"));
				lockm.setDisplayName(main.getConfig().getString("chat.gui.items_name.lock").replace("&", "§").replace(">", "»"));
				unlockm.setDisplayName(main.getConfig().getString("chat.gui.items_name.unlock").replace("&", "§").replace(">", "»"));
				glassm.setDisplayName(" ");
				
				l.add(main.getConfig().getString("chat.gui.items_lore.clear").replace("&", "§").replace(">", "»"));
				clearm.setLore(l);
				l.clear();
				
				l.add(main.getConfig().getString("chat.gui.items_lore.lock").replace("&", "§").replace(">", "»"));
				lockm.setLore(l);
				l.clear();
				
				l.add(main.getConfig().getString("chat.gui.items_lore.unlock").replace("&", "§").replace(">", "»"));
				unlockm.setLore(l);
				l.clear();
				
				clear.setItemMeta(clearm);
				lock.setItemMeta(lockm);
				unlock.setItemMeta(unlockm);
				glass.setItemMeta(glassm);
				
				
				inv.setItem(4, clear);
				inv.setItem(0, lock);
				inv.setItem(8, unlock);
				inv.setItem(1, glass);
				inv.setItem(2, glass);
				inv.setItem(3, glass);
				inv.setItem(5, glass);
				inv.setItem(6, glass);
				inv.setItem(7, glass);
				
				player.openInventory(inv);
			}
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("clear")) {
					int i = 0;
					while (i < 200) {
						Bukkit.broadcastMessage(" ");
						i++;
					}
					Bukkit.broadcastMessage(main.getConfig().getString("annonce.annonce_prefix").replace("&", "§").replace(">", "»") + "Le chat a été effacé par §b" + player.getName());
					return true;
				}
				if(args[0].equalsIgnoreCase("lock")) {
					main.getConfig().set("chat.locked", true);
					Bukkit.broadcastMessage(main.getConfig().getString("annonce.annonce_prefix").replace("&", "§").replace(">", "»") + "§b" + player.getName() + "§c vient de bloquer le chat !");
					return true;
				}
				if(args[0].equalsIgnoreCase("unlock")) {
					main.getConfig().set("chat.locked", false);
					Bukkit.broadcastMessage(main.getConfig().getString("annonce.annonce_prefix").replace("&", "§").replace(">", "»") + "§b" + player.getName() + "§c vient de débloquer le chat !");
					return true;
				}
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
			if (event.getView().getTitle().equals(main.getConfig().getString("chat.gui.title").replace("&", "§").replace(">", "»"))) {
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("chat.gui.items_name.clear").replace("&", "§").replace(">", "»"))) {
					player.performCommand("chat clear");
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("chat.gui.items_name.lock").replace("&", "§").replace(">", "»"))) {
					player.performCommand("chat lock");
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("chat.gui.items_name.unlock").replace("&", "§").replace(">", "»"))) {
					player.performCommand("chat unlock");
					player.closeInventory();
				}
				if(itemStack.getType() == Material.BLACK_STAINED_GLASS_PANE) {
					event.setCancelled(true);
				}
			}
		}
	}
}
