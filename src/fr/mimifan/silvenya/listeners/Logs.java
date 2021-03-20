package fr.mimifan.silvenya.listeners;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.mimifan.silvenya.Main;

public class Logs implements Listener {
	
	File folderfordatas;
	File datafolder;
	File playerdata;
	File blocks;
	File chat;
	
	
	
	private Main main;
	
	public Logs(Main main) {
		this.main = main;
		try {
			folderfordatas = new File(main.getDataFolder() + File.separator + "Playerdatas");
			if(!folderfordatas.exists()) {
				folderfordatas.mkdirs();
			}
		} catch(SecurityException e) {
			folderfordatas = null;
		}
		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		try { 
			datafolder = new File(main.getDataFolder() + "/Playerdatas/" + File.separator + player.getName());
			if (!datafolder.exists()) {
				datafolder.mkdirs();
				Bukkit.broadcastMessage("§9§lBienvenue §8» §fBienvenue à §b" + player.getName() + " §fqui vient de rejoindre le serveur pour la première fois !");
			}
		} catch (SecurityException e) {
			datafolder = null;
		}
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		logtofileUDT(player.getName(), "[" + format.format(now) + "] " + player.getName() + " s'est connecté avec l'ip: " + player.getAddress() + " .");
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		logtofileUDT(player.getName(), "[" + format.format(now) + "] " + player.getName() + " s'est déconnecté.");
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlock();
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		int x = (int) player.getLocation().getX();
		int y = (int) player.getLocation().getY();
		int z = (int) player.getLocation().getZ();
		logtofileBlock(player.getName(), "[" + format.format(now) + "] -> " + x + " " + y + " " + z + " " + player.getName() + " a cassé : " + block.getType());
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		Block block = event.getBlock();
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		int x = (int) player.getLocation().getX();
		int y = (int) player.getLocation().getY();
		int z = (int) player.getLocation().getZ();
		logtofileBlock(player.getName(), "[" + format.format(now) + "] -> " + x + " " + y + " " + z + " " + player.getName() + " a posé : " + block.getType());
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String message = event.getMessage();
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		int x = (int) player.getLocation().getX();
		int y = (int) player.getLocation().getY();
		int z = (int) player.getLocation().getZ();
		logtofileCHAT(player.getName(), "[" + format.format(now) + "] -> " + x + " " + y + " " + z + " " + player.getName() + " a envoyé le message suivant : " + message);
	}
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		Player player = event.getPlayer();
		String message = event.getMessage();
		if(message.startsWith("/")) {
			Date now = new Date();
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			int x = (int) player.getLocation().getX();
			int y = (int) player.getLocation().getY();
			int z = (int) player.getLocation().getZ();
			logtofileCHAT(player.getName(), "[" + format.format(now) + "] -> " + x + " " + y + " " + z + " " + player.getName() + " a exécuté la commande suivante : " + message);
		}
	}
	
	
	public void logtofileCHAT(String playername, String message) {
		try {
			chat = new File(main.getDataFolder() + "/Playerdatas/" + File.separator + playername + "/msg_cmd.txt");
			if (!chat.exists()) {
				chat.createNewFile();
			}
			FileWriter fw = new FileWriter(chat, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(message);
			 
            pw.flush();
 
            pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void logtofileUDT(String playername, String message) {
		try {
			playerdata = new File(main.getDataFolder() + "/Playerdatas/" + File.separator + playername + "/userdata.txt");
			if (!playerdata.exists()) {
				playerdata.createNewFile();
			}
			FileWriter fw = new FileWriter(playerdata, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(message);
			 
            pw.flush();
 
            pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void logtofileBlock(String playername, String message) {
		try {
			blocks = new File(main.getDataFolder() + "/Playerdatas/" + File.separator + playername + "/break_place.txt");
			if (!blocks.exists()) {
				blocks.createNewFile();
			}
			FileWriter fw = new FileWriter(blocks, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(message);
			 
	        pw.flush();

        	pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
