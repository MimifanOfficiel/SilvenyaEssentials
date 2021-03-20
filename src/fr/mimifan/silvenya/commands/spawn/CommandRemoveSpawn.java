package fr.mimifan.silvenya.commands.spawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandRemoveSpawn implements CommandExecutor {

	private Main main;
	
	public CommandRemoveSpawn(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(main.getConfig().getBoolean("spawn.set") == false) {
			player.sendMessage(main.getConfig().getString("spawn.not_def").replace("&", "§").replace(">", "»"));
		}
		if(main.getConfig().getBoolean("spawn.set") == true) {
			main.getConfig().set("spawn.set", Boolean.valueOf(false));
			player.sendMessage(main.getConfig().getString("spawn.removed").replace("&", "§").replace(">", "»"));
		}
		return false;
	}

}
