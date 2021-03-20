package fr.mimifan.silvenya.commands.spawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandSetSpawn implements CommandExecutor {

	private Main main;
	
	public CommandSetSpawn(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		String world = player.getWorld().getName();
		double x = player.getLocation().getX();
		double y = player.getLocation().getY();
		double z = player.getLocation().getZ();
		double yaw = player.getLocation().getYaw();
		double pitch = player.getLocation().getPitch();
		
		main.getConfig().set("spawn.set", Boolean.valueOf(true));
		main.getConfig().set("spawn.world", world);
		main.getConfig().set("spawn.x", Double.valueOf(x));
		main.getConfig().set("spawn.y", Double.valueOf(y));
		main.getConfig().set("spawn.z", Double.valueOf(z));
		main.getConfig().set("spawn.yaw", Double.valueOf(yaw));
		main.getConfig().set("spawn.pitch", Double.valueOf(pitch));
		
		player.sendMessage(main.getConfig().getString("spawn.def").replace("&", "§").replace(">", "»"));
		
		return false;
	}

}
