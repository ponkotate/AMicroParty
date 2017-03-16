package amp.api.util;

import org.bukkit.command.CommandSender;

public interface IMessenger {

  void sendCommandMessage(CommandSender sender, String message);

}
