package amp.api.command;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import amp.api.AMicroPartyAPI;
import amp.api.util.Language;

public abstract class AMPCommand {

  public static final String DELIMITER_PERMISSION = ".";
  public static final String DELIMITER_USAGE = " ";

  public static final String ERROR_INSUFFICIENT_PERMISSION = "error.insufficient_permission";
  public static final String ERROR_PLAYER_ONLY = "error.player_only";
  public static final String ERROR_NOT_FOUND_PLAYER = "error.not_found_player";

  private final String name;
  private String[] aliases = {};

  private final AMPCommand parent;

  protected AMPCommand(String name) {
    this.name = name;
    this.parent = null;
    Bukkit.getPluginManager().addPermission(this.getPermission());
  }

  protected AMPCommand(String name, AMPCommand parent, boolean value) {
    this.name = Objects.requireNonNull(name);
    this.parent = parent;
    this.getParent().ifPresent(p -> this.getPermission().addParent(p.getPermission(), value));
    Bukkit.getPluginManager().addPermission(this.getPermission());
  }

  public String getName() {
    return this.name;
  }

  public AMPCommand setAliases(String[] aliases) {
    this.aliases = Objects.requireNonNull(aliases);
    return this;
  }

  public Optional<AMPCommand> getParent() {
    return Optional.ofNullable(this.parent);
  }

  public Stream<AMPCommand> getParents() {
    return Stream.concat(this.getParent().map(AMPCommand::getParents).orElseGet(Stream::empty), Stream.of(this));
  }

  public abstract boolean onCommand(CommandSender sender, String label, String[] args);

  public Permission getPermission() {
    String name = this.getParents().map(command -> command.getName()).collect(Collectors.joining(DELIMITER_PERMISSION));
    return Optional.ofNullable(Bukkit.getPluginManager().getPermission(name))
        .orElse(new Permission(name, AMicroPartyAPI.getPlugin().getTranslator().translate(Language.ENGLISH, this.getDescription()), Permission.DEFAULT_PERMISSION));
  }

  public abstract String getDescription();

  public abstract String getUsage(Player player);

  public String getFormattedUsage(Player player) {
    String name = this.getParents().map(c -> c.getName()).collect(Collectors.joining(DELIMITER_USAGE));
    StringBuilder builder = new StringBuilder("/").append(name);
    String usage = this.getUsage(player);

    if (usage != null && usage.length() > 0)
      builder.append(" ").append(usage);
    return builder.append(" : ").append(AMicroPartyAPI.getPlugin().getTranslator().translate(player, this.getDescription())).toString();
  }

  public boolean equalsCommand(String name) {
    return this.getName().equalsIgnoreCase(name) || Arrays.stream(this.aliases).anyMatch(alias -> alias.equalsIgnoreCase(name));
  }

  @Override
  public String toString() {
    return new StringBuilder(this.getClass().toString()).append("[name=").append(this.getName()).append(", aliases=").append(this.aliases)
        .append(", parent=").append(this.getParent().map(p -> p.getName()).orElse("null")).append("]").toString();
  }

}
