package fr.mimifan.silvenya.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.mimifan.silvenya.Main;

public class JoinLeave implements Listener {
	
	private Main main;
	public JoinLeave(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if(main.getConfig().getString("maintenance.stat").equalsIgnoreCase("on")) {
			if(player.hasPermission(main.getConfig().getString("maintenance.bypass"))) {
				if(main.getConfig().getBoolean("JoinLeave.join") == true) {
					event.setJoinMessage(main.getConfig().getString("JoinLeave.joinmsg").replace("&", "§").replace(">", "»") + player.getName());
				} else {
					event.setJoinMessage(null);
				}
			} else {
				player.kickPlayer(main.getConfig().getString("maintenance.kickmsg").replace("&", "§").replace(">", "»"));
			}
		}
		if(main.getConfig().getString("maintenance.stat").equalsIgnoreCase("off")) {
			if(main.getConfig().getBoolean("JoinLeave.join") == true) {
				event.setJoinMessage(main.getConfig().getString("JoinLeave.joinmsg").replace("&", "§").replace(">", "»") + player.getName());
			} else {
				event.setJoinMessage(null);
			}
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		if(main.getConfig().getBoolean("JoinLeave.quit") == true) {
			if(main.getConfig().getString("maintenance.stat").equalsIgnoreCase("on")) {
				if(player.hasPermission(main.getConfig().getString("maintenance.bypass"))) {
					event.setQuitMessage(String.valueOf(this.main.getConfig().getString("JoinLeave.quitmsg").replace("&", "§").replace(">", "»")) + player.getName());
				} else {
					event.setQuitMessage("");
				}
			}
			if(main.getConfig().getString("maintenance.stat").equalsIgnoreCase("off")) {
				event.setQuitMessage(String.valueOf(this.main.getConfig().getString("JoinLeave.quitmsg").replace("&", "§").replace(">", "»")) + player.getName());
			}
		}
		
	}
}
