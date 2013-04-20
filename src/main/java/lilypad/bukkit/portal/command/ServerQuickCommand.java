package lilypad.bukkit.portal.command;

import java.util.List;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class ServerQuickCommand implements Listener {

	private List<String> allowedServers;
	private IRedirector redirector;
	
	public ServerQuickCommand(IConfig config, IRedirector redirector) {
		this.allowedServers = config.getAllowedServers();
		this.redirector = redirector;
	}
	
	public void onCommandPreprocess(PlayerCommandPreprocessEvent event) {
		String command = event.getMessage().substring(1);
		int index;
		if((index = command.indexOf(' ')) != -1) {
			command = command.substring(0, index);
		}
		if(!this.allowedServers.contains(command)) {
			return;
		}
		this.redirector.requestRedirect(event.getPlayer(), command);
		event.setCancelled(true);
	}

}
