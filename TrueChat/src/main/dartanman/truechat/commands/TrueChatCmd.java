package main.dartanman.truechat.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import main.dartanman.truechat.Main;

public class TrueChatCmd implements CommandExecutor {
	
	private Main plugin;

	public TrueChatCmd(Main pl) {
		plugin = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			sender.sendMessage(
					ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.NoArgs")));
			return true;
		} else if (args.length == 1) {
			if (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")) {
				if (!sender.hasPermission("truechat.help") && !sender.hasPermission("truechat.*")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							plugin.getConfig().getString("Messages.NoPermission")));
					return true;
				}
				sender.sendMessage(ChatColor.ITALIC + "[] = optional args. <> = required args. / = args choice.");
				sender.sendMessage(ChatColor.YELLOW + "/truechat clear [player/self]" + ChatColor.WHITE + ": "
						+ ChatColor.GOLD + "Clears the chat globally, or just for [player]");
				sender.sendMessage(ChatColor.YELLOW + "/truechat freeze " + ChatColor.WHITE + ": " + ChatColor.GOLD +
						"Freezes the chat");
				sender.sendMessage(ChatColor.YELLOW + "/truechat help " + ChatColor.WHITE + ": " + ChatColor.GOLD
						+ "Displays this help menu");
				return true;
			} else if (args[0].equalsIgnoreCase("clear") || args[0].equalsIgnoreCase("clearchat")) {
				if (!sender.hasPermission("truechat.clear.global") && !sender.hasPermission("truechat.*")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							plugin.getConfig().getString("Messages.NoPermission")));
					return true;
				}
				for (int i = 0; i < 101; i++) {
					Bukkit.broadcastMessage(" ");
				}
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
						plugin.getConfig().getString("Messages.GlobalChatClear").replace("<player>", sender.getName())));
				return true;
			}else if(args[0].equalsIgnoreCase("freeze")) {
				if(!sender.hasPermission("truechat.freeze") && !sender.hasPermission("truechat.*")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							plugin.getConfig().getString("Messages.NoPermission")));
					return true;
				}
				if(plugin.isChatFrozen()) {
					plugin.setChatFrozen(false);
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.UnfrozeChat").replace("<player>", sender.getName())));
					return true;
				}else {
					plugin.setChatFrozen(true);
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.FrozeChat").replace("<player>", sender.getName())));
					return true;
				}
			}else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						plugin.getConfig().getString("Messages.IncorrectArgs")));
				return true;
			}
		} else if (args.length == 2) {
			if (args[0].equalsIgnoreCase("clear") || args[0].equalsIgnoreCase("clearchat")) {
				if (args[1].equalsIgnoreCase("self") || args[1].equalsIgnoreCase(sender.getName())) {
					if (!sender.hasPermission("truechat.clear.self") && !sender.hasPermission("truechat.*")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								plugin.getConfig().getString("Messages.NoPermission")));
						return true;
					}
					for(int i = 0; i < 101; i++) {
						sender.sendMessage(" ");
					}
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							plugin.getConfig().getString("Messages.SelfChatClear")));
					return true;
				} else {
					if (!sender.hasPermission("truechat.clear.player") && !sender.hasPermission("truechat.*")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								plugin.getConfig().getString("Messages.NoPermission")));
						return true;
					}
					Player target = Bukkit.getPlayer(args[1]);
					if (target == null) {
						sender.sendMessage(ChatColor.RED + args[1] + " is not online!");
						return true;
					}else {
						for(int i = 0; i < 101; i++) {
							target.sendMessage(" ");
						}
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.PlayerChatClearSent").replace("<player>", target.getName())));
						target.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.PlayerChatClearReceived").replace("<player>", sender.getName())));
						return true;
					}
				}
			} else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						plugin.getConfig().getString("Messages.IncorrectArgs")));
				return true;
			}
		}else {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
					plugin.getConfig().getString("Messages.IncorrectArgs")));
			return true;
		}
	}

}
