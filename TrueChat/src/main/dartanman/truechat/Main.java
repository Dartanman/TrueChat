/**
 * I got lazy and didn't do comments for most of this project.
 * @author Dartanman (Austin Dart)
 */

package main.dartanman.truechat;

import org.bukkit.plugin.java.JavaPlugin;

import main.dartanman.truechat.commands.TrueChatCmd;
import main.dartanman.truechat.events.AntiAdListener;
import main.dartanman.truechat.events.AntiSpamListener;
import main.dartanman.truechat.events.AntiSwearListener;
import main.dartanman.truechat.events.FrozenChatListener;
import main.dartanman.truechat.events.GrammarListener;

public class Main extends JavaPlugin{
	
	/*
	 * Permissions list (so I don't forget them)
	 * truechat.*
	 * truechat.help
	 * truechat.clear.global
	 * truechat.clear.self
	 * truechat.clear.player
	 * truechat.antispam.bypass
	 * truechat.antiadvertisement.bypass
	 * truechat.freeze
	 * truechat.freeze.bypass
	 * truechat.antiswear.bypass
	 */
	
	private boolean frozenChat = false;
	
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		getCommand("truechat").setExecutor(new TrueChatCmd(this));
		getServer().getPluginManager().registerEvents(new AntiSpamListener(this), this);
		getServer().getPluginManager().registerEvents(new AntiAdListener(this), this);
		getServer().getPluginManager().registerEvents(new FrozenChatListener(this), this);
		getServer().getPluginManager().registerEvents(new AntiSwearListener(this), this);
		getServer().getPluginManager().registerEvents(new GrammarListener(this), this);
	}
	
	public void onDisable() {
		
	}
	
	public boolean isChatFrozen() {
		return frozenChat;
	}
	
	public void setChatFrozen(boolean frozen) {
		frozenChat = frozen;
	}

}
