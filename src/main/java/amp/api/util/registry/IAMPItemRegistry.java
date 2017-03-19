package amp.api.util.registry;

import java.util.Optional;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import amp.api.menu.item.IAMPIcon.IAMPIconBuilder;
import amp.api.menu.item.IAMPItem;
import amp.api.menu.item.IAMPItem.IAMPItemBuilder;

public interface IAMPItemRegistry extends IAMPRegistry<IAMPItem> {

  public enum NBT {
    ITEM_ID("amp_itemid"), COMMAND("command"), INDEX("index");

    private final String tag;

    private NBT(String tag) {
      this.tag = tag;
    }

    public String tag() {
      return this.tag;
    }

  }

  IAMPItemBuilder newItem(Material material, short damage);

  IAMPIconBuilder newIcon(Material material, short damage);

  void registerTempItem(IAMPItem item, ItemStack itemstack);

  Optional<? extends IAMPItem> getItem(ItemStack itemstack);

}
