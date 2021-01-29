package main.dartanman.truechat.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import main.dartanman.truechat.Main;
import main.dartanman.truechat.utils.PunctuationFixer;

public class GrammarListener implements Listener{
	
	private Main plugin;
	public GrammarListener(Main pl) {
		plugin = pl;
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		if(plugin.getConfig().getBoolean("Grammar.FixContractions")) {
			String message = event.getMessage();
			message = PunctuationFixer.fixContractions(message);
			event.setMessage(message);
		}
	}

}
