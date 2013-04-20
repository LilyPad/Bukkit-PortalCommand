package lilypad.bukkit.portal.command.util;

import org.bukkit.ChatColor;

public class MessageConstants {

	public static final String PREFIX = "&f[&7Server&f] ";
	public static final String SERVER_OFFLINE = PREFIX + "This server is currently &4offline&f. Try again later!";
	
	public static final String format(String message, Object... args) {
		return ChatColor.translateAlternateColorCodes('&', String.format(message, args));
	}
	
}
