package lilypad.bukkit.portal.command;

import java.util.List;

public interface IConfig {
	
	public List<String> getAllowedServers();
	
	public boolean isQuickCommands();
	
	public String getMessage(String id);
	
}
