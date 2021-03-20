package fr.mimifan.silvenya.commands.diverses;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.mimifan.silvenya.Main;

public class CommandSpeed implements CommandExecutor {

	private Main main;
	
	public CommandSpeed(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		if(args.length == 0) {
			player.sendMessage(main.getConfig().getString("speed.use").replace("&", "§").replaceFirst(">", "»"));
		}
		if(args.length == 1) {
			player.sendMessage(main.getConfig().getString("speed.use").replace("&", "§").replaceFirst(">", "»"));
		}
		if(args.length == 2) {
			int speed = Integer.valueOf(args[1]);
			if(args[0].equalsIgnoreCase("fly")) {
				if(speed <= 10) {
					if(speed == 1) {
						player.setFlySpeed(0.1F);
						player.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
					}
					if(speed == 2) {
						player.setFlySpeed(0.2F);
						player.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
					}
					if(speed == 3) {
						player.setFlySpeed(0.3F);
						player.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
					}
					if(speed == 4) {
						player.setFlySpeed(0.4F);
						player.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
					}
					if(speed == 5) {
						player.setFlySpeed(0.5F);
						player.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
					}
					if(speed == 6) {
						player.setFlySpeed(0.6F);
						player.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
					}
					if(speed == 7) {
						player.setFlySpeed(0.7F);
						player.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
					}
					if(speed == 8) {
						player.setFlySpeed(0.8F);
						player.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
					}
					if(speed == 9) {
						player.setFlySpeed(0.9F);
						player.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
					}
					if(speed == 10) {
						player.setFlySpeed(1.0F);
						player.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
					}
				} else {
					player.sendMessage(main.getConfig().getString("speed.too_much").replace("&", "§").replace(">", "»"));
				}
			}
			if(args[0].equalsIgnoreCase("walk")) {
				if(speed <= 10) {
					if(speed == 1) {
						player.setWalkSpeed(0.1F);
						player.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
					}
					if(speed == 2) {
						player.setWalkSpeed(0.2F);
						player.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
					}
					if(speed == 3) {
						player.setWalkSpeed(0.3F);
						player.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
					}
					if(speed == 4) {
						player.setWalkSpeed(0.4F);
						player.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
					}
					if(speed == 5) {
						player.setWalkSpeed(0.5F);
						player.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
					}
					if(speed == 6) {
						player.setWalkSpeed(0.6F);
						player.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
					}
					if(speed == 7) {
						player.setWalkSpeed(0.7F);
						player.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
					}
					if(speed == 8) {
						player.setWalkSpeed(0.8F);
						player.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
					}
					if(speed == 9) {
						player.setWalkSpeed(0.9F);
						player.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
					}
					if(speed == 10) {
						player.setWalkSpeed(1.0F);
						player.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
					}
				} else {
					player.sendMessage(main.getConfig().getString("speed.too_much").replace("&", "§").replace(">", "»"));
				}
			}
		}
		if(args.length == 3) {
			Player target = Bukkit.getPlayer(args[2]);
			int speed = Integer.valueOf(args[1]).intValue();
			if(target != null) {
				if(target.isOnline()) {
					if(args[0].equalsIgnoreCase("fly")) {
						if(speed <= 10) {
							if(speed == 1) {
								target.setFlySpeed(0.1F);
								target.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
							}
							if(speed == 2) {
								target.setFlySpeed(0.2F);
								target.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
							}
							if(speed == 3) {
								target.setFlySpeed(0.3F);
								target.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
							}
							if(speed == 4) {
								target.setFlySpeed(0.4F);
								target.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
							}
							if(speed == 5) {
								target.setFlySpeed(0.5F);
								target.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
							}
							if(speed == 6) {
								target.setFlySpeed(0.6F);
								target.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
							}
							if(speed == 7) {
								target.setFlySpeed(0.7F);
								target.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
							}
							if(speed == 8) {
								target.setFlySpeed(0.8F);
								target.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
							}
							if(speed == 9) {
								target.setFlySpeed(0.9F);
								target.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
							}
							if(speed == 10) {
								target.setFlySpeed(1.0F);
								target.sendMessage(main.getConfig().getString("speed.fly.def").replace("&", "§").replace(">", "»") + speed);
							}
						} else {
							player.sendMessage(main.getConfig().getString("speed.too_much").replace("&", "§").replace(">", "»"));
						}
					}
					if(args[0].equalsIgnoreCase("walk")) {
						if(speed <= 10) {
							if(speed == 1) {
								target.setWalkSpeed(0.1F);
								target.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
							}
							if(speed == 2) {
								target.setWalkSpeed(0.2F);
								target.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
							}
							if(speed == 3) {
								target.setWalkSpeed(0.3F);
								target.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
							}
							if(speed == 4) {
								target.setWalkSpeed(0.4F);
								target.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
							}
							if(speed == 5) {
								target.setWalkSpeed(0.5F);
								target.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
							}
							if(speed == 6) {
								target.setWalkSpeed(0.6F);
								target.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
							}
							if(speed == 7) {
								target.setWalkSpeed(0.7F);
								target.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
							}
							if(speed == 8) {
								target.setWalkSpeed(0.8F);
								target.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
							}
							if(speed == 9) {
								target.setWalkSpeed(0.9F);
								target.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
							}
							if(speed == 10) {
								target.setWalkSpeed(1.0F);
								target.sendMessage(main.getConfig().getString("speed.walk.def").replace("&", "§").replace(">", "»") + speed);
							}
						} else {
							player.sendMessage(main.getConfig().getString("speed.too_much").replace("&", "§").replace(">", "»"));
						}
					}
				}
			}
		}
		return false;
	}
}
