package amp.api.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import amp.api.AMicroPartyAPI;
import amp.api.util.Utils;

public abstract class AMPParentCommand extends AMPCommand {

  private final List<AMPCommand> commands = new ArrayList<>();

  public AMPParentCommand(String name) {
    super(name);
  }

  public AMPParentCommand(String name, AMPCommand parent, boolean value) {
    super(name, parent, value);
  }

  public void addCommand(AMPCommand command) {
    this.commands.add(command);
  }

  @Override
  public boolean onCommand(CommandSender sender, String label, String[] args) {
    final Player player = sender instanceof Player ? (Player) sender : null;

    if (args.length <= 0)
      return false;

    return this.commands.stream().filter(c -> c.equalsCommand(args[0])).findFirst().map(c -> {
      if (!Utils.canUseCommand(sender, c))
        AMicroPartyAPI.getPlugin().getMessenger().sendCommandMessage(sender, ERROR_INSUFFICIENT_PERMISSION);
      else if (!c.onCommand(sender, label, Arrays.copyOfRange(args, 1, args.length)))
        sender.sendMessage(c.getFormattedUsage(player));
      return Boolean.TRUE;
    }).orElse(Boolean.FALSE).booleanValue();
  }

  @Override
  public String getUsage(Player player) {
    return "";
  }

  @Override
  public String getFormattedUsage(Player player) {
    return Stream.concat(Stream.of(super.getFormattedUsage(player)), this.commands.stream().map(c -> c.getFormattedUsage(player)))
        .collect(Collectors.joining(System.lineSeparator()));
  }

}
