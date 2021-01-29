package main.dartanman.truechat.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import main.dartanman.truechat.Main;

public class ClearChat implements CommandExecutor{
	
	private Main plugin;
	
	public ClearChat(Main pl) {
		plugin = pl;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			Bukkit.dispatchCommand(sender, "tc clear");	
			return true;
		}else if(args.length == 1){
			Bukkit.dispatchCommand(sender, "tc clear " + args[0]);
			return true;
		}else {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
					plugin.getConfig().getString("Messages.IncorrectArgs")));
			return true;
		}
	}

}
