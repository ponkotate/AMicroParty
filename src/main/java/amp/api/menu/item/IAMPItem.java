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

  boolean clickItem(IAMPMenu menu, ItemStack itemstack, Player player, InventoryAction action, ClickType clickType);

  void updateItemStack(Player player, ItemStack itemstack);

  default ItemStack toItemStack(int amount) {
    return this.toItemStack(this, amount);
  }

  ItemStack toItemStack(IAMPItem original, int amount);

  interface IAMPItemBuilder {

    IAMPItemBuilder setMaterial(Material material);

    IAMPItemBuilder setDamage(short damage);

    IAMPItemBuilder setItemMeta(ItemMeta meta);

    Optional<ItemMeta> getItemMeta();

    IAMPItemBuilder setDisplayName(String name);

    IAMPItemBuilder setLore(List<String> lore);

    IAMPItemBuilder setDescription(String description);

    IAMPItem build();

  }

}
