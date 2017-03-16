package amp.api.menu.item;

import java.util.List;
import java.util.Optional;

import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import amp.api.menu.IAMPMenu;

public interface IAMPItem extends ConfigurationSerializable {

  public enum TagItem {

    MATERIAL("material"), DAMAGE("damage"), METADATA("meta");

    private final String tag;

    private TagItem(String tag) {
      this.tag = tag;
    }

    public String tag() {
      return this.tag;
    }

  }

  boolean clickItem(IAMPMenu menu, ItemStack itemstack, Player player, InventoryAction action, ClickType clickType);

  void updateItemStack(Player player, ItemStack itemstack);

  ItemStack toItemStack(int amount);

  public interface IAMPItemBuilder {

    IAMPItemBuilder setMaterial(Material material);

    IAMPItemBuilder setDamage(short damage);

    Optional<ItemMeta> getItemMeta();

    IAMPItemBuilder setDisplayName(String name);

    IAMPItemBuilder setLore(List<String> lore);

    IAMPItemBuilder setDescription(String description);

    IAMPItem build();

  }

}
