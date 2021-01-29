package main.dartanman.truechat.events;

import java.util.regex.Pattern;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import main.dartanman.truechat.Main;

public class AntiAdListener implements Listener{
	
	private Main plugin;
	
	public AntiAdListener(Main pl) {
		plugin = pl;
	}
	  
	private boolean isWebsite(String s) {
		String whitespace = "\\s";
		s = s.replaceAll(whitespace, "");
		s = s.replace("(dot)", ".").toLowerCase();
		String extensions = plugin.getConfig().getString("AntiAdvertisement.WebExtensions").replace("/", "|");
		String pattern = "([a-z-0-9]{1,50})\\.(" + extensions + ")(?![a-z0-9])";
		if(Pattern.compile(pattern).matcher(s).find()) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean isIPAddress(String s) {
		String whitespace = "\\s";
		s = s.replaceAll(whitespace, "");
		s = s.replace("(dot)", ".").toLowerCase();
		String pattern = "([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})";
		if(Pattern.compile(pattern).matcher(s).find()) {
			return true;
		}else {
			return false;
		}
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void antiAd(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String message = event.getMessage();
		if(!plugin.getConfig().getBoolean("AntiAdvertisement.AllowIPAddresses")) {
			if(isIPAddress(message) && !player.hasPermission("truechat.antiadvertisement.bypass") && !player.hasPermission("truechat.*")) {
				event.setCancelled(true);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.Advertisement")));
			}
		}
		
		if(!plugin.getConfig().getBoolean("AntiAdvertisement.AllowWebsites")) {
			if(isWebsite(message) && !player.hasPermission("truechat.antiadvertisement.bypass") && !player.hasPermission("truechat.*")) {
				event.setCancelled(true);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.Advertisement")));
			}
		}
	}

}
