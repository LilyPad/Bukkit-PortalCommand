package lilypad.bukkit.portal.command;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ServerCommand implements CommandExecutor {

	private List<String> allowedServers;
	private IConfig config;
	private IRedirector redirector;
	
	public ServerCommand(IConfig config, IRedirector redirector) {
		this.allowedServers = config.getAllowedServers();
		this.config = config;
		this.redirector = redirector;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args.length == 0) {
			StringBuilder servers = new StringBuilder();
			boolean first = true;
			for(String server : this.allowedServers) {
				if(first) {
					first = false;
				} else {
					servers.append(", ");
				}
				servers.append(this.config.getMessage("server").replace("{name}", server));
			}
			sender.sendMessage(this.config.getMessage("allowed-servers").replace("{servers}", servers.toString()));
			return true;
		}
		String server = null;
		for(String allowedServer : this.allowedServers) {
			if(!allowedServer.equalsIgnoreCase(args[0])) {
				continue;
			}
			server = allowedServer;
		}
		if(server == null) {
			return true;
		}
		if(!(sender instanceof Player)) {
			return true;
		}
		this.redirector.requestRedirect((Player) sender, server);
		return true;
	}

}
