package main.dartanman.truechat.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import main.dartanman.truechat.Main;

public class AntiSpamListener implements Listener{
	
	private Main plugin;
	private List<UUID> antispam = new ArrayList();
	private HashMap<UUID, String> antirepeat = new HashMap();
	
	public AntiSpamListener(Main pl) {
		plugin = pl;
	}
	
	private boolean repetitiveChars(String s) {
		char last = '¬';
		int count = 0;
		for(char c : s.toCharArray()) {
			count++;
			if(c != last) {
				count = 0;
			}
			last = c;
			if(count >= plugin.getConfig().getInt("AntiSpam.MaxConsecutiveSameCharacter")) {
				return true;
			}
		}
		return false;
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void antiSpam(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		UUID uuid = player.getUniqueId();
		if(antispam.contains(uuid) && !player.hasPermission("truechat.antispam.bypass") && !player.hasPermission("truechat.*")) {
			event.setCancelled(true);
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.TooFast")));
		}else {
			if(!player.hasPermission("truechat.antispam.bypass") && !player.hasPermission("truechat.*")) {
				antispam.add(uuid);
		        Bukkit.getScheduler().runTaskLater(plugin, new Runnable()
		        {
		          public void run()
		          {
		        	  antispam.remove(uuid);
		          }
		        }, plugin.getConfig().getLong("AntiSpam.TimeBetweenMessages")*20L);
			}
		}
		
		if(!plugin.getConfig().getBoolean("AntiSpam.AllowConsecutiveRepeats")) {
			if(antirepeat.containsKey(uuid)) {
				String lastMessage = antirepeat.get(uuid);
				if(event.getMessage().equals(lastMessage)) {
					if(!player.hasPermission("truechat.antispam.bypass") && !player.hasPermission("truechat.*")) {
						event.setCancelled(true);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.Repeat")));
					}
					if(!event.isCancelled()) {
						antirepeat.remove(uuid);
						antirepeat.put(uuid, event.getMessage());	
					}
				}else {
					if(!event.isCancelled()) {
						antirepeat.remove(uuid);
						antirepeat.put(uuid, event.getMessage());
					}
				}
			}else {
				if(!event.isCancelled()) {
					antirepeat.remove(uuid);
					antirepeat.put(uuid, event.getMessage());
				}
			}	
		}
		
		if(plugin.getConfig().getInt("AntiSpam.MaxConsecutiveSameCharacter") > 0) {
			if(repetitiveChars(event.getMessage()) && !player.hasPermission("truechat.antispam.bypass") && !player.hasPermission("truechat.*")) {
				event.setCancelled(true);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.CharSpam")));
			}
		}
		
	}

}
