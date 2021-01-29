package main.dartanman.truechat.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import main.dartanman.truechat.Main;

public class AntiSwearListener implements Listener{
	
	private Main plugin;
	
	public AntiSwearListener(Main pl) {
		plugin = pl;
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void antiSwear(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String message = event.getMessage();
		message = message.replaceAll("\\s", "");
		if(!plugin.getConfig().getBoolean("AntiSwear.AllowSwearing")) {
			String swearWords = plugin.getConfig().getString("AntiSwear.SwearWords");
			String[] swearWordsArray = swearWords.split("/");
			for(String word : swearWordsArray) {
				if(message.toLowerCase().contains(word.toLowerCase())) {
					if(!player.hasPermission("truechat.antiswear.bypass") && !player.hasPermission("truechat.*")) {
						event.setCancelled(true);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.Swear")));
					}
				}
			}	
		}
	}

}
