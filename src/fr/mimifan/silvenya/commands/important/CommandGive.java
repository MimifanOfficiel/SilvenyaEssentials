package fr.mimifan.silvenya.commands.important;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import fr.mimifan.silvenya.Main;

@SuppressWarnings("deprecation")
public class CommandGive implements CommandExecutor {

	private Main main;
	
	public CommandGive(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			sender.sendMessage(main.getConfig().getString("give.no_nick").replace("&", "§").replace(">", "»"));
		}
		if(args.length == 1) {
			sender.sendMessage(main.getConfig().getString("give.no_item").replace("&", "§").replace(">", "»"));
		}
		if(args.length == 2) {
			String playerName = args[0];
			Player target = sender.getServer().getPlayerExact(playerName);
			if(target != null) {
				if(target.isOnline()) {
					if(target != sender) {
						Material material = Material.matchMaterial(args[1]);
						if(material == null) {
							sender.sendMessage(main.getConfig().getString("prefixs.give").replace("&", "§").replace(">", "»") + "Item inconnu §b" + args[1] + "§f !");
							return true;
						} else {
							ItemStack itemstack1 = new ItemStack(material, 1);
							target.getInventory().addItem(new ItemStack[] { itemstack1 });
							target.sendMessage(main.getConfig().getString("prefixs.give").replace("&", "§").replace(">", "»") + "Vous avez reçu 1 §b" + itemstack1.getType() + " §f!");
							sender.sendMessage(main.getConfig().getString("prefixs.give").replace("&", "§").replace(">", "»") + "1 §b" + itemstack1.getType() + " §fa été give à §b" + target.getName() + " §f!");
							return true;
						}
					} else {
						Material itemType = Material.matchMaterial(args[1]);
						if(itemType == null) {
							sender.sendMessage(main.getConfig().getString("prefixs.give").replace("&", "§").replace(">", "»") + "Item inconnu §b" + args[1] + " §f!");
							return true;
						} else {
							ItemStack itemstack = new ItemStack(itemType, 1);
							target.getInventory().addItem(new ItemStack[] { itemstack });
							target.sendMessage(main.getConfig().getString("prefixs.give").replace("&", "§").replace(">", "»") + "Vous avez reçu 1 §b" + itemstack.getType() + " §f!");
							return true;
						}
					}
				}
			}
		}
		if(args.length == 3) {
			if(args[1].equalsIgnoreCase("player_head")) {
				String playerName = args[0];
				Player target = sender.getServer().getPlayerExact(playerName);
				if(target != null) {
					if(target.isOnline()) {
						if(target != sender) {
							ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
							SkullMeta skullm = (SkullMeta)skull.getItemMeta();
							skullm.setOwner(args[2]);
							skull.setItemMeta((ItemMeta)skullm);
							target.getInventory().addItem(new ItemStack[] { skull });
							target.updateInventory();
							target.sendMessage(main.getConfig().getString("prefixs.give").replace("&", "§").replace(">", "»") + "Vous avez reçu 1 tête de §b" + args[2] + " §f!");
							sender.sendMessage(main.getConfig().getString("prefixs.give").replace("&", "§").replace(">", "»") + "§b" + target.getName() + " §fa reçu 1 tête de §b" + args[2] + " §f!");
						} else {
							ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
							SkullMeta skullm = (SkullMeta)skull.getItemMeta();
							skullm.setOwner(args[2]);
							skull.setItemMeta((ItemMeta)skullm);
							target.getInventory().addItem(new ItemStack[] { skull });
							target.updateInventory();
							target.sendMessage(main.getConfig().getString("prefixs.give").replace("&", "§").replace(">", "»") + "Vous avez reçu 1 tête de §b" + args[2] + " §f!");
						}
					}
				}
			} else {
				String playerName = args[0];
				Player target = sender.getServer().getPlayerExact(playerName);
				int quantite = Integer.valueOf(args[2]).intValue();
				if(target != null) {
					if(target.isOnline()) {
						if(target != sender) {
							Material material = Material.matchMaterial(args[1]);
							if(material == null) {
								sender.sendMessage(main.getConfig().getString("prefixs.give").replace("&", "§").replace(">", "»") + "Item inconnu §b" + args[1] + " §f!");
								return true;
							} else {
								ItemStack itemstack1 = new ItemStack(material, quantite);
								target.getInventory().addItem(new ItemStack[] { itemstack1 });
								target.sendMessage(main.getConfig().getString("prefixs.give").replace("&", "§").replace(">", "»") + "Vous avez reçu 1 §b" + itemstack1.getType() + " §f!");
								sender.sendMessage(main.getConfig().getString("prefixs.give").replace("&", "§").replace(">", "»") + "1 §b" + itemstack1.getType() + " §fa été give à §b" + target.getName() + " §f!");
								return true;
							}
						} else {
							Material itemType = Material.matchMaterial(args[1]);
							if(itemType == null) {
								sender.sendMessage(main.getConfig().getString("prefixs.give").replace("&", "§").replace(">", "»") + "Item inconnu §b" + args[1] + " §f!");
								return true;
							} else {
								ItemStack itemStack = new ItemStack(itemType, quantite);
								target.getInventory().addItem(new ItemStack[] { itemStack });
								target.sendMessage(main.getConfig().getString("prefixs.give").replace("&", "§").replace(">", "»") + "Vous avez reçu " + quantite + " §b" + itemStack.getType() + " §f!");
								return true;
							}
						}
					}
				}
			}
		}
		if(args.length == 4) {
			if(args[1].equalsIgnoreCase("player_head")) {
				String playerName = args[0];
				Player target = sender.getServer().getPlayerExact(playerName);
				int quantite = Integer.valueOf(args[3]).intValue();
				if(target != null) {
					if(target.isOnline()) {
						if(target != sender) {
							ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, quantite, (short)SkullType.PLAYER.ordinal());
							SkullMeta skullm = (SkullMeta)skull.getItemMeta();
							skullm.setOwner(args[2]);
							skull.setItemMeta((ItemMeta)skullm);
							target.getInventory().addItem(new ItemStack[] { skull });
							target.updateInventory();
							target.sendMessage(main.getConfig().getString("prefixs.give").replace("&", "§").replace(">", "»") + "Vous avez reçu 1 tête de §b" + args[2] + " §f!");
							sender.sendMessage(main.getConfig().getString("prefixs.give").replace("&", "§").replace(">", "»") + "§b" + target.getName() + " §fa reçu 1 tête de §b" + args[2] + " §f!");
						} else {
							ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, quantite, (short)SkullType.PLAYER.ordinal());
							SkullMeta skullm = (SkullMeta)skull.getItemMeta();
							skullm.setOwner(args[2]);
							skull.setItemMeta((ItemMeta)skullm);
							target.getInventory().addItem(new ItemStack[] { skull });
							target.updateInventory();
							target.sendMessage(main.getConfig().getString("prefixs.give").replace("&", "§").replace(">", "»") + "Vous avez reçu 1 tête de §b" + args[2] + " §f!");
						}
					}
				}
			}
		}
		
		
		
		return false;
	}

}
