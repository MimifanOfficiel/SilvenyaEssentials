package fr.mimifan.silvenya.commands.diverses;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.mimifan.silvenya.Main;

public class CommandFurnace implements CommandExecutor {

	private Main main;
	
	public CommandFurnace(Main main) {
		this.main = main;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		ItemStack item = player.getItemInHand();
		Material mat = item.getType();
		if(item.getType() == Material.AIR) {
			player.sendMessage(main.getConfig().getString("furnace.no_item").replace("&", "§").replace(">", "»"));
			return true;
		} switch (mat) {
			case COBBLESTONE:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.STONE, item.getAmount())});
                break;
			case IRON_ORE:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.IRON_INGOT, item.getAmount())});
                break;
			case GOLD_ORE:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, item.getAmount())});
                break;
			case REDSTONE_ORE:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.REDSTONE, item.getAmount())});
                break;
			case COAL_ORE:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.COAL, item.getAmount())});
                break;
			case DIAMOND_ORE:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.DIAMOND, item.getAmount())});
                break;
			case LAPIS_ORE:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.LAPIS_LAZULI, item.getAmount())});
                break;
			case EMERALD_ORE:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.EMERALD, item.getAmount())});
                break;
			case NETHER_QUARTZ_ORE:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.QUARTZ, item.getAmount())});
                break;
			case ACACIA_LOG:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CHARCOAL, item.getAmount())});
                break;
			case BIRCH_LOG:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CHARCOAL, item.getAmount())});
                break;
			case DARK_OAK_LOG:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CHARCOAL, item.getAmount())});
                break;
			case JUNGLE_LOG:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CHARCOAL, item.getAmount())});
                break;
			case OAK_LOG:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CHARCOAL, item.getAmount())});
                break;
			case SPRUCE_LOG:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CHARCOAL, item.getAmount())});
                break;
			case STRIPPED_ACACIA_LOG:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CHARCOAL, item.getAmount())});
                break;
			case STRIPPED_DARK_OAK_LOG:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CHARCOAL, item.getAmount())});
                break;
			case STRIPPED_BIRCH_LOG:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CHARCOAL, item.getAmount())});
                break;
			case STRIPPED_JUNGLE_LOG:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CHARCOAL, item.getAmount())});
                break;
			case STRIPPED_OAK_LOG:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CHARCOAL, item.getAmount())});
                break;
			case STRIPPED_SPRUCE_LOG:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CHARCOAL, item.getAmount())});
                break;
			case SAND:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.GLASS, item.getAmount())});
                break;
			case NETHER_GOLD_ORE:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.GOLD_INGOT, item.getAmount())});
                break;
			case STRIPPED_ACACIA_WOOD:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CHARCOAL, item.getAmount())});
                break;
			case STRIPPED_BIRCH_WOOD:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CHARCOAL, item.getAmount())});
                break;
			case STRIPPED_DARK_OAK_WOOD:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CHARCOAL, item.getAmount())});
                break;
			case STRIPPED_JUNGLE_WOOD:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CHARCOAL, item.getAmount())});
                break;
			case STRIPPED_OAK_WOOD:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CHARCOAL, item.getAmount())});
                break;
			case STRIPPED_SPRUCE_WOOD:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CHARCOAL, item.getAmount())});
                break;
			case RED_SAND:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.GLASS, item.getAmount())});
                break;
			case WET_SPONGE:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.SPONGE, item.getAmount())});
                break;
			case NETHERRACK:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.NETHER_BRICK, item.getAmount())});
                break;
			case CACTUS:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.GREEN_DYE, item.getAmount())});
                break;
			case ANCIENT_DEBRIS:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.NETHERITE_SCRAP, item.getAmount())});
                break;
			case CLAY_BALL:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.CLAY, item.getAmount())});
                break;
			case PORKCHOP:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.COOKED_PORKCHOP, item.getAmount())});
                break;
			case BEEF:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.COOKED_BEEF, item.getAmount())});
                break;
			case CHICKEN:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.COOKED_CHICKEN, item.getAmount())});
                break;
			case POTATO:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.BAKED_POTATO, item.getAmount())});
                break;
			case COD:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.COOKED_COD, item.getAmount())});
                break;
			case SALMON:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.COOKED_SALMON, item.getAmount())});
                break;
			case MUTTON:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.COOKED_MUTTON, item.getAmount())});
                break;
			case RABBIT:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.COOKED_RABBIT, item.getAmount())});
                break;
			case KELP:
				player.getInventory().remove(new ItemStack(mat, player.getItemInHand().getAmount()));
                player.getInventory().addItem(new ItemStack[]{new ItemStack(Material.DRIED_KELP, item.getAmount())});
                break;
            default:
            	break;
		}
		return false;
	}
}
