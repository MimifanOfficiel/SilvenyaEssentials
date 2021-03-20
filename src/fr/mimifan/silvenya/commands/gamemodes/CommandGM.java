package fr.mimifan.silvenya.commands.gamemodes;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandGM implements CommandExecutor {

	private Main main;
	public CommandGM(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("gamemode") && sender instanceof Player) {
			if(args.length == 0) {
				player.sendMessage(main.getConfig().getString("gamemode.nogm").replace("&", "§").replace(">", "»"));
			}
			if(args.length == 1) {
				if (args[0].equalsIgnoreCase("1")) {
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(main.getConfig().getString("gamemode.self1").replace("&", "§").replace(">", "»"));
				}
				if (args[0].equalsIgnoreCase("2")) {
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(main.getConfig().getString("gamemode.self2").replace("&", "§").replace(">", "»"));
				}
				if (args[0].equalsIgnoreCase("3")) {
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(main.getConfig().getString("gamemode.self3").replace("&", "§").replace(">", "»"));
				}
				if (args[0].equalsIgnoreCase("0")) {
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(main.getConfig().getString("gamemode.self0").replace("&", "§").replace(">", "»"));
				}
				if (args[0].equalsIgnoreCase("creative")) {
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(main.getConfig().getString("gamemode.self1").replace("&", "§").replace(">", "»"));
				}
				if (args[0].equalsIgnoreCase("adventure")) {
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(main.getConfig().getString("gamemode.self2").replace("&", "§").replace(">", "»"));
				}
				if (args[0].equalsIgnoreCase("spectator")) {
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(main.getConfig().getString("gamemode.self3").replace("&", "§").replace(">", "»"));
				}
				if (args[0].equalsIgnoreCase("survival")) {
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(main.getConfig().getString("gamemode.self0").replace("&", "§").replace(">", "»"));
				}
				if (!args[0].equalsIgnoreCase("0") && !args[0].equalsIgnoreCase("1") && !args[0].equalsIgnoreCase("2") && !args[0].equalsIgnoreCase("3") && !args[0].equalsIgnoreCase("creative") && !args[0].equalsIgnoreCase("survival") && !args[0].equalsIgnoreCase("adventure") && !args[0].equalsIgnoreCase("spectator")) {
					player.sendMessage(main.getConfig().getString("gamemode.nogm").replace("&", "§").replace(">", "»"));
				}
			}
			if(args.length == 2) {
				if(player.hasPermission(main.getConfig().getString("gamemode.othergmperm"))) {
					Player target = Bukkit.getPlayer(args[1]);
					if(target != null) {
						if(target.isOnline()) {
							if(args[0].equalsIgnoreCase("1")) {
								target.setGameMode(GameMode.CREATIVE);
								target.sendMessage(main.getConfig().getString("gamemode.self1").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + target.getName() + " §fest maintenant en Créatif !");
							}
							if(args[0].equalsIgnoreCase("2")) {
								target.setGameMode(GameMode.ADVENTURE);
								target.sendMessage(main.getConfig().getString("gamemode.self2").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + target.getName() + " §fest maintenant en Aventure !");
							}
							if(args[0].equalsIgnoreCase("3")) {
								target.setGameMode(GameMode.SPECTATOR);
								target.sendMessage(main.getConfig().getString("gamemode.self3").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + target.getName() + " §fest maintenant en Spectateur !");
							}
							if(args[0].equalsIgnoreCase("0")) {
								target.setGameMode(GameMode.SURVIVAL);
								target.sendMessage(main.getConfig().getString("gamemode.self0").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + target.getName() + " §fest maintenant en Survie !");
							}
							if(args[0].equalsIgnoreCase("creative")) {
								target.setGameMode(GameMode.CREATIVE);
								target.sendMessage(main.getConfig().getString("gamemode.self1").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + target.getName() + " §fest maintenant en Créatif !");
							}
							if(args[0].equalsIgnoreCase("adventure")) {
								target.setGameMode(GameMode.ADVENTURE);
								target.sendMessage(main.getConfig().getString("gamemode.self2").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + target.getName() + " §fest maintenant en Aventure !");
							}
							if(args[0].equalsIgnoreCase("spectator")) {
								target.setGameMode(GameMode.SPECTATOR);
								target.sendMessage(main.getConfig().getString("gamemode.self3").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + target.getName() + " §fest maintenant en Spectateur !");
							}
							if(args[0].equalsIgnoreCase("survival")) {
								target.setGameMode(GameMode.SURVIVAL);
								target.sendMessage(main.getConfig().getString("gamemode.self0").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + target.getName() + " §fest maintenant en Survie !");
							}
						}
					} else {
						player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[1] + " §fn'est pas connecté !");
					}
				} else {
					player.sendMessage(main.getConfig().getString("messages.noperm").replace("&", "§").replace(">", "»"));
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("gm") && sender instanceof Player) {
			if(args.length == 0) {
				player.sendMessage(main.getConfig().getString("gamemode.nogm").replace("&", "§").replace(">", "»"));
			}
			if(args.length == 1) {
				if (args[0].equalsIgnoreCase("1")) {
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(main.getConfig().getString("gamemode.self1").replace("&", "§").replace(">", "»"));
				}
				if (args[0].equalsIgnoreCase("2")) {
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(main.getConfig().getString("gamemode.self2").replace("&", "§").replace(">", "»"));
				}
				if (args[0].equalsIgnoreCase("3")) {
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(main.getConfig().getString("gamemode.self3").replace("&", "§").replace(">", "»"));
				}
				if (args[0].equalsIgnoreCase("0")) {
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(main.getConfig().getString("gamemode.self0").replace("&", "§").replace(">", "»"));
				}
				if (args[0].equalsIgnoreCase("creative")) {
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(main.getConfig().getString("gamemode.self1").replace("&", "§").replace(">", "»"));
				}
				if (args[0].equalsIgnoreCase("adventure")) {
					player.setGameMode(GameMode.ADVENTURE);
					player.sendMessage(main.getConfig().getString("gamemode.self2").replace("&", "§").replace(">", "»"));
				}
				if (args[0].equalsIgnoreCase("spectator")) {
					player.setGameMode(GameMode.SPECTATOR);
					player.sendMessage(main.getConfig().getString("gamemode.self3").replace("&", "§").replace(">", "»"));
				}
				if (args[0].equalsIgnoreCase("survival")) {
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(main.getConfig().getString("gamemode.self0").replace("&", "§").replace(">", "»"));
				}
				if (!args[0].equalsIgnoreCase("0") && !args[0].equalsIgnoreCase("1") && !args[0].equalsIgnoreCase("2") && !args[0].equalsIgnoreCase("3") && !args[0].equalsIgnoreCase("creative") && !args[0].equalsIgnoreCase("survival") && !args[0].equalsIgnoreCase("adventure") && !args[0].equalsIgnoreCase("spectator")) {
					player.sendMessage(main.getConfig().getString("gamemode.nogm").replace("&", "§").replace(">", "»"));
				}
			}
			if(args.length == 2) {
				if(player.hasPermission(main.getConfig().getString("gamemode.othergmperm"))) {
					Player target = Bukkit.getPlayer(args[1]);
					if(target != null) {
						if(target.isOnline()) {
							if(args[0].equalsIgnoreCase("1")) {
								target.setGameMode(GameMode.CREATIVE);
								target.sendMessage(main.getConfig().getString("gamemode.self1").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + target.getName() + " §fest maintenant en Créatif !");
							}
							if(args[0].equalsIgnoreCase("2")) {
								target.setGameMode(GameMode.ADVENTURE);
								target.sendMessage(main.getConfig().getString("gamemode.self2").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + target.getName() + " §fest maintenant en Aventure !");
							}
							if(args[0].equalsIgnoreCase("3")) {
								target.setGameMode(GameMode.SPECTATOR);
								target.sendMessage(main.getConfig().getString("gamemode.self3").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + target.getName() + " §fest maintenant en Spectateur !");
							}
							if(args[0].equalsIgnoreCase("0")) {
								target.setGameMode(GameMode.SURVIVAL);
								target.sendMessage(main.getConfig().getString("gamemode.self0").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + target.getName() + " §fest maintenant en Survie !");
							}
							if(args[0].equalsIgnoreCase("creative")) {
								target.setGameMode(GameMode.CREATIVE);
								target.sendMessage(main.getConfig().getString("gamemode.self1").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + target.getName() + " §fest maintenant en Créatif !");
							}
							if(args[0].equalsIgnoreCase("adventure")) {
								target.setGameMode(GameMode.ADVENTURE);
								target.sendMessage(main.getConfig().getString("gamemode.self2").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + target.getName() + " §fest maintenant en Aventure !");
							}
							if(args[0].equalsIgnoreCase("spectator")) {
								target.setGameMode(GameMode.SPECTATOR);
								target.sendMessage(main.getConfig().getString("gamemode.self3").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + target.getName() + " §fest maintenant en Spectateur !");
							}
							if(args[0].equalsIgnoreCase("survival")) {
								target.setGameMode(GameMode.SURVIVAL);
								target.sendMessage(main.getConfig().getString("gamemode.self0").replace("&", "§").replace(">", "»"));
								player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + target.getName() + " §fest maintenant en Survie !");
							}
						}
					} else {
						player.sendMessage(main.getConfig().getString("prefixs.gamemode").replace("&", "§").replace(">", "»") + "Le joueur §b" + args[1] + " §fn'est pas connecté !");
					}
				} else {
					player.sendMessage(main.getConfig().getString("messages.noperm").replace("&", "§").replace(">", "»"));
				}
			}
		}
		
		return false;
	}

}
