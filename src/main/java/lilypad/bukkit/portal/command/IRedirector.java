package lilypad.bukkit.portal.command;

import org.bukkit.entity.Player;

public interface IRedirector {

	public void requestRedirect(Player player, String server);
	
}
