package amp.api.registry;

import java.util.Optional;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import amp.api.configuration.file.IDataDirectory;
import amp.api.menu.item.IAMPIcon.IAMPIconBuilder;
import amp.api.menu.item.IAMPItem;
import amp.api.menu.item.IAMPItem.IAMPItemBuilder;;

public interface IAMPItemRegistry extends IDataDirectory {

  static String NBT_ITEM_ID = "amp_itemid";
  static String NBT_COMMAND = "command";
  static String NBT_INDEX = "index";

  IAMPItemBuilder newItem(Material material, short damage);

  IAMPIconBuilder newIcon(Material material, short damage);

  void registerTempItem(IAMPItem item, ItemStack itemstack);

  Optional<IAMPItem> getItem(String id);

  Optional<? extends IAMPItem> getItem(ItemStack itemstack);

}
