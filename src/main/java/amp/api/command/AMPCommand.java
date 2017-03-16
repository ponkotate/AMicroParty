package amp.api.command;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public abstract class AMPCommand {

  public enum Delimiter {
    PERMISSION("."), USAGE(" ");

    private final String demiliter;

    private Delimiter(String demiliter) {
      this.demiliter = demiliter;
    }

    public String demiliter() {
      return this.demiliter;
    }

  }

  public static final String ERROR_INSUFFICIENT_PERMISSION = "error.insufficient_permission";
  public static final String ERROR_PLAYER_ONLY = "error.player_only";
  public static final String ERROR_NOT_FOUND_PLAYER = "error.not_found_player";

  private final String name;
  private String[] aliases;

  private final AMPCommand parent;

  protected AMPCommand(String name) {
    this.name = name;
    this.parent = null;
    Bukkit.getPluginManager().addPermission(this.getPermission());
  }

  protected AMPCommand(String name, AMPCommand parent, boolean value) {
    this.name = name;
    this.parent = parent;
    this.getParent().ifPresent(p -> this.getPermission().addParent(p.getPermission(), value));
    Bukkit.getPluginManager().addPermission(this.getPermission());
  }

  public String getName() {
    return Objects.requireNonNull(this.name);
  }

  public AMPCommand setAliases(String[] aliases) {
    this.aliases = aliases;
    return this;
  }

  public Optional<AMPCommand> getParent() {
    return Optional.ofNullable(this.parent);
  }

  public Stream<AMPCommand> getParents() {
    return this.getParent().map(p -> Stream.of(p.getParents(), Stream.of(p)).flatMap(s -> s)).orElseGet(Stream::empty);
  }

  public abstract boolean onCommand(CommandSender sender, String label, String[] args);

  public Permission getPermission() {
    String name = this.getParents().map(command -> command.getName()).collect(Collectors.joining(Delimiter.PERMISSION.demiliter()));
    return Optional.ofNullable(Bukkit.getPluginManager().getPermission(name))
        .orElse(new Permission(name, this.getDescription(null), Permission.DEFAULT_PERMISSION));
  }

  public abstract String getDescription(Player player);

  public abstract String getUsage(Player player);

  public String getFormattedUsage(Player player) {
    String name = this.getParents().map(c -> c.getName()).collect(Collectors.joining(Delimiter.USAGE.demiliter()));
    return new StringBuilder("/").append(name).append(" ").append(this.getUsage(player)).append(" : ").append(this.getDescription(player)).toString();
  }

  public boolean equalsCommand(String name) {
    return this.getName().equalsIgnoreCase(name) || Stream.of(this.aliases).anyMatch(alias -> alias.equalsIgnoreCase(name));
  }

  @Override
  public String toString() {
    return new StringBuilder(this.getClass().toString()).append("[name=").append(this.getName()).append(", aliases=").append(this.aliases)
        .append(", parent=").append(this.getParent().map(p -> p.getName()).orElse("null")).append("]").toString();
  }

}
