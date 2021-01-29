package main.dartanman.truechat.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import main.dartanman.truechat.Main;

public class FrozenChatListener implements Listener{
	
	private Main plugin;
	
	public FrozenChatListener(Main pl) {
		plugin = pl;
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void frozenChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		if(plugin.isChatFrozen()) {
			if(!player.hasPermission("truechat.freeze.bypass") && !player.hasPermission("truechat.*")) {
				event.setCancelled(true);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Messages.ChatIsFrozen")));
			}
		}
	}

}
