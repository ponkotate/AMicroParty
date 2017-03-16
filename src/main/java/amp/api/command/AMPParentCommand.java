package amp.api.command;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import amp.api.AMicroPartyAPI;

public abstract class AMPParentCommand extends AMPCommand {

  private final Stream<AMPCommand> commands = Stream.empty();

  public AMPParentCommand(String name) {
    super(name);
  }

  public AMPParentCommand(String name, AMPCommand parent, boolean value) {
    super(name, parent, value);
  }

  public void addCommand(AMPCommand command) {
    Stream.concat(this.commands, Stream.of(command));
  }

  @Override
  public boolean onCommand(CommandSender sender, String label, String[] args) {
    final Player player = sender instanceof Player ? (Player) sender : null;

    if (args.length <= 0) return false;

    Stream<AMPCommand> stream = this.commands.filter(c -> c.equalsCommand(args[0]));
    stream.forEach(c -> {
      if (!amp.api.util.Utils.canUseCommand(sender, c))
        AMicroPartyAPI.getPlugin().getMessenger().sendCommandMessage(sender, ERROR_INSUFFICIENT_PERMISSION);
      else if (!c.onCommand(sender, label, Arrays.copyOfRange(args, 1, args.length)))
        sender.sendMessage(c.getFormattedUsage(player));
    });

    return stream.findAny().isPresent();
  }

  @Override
  public String getUsage(Player player) {
    return null;
  }

  @Override
  public String getFormattedUsage(Player player) {
    return Stream.concat(Stream.of(this), this.commands).map(c -> c.getFormattedUsage(player)).collect(Collectors.joining(System.lineSeparator()));
  }

}
