package fr.mimifan.silvenya.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import fr.mimifan.silvenya.Main;

public class SpawnerMiner implements Listener {
	
	@SuppressWarnings("unused")
	private Main main;
	
	public SpawnerMiner(Main main) {
		this.main = main;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlock();
		ItemStack tool = player.getItemInHand();
		if(block.getType() == Material.SPAWNER) {
			if(tool.getType() == Material.DIAMOND_PICKAXE) {
				if(tool.hasItemMeta() && tool.getItemMeta().hasEnchant(Enchantment.SILK_TOUCH)) {
					double randDouble = Math.random();
					if(randDouble <= 0.30D) {
						Material material = Material.SPAWNER;
						ItemStack itemstack1 = new ItemStack(material, 1);
						player.getInventory().addItem(new ItemStack[] { itemstack1 } );
						player.sendMessage("§9§lMinage §8» §fLa chance ! Vous avez obtenu un spawner !");
					}
				}
			}
		}
	}
	
}
