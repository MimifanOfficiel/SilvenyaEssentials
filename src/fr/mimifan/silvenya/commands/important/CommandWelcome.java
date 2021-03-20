package fr.mimifan.silvenya.commands.important;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.mimifan.silvenya.Main;

public class CommandWelcome implements CommandExecutor, Listener {

	private Main main;
	File datafolder;
	long time;
	
	public CommandWelcome(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		String playername = player.getName();
		try { 
			datafolder = new File(main.getDataFolder() + "/Playerdatas/" + File.separator + player.getName());
			if (!datafolder.exists()) {
				Bukkit.broadcastMessage("§9§lBienvenue §8» §fBienvenue à §b" + player.getName() + " §fqui vient de rejoindre le serveur pour la première fois !");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spawn " + player.getName());
				time = System.currentTimeMillis();
				main.getNewPlayer().put(playername, (short) 0);
			}
		} catch (SecurityException e) {
			datafolder = null;
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			player.sendMessage(main.getConfig().getString("bvn.no_player").replace("&", "§").replace(">", "»"));
		}
		if(args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			String targetname = target.getName();
			if(main.getNewPlayer().containsKey(targetname)) {
			
			}
		}
		return false;
	}

}
