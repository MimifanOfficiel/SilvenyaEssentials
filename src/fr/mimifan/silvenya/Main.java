package fr.mimifan.silvenya;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import fr.mimifan.silvenya.commands.CommandClear;
import fr.mimifan.silvenya.commands.CommandMaintenance;
import fr.mimifan.silvenya.commands.diverses.CommandCraft;
import fr.mimifan.silvenya.commands.diverses.CommandEnderChest;
import fr.mimifan.silvenya.commands.diverses.CommandFurnace;
import fr.mimifan.silvenya.commands.diverses.CommandHat;
import fr.mimifan.silvenya.commands.diverses.CommandHeal;
import fr.mimifan.silvenya.commands.diverses.CommandList;
import fr.mimifan.silvenya.commands.diverses.CommandNear;
import fr.mimifan.silvenya.commands.diverses.CommandNightVision;
import fr.mimifan.silvenya.commands.diverses.CommandPtime;
import fr.mimifan.silvenya.commands.diverses.CommandRepair;
import fr.mimifan.silvenya.commands.diverses.CommandReseaux;
import fr.mimifan.silvenya.commands.diverses.CommandSkull;
import fr.mimifan.silvenya.commands.diverses.CommandSpeed;
import fr.mimifan.silvenya.commands.diverses.CommandSuicide;
import fr.mimifan.silvenya.commands.diverses.CommandTrash;
import fr.mimifan.silvenya.commands.gamemodes.CommandGM;
import fr.mimifan.silvenya.commands.gamemodes.CommandGMA;
import fr.mimifan.silvenya.commands.gamemodes.CommandGMC;
import fr.mimifan.silvenya.commands.gamemodes.CommandGMS;
import fr.mimifan.silvenya.commands.gamemodes.CommandGMSP;
import fr.mimifan.silvenya.commands.important.CommandAnnonce;
import fr.mimifan.silvenya.commands.important.CommandBought;
import fr.mimifan.silvenya.commands.important.CommandClearLag;
import fr.mimifan.silvenya.commands.important.CommandGive;
import fr.mimifan.silvenya.commands.important.CommandHelp;
import fr.mimifan.silvenya.commands.important.CommandMessages;
import fr.mimifan.silvenya.commands.important.CommandWelcome;
import fr.mimifan.silvenya.commands.modération.CommandEndSee;
import fr.mimifan.silvenya.commands.modération.CommandFly;
import fr.mimifan.silvenya.commands.modération.CommandGod;
import fr.mimifan.silvenya.commands.modération.CommandIP;
import fr.mimifan.silvenya.commands.modération.CommandInvSee;
import fr.mimifan.silvenya.commands.modération.CommandKill;
import fr.mimifan.silvenya.commands.modération.CommandStaffChat;
import fr.mimifan.silvenya.commands.modération.CommandUUID;
import fr.mimifan.silvenya.commands.modération.CommandWhoIS;
import fr.mimifan.silvenya.commands.météo.CommandTimes;
import fr.mimifan.silvenya.commands.météo.CommandWeather;
import fr.mimifan.silvenya.commands.spawn.CommandForceSpawn;
import fr.mimifan.silvenya.commands.spawn.CommandRemoveSpawn;
import fr.mimifan.silvenya.commands.spawn.CommandSetSpawn;
import fr.mimifan.silvenya.commands.spawn.CommandSpawn;
import fr.mimifan.silvenya.commands.téléportation.CommandTP;
import fr.mimifan.silvenya.commands.téléportation.CommandTPA;
import fr.mimifan.silvenya.commands.téléportation.CommandTpAll;
import fr.mimifan.silvenya.commands.téléportation.CommandTpHere;
import fr.mimifan.silvenya.commands.téléportation.CommandTppos;
import fr.mimifan.silvenya.listeners.ChatListener;
import fr.mimifan.silvenya.listeners.JoinLeave;
import fr.mimifan.silvenya.listeners.Logs;
import fr.mimifan.silvenya.listeners.SpawnerMiner;

public class Main extends JavaPlugin {
	
	private HashMap<Player, Player> tpa = new HashMap<>();
	private HashMap<Player, Player> tpahere = new HashMap<>();
	private HashMap<String, Boolean> rtped = new HashMap<>();
	private HashMap<String, Boolean> god = new HashMap<>();
	private HashMap<String, Short> bvn = new HashMap<>();
	private HashMap<String, Boolean> sc = new HashMap<>();
	public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
	private HashMap<Player, Player> msgs = new HashMap<>();
	
	
	@Override
	public void onEnable() {
		System.out.println("Silvenya Survival ON");
		saveDefaultConfig();
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new JoinLeave(this), this);
		pm.registerEvents(new CommandGod(this), this);
		pm.registerEvents(new ChatListener(this), this);
		pm.registerEvents(new CommandHelp(this), this);
		pm.registerEvents(new SpawnerMiner(this), this);
		pm.registerEvents(new Logs(this), this);
		pm.registerEvents(new CommandWelcome(this), this);
		pm.registerEvents(new CommandStaffChat(this), this);
		pm.registerEvents(new CommandInvSee(this), this);
		pm.registerEvents(new CommandEndSee(this), this);
		
	//Divers
		getCommand("heal").setExecutor(new CommandHeal(this));
		getCommand("feed").setExecutor(new CommandHeal(this));
		getCommand("hat").setExecutor(new CommandHat(this));
		getCommand("skull").setExecutor(new CommandSkull(this));
		getCommand("craft").setExecutor(new CommandCraft());
		getCommand("suicide").setExecutor(new CommandSuicide(this));
		getCommand("near").setExecutor(new CommandNear());
		getCommand("repair").setExecutor(new CommandRepair(this));
		getCommand("ptime").setExecutor(new CommandPtime(this));
		getCommand("enderchest").setExecutor(new CommandEnderChest());
		getCommand("speed").setExecutor(new CommandSpeed(this));
		getCommand("list").setExecutor(new CommandList(this));
		getCommand("chat").setExecutor(new ChatListener(this));
		getCommand("trash").setExecutor(new CommandTrash());
		getCommand("furnace").setExecutor(new CommandFurnace(this));
		getCommand("nv").setExecutor(new CommandNightVision(this));
		getCommand("discord").setExecutor(new CommandReseaux(this));
		getCommand("vote").setExecutor(new CommandReseaux(this));
		getCommand("site").setExecutor(new CommandReseaux(this));
		getCommand("boutique").setExecutor(new CommandReseaux(this));
		
	//Important
		getCommand("annonce").setExecutor(new CommandAnnonce(this));
		getCommand("bought").setExecutor(new CommandBought(this));
		getCommand("help").setExecutor(new CommandHelp(this));
		getCommand("clearlag").setExecutor(new CommandClearLag(this));
		getCommand("bvn").setExecutor(new CommandWelcome(this));
		getCommand("msg").setExecutor(new CommandMessages(this));
		getCommand("answer").setExecutor(new CommandMessages(this));
		
		
	//Spawn
		getCommand("setspawn").setExecutor(new CommandSetSpawn(this));
		getCommand("spawn").setExecutor(new CommandSpawn(this));
		getCommand("forcespawn").setExecutor(new CommandForceSpawn(this));
		getCommand("removespawn").setExecutor(new CommandRemoveSpawn(this));
		
		
	//Météo
		getCommand("time").setExecutor(new CommandTimes(this));
		getCommand("day").setExecutor(new CommandTimes(this));
		getCommand("night").setExecutor(new CommandTimes(this));
		getCommand("sun").setExecutor(new CommandTimes(this));
		getCommand("rain").setExecutor(new CommandTimes(this));
		getCommand("thunder").setExecutor(new CommandTimes(this));
		getCommand("weather").setExecutor(new CommandWeather(this));
		
	//Modération	
		getCommand("clear").setExecutor(new CommandClear(this));
		getCommand("invsee").setExecutor(new CommandInvSee(this));
		getCommand("endsee").setExecutor(new CommandEndSee(this));
		getCommand("maintenance").setExecutor(new CommandMaintenance(this));
		getCommand("give").setExecutor(new CommandGive(this));
		getCommand("ip").setExecutor(new CommandIP(this));
		getCommand("whois").setExecutor(new CommandWhoIS(this));
		getCommand("uuid").setExecutor(new CommandUUID(this));
		getCommand("kill").setExecutor(new CommandKill(this));
		getCommand("god").setExecutor(new CommandGod(this));
		getCommand("fly").setExecutor(new CommandFly(this));
		getCommand("staffchat").setExecutor(new CommandStaffChat(this));
		
	//Téléportation
		getCommand("tppos").setExecutor(new CommandTppos(this));
		getCommand("tp").setExecutor(new CommandTP(this));
		getCommand("tpa").setExecutor(new CommandTPA(this));
		getCommand("tpahere").setExecutor(new CommandTPA(this));
		getCommand("tpaall").setExecutor(new CommandTPA(this));
		getCommand("tpno").setExecutor(new CommandTPA(this));
		getCommand("tpyes").setExecutor(new CommandTPA(this));
		getCommand("tpall").setExecutor(new CommandTpAll(this));
		getCommand("tphere").setExecutor(new CommandTpHere(this));
		getCommand("randomtp").setExecutor(this);
		
		
	//GameModes	
		getCommand("gma").setExecutor(new CommandGMA(this));
		getCommand("gmc").setExecutor(new CommandGMC(this));
		getCommand("gmsp").setExecutor(new CommandGMSP(this));
		getCommand("gms").setExecutor(new CommandGMS(this));
		getCommand("gm").setExecutor(new CommandGM(this));
		getCommand("gamemode").setExecutor(new CommandGM(this));
		
	}
	
	public HashMap<Player, Player> getTpa() {
		return this.tpa;
	}
	public HashMap<Player, Player> getTpaHere() {
		return this.tpahere;
	}
	public HashMap<String, Boolean> getRtped(){
		return this.rtped;
	}
	public HashMap<String, Boolean> getGod(){
		return this.god;
	}
	public HashMap<String, Long> getCooldown(){
		return this.cooldowns;
	}
	public HashMap<String, Short> getNewPlayer(){
		return this.bvn;
	}
	public HashMap<String, Boolean> getStaffChat(){
		return this.sc;
	}
	public HashMap<Player, Player> getMessages() {
		return this.msgs;
	}
	
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("randomtp")) {
			Player player = (Player)sender;
			int cooldownTime = 30;
			if(cooldowns.containsKey(player.getName())) {
				long secondsLeft = ((this.getCooldown().get(player.getName())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
				if(secondsLeft>0) {
					player.sendMessage(this.getConfig().getString("rtp.cooldowning").replace("&", "§").replace(">", "»") + secondsLeft + " secondes");
					return true;
				}
				if(secondsLeft==0) {
					cooldowns.remove(player.getName());
					int x = (int)(Math.random() * 3000 + 1);
					int z = (int)(Math.random() * 3000 + 1);
					int y = 200;
					World world = player.getWorld();
					Location loc = new Location(world, x, y, z);
					player.teleport(loc);
					cooldowns.put(player.getName(), System.currentTimeMillis());
					player.sendMessage(this.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez été téléporté en §b" + x + " " + y + " " + z + " §f!");
					player.setInvulnerable(true);
				
					BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
					scheduler.scheduleSyncDelayedTask( this, new Runnable() {
						@Override
						public void run() {
							player.setInvulnerable(false);
						}
					}, 300);
					return true;
				}
			} else {
				int x = (int)(Math.random() * 3000 + 1);
				int z = (int)(Math.random() * 3000 + 1);
				int y = 200;
				World world = player.getWorld();
				Location loc = new Location(world, x, y, z);
				player.teleport(loc);
				cooldowns.put(player.getName(), System.currentTimeMillis());
				player.sendMessage(this.getConfig().getString("prefixs.téléportation").replace("&", "§").replace(">", "»") + "Vous avez été téléporté en §b" + x + " " + y + " " + z + " §f!");
				player.setInvulnerable(true);
			
				BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
				scheduler.scheduleSyncDelayedTask( this, new Runnable() {
					@Override
					public void run() {
						player.setInvulnerable(false);
					}
				}, 300);
				return true;
			}
		}
		return false;
	}
	
	
	
	@Override
	public void onDisable() {
		System.out.println("Silvenya Survival OFF");
		
		
	}
}
