package amp.api.menu.item;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import amp.api.menu.IAMPMenu;

public abstract class ForwardingAMPItem implements IAMPItem {

  protected ForwardingAMPItem() {}

  protected abstract IAMPItem delegate();

  @Override
  public boolean clickItem(IAMPMenu menu, ItemStack itemstack, Player player, InventoryAction action, ClickType clickType) {
    return this.delegate().clickItem(menu, itemstack, player, action, clickType);
  }

  @Override
  public void updateItemStack(Player player, ItemStack itemstack) {
    this.delegate().updateItemStack(player, itemstack);
  }

  @Override
  public ItemStack toItemStack(IAMPItem original, int amount) {
    return this.delegate().toItemStack(original, amount);
  }

  @Override
  public Map<String, Object> serialize() {
    return this.delegate().serialize();
  }

  @Override
  public String toString() {
    return this.delegate().toString();
  }

  public static abstract class ForwardingAMPItemBuilder implements IAMPItemBuilder {

    protected ForwardingAMPItemBuilder() {}

    protected abstract IAMPItemBuilder delegate();

    @Override
    public IAMPItemBuilder setMaterial(Material material) {
      this.delegate().setMaterial(material);
      return this;
    }

    @Override
    public IAMPItemBuilder setDamage(short damage) {
      this.delegate().setDamage(damage);
      return this;
    }

    @Override
    public IAMPItemBuilder setItemMeta(ItemMeta meta) {
      this.delegate().setItemMeta(meta);
      return this;
    }

    @Override
    public Optional<ItemMeta> getItemMeta() {
      return this.delegate().getItemMeta();
    }

    @Override
    public IAMPItemBuilder setDisplayName(String name) {
      this.delegate().setDisplayName(name);
      return this;
    }

    @Override
    public IAMPItemBuilder setLore(List<String> lore) {
      this.delegate().setLore(lore);
      return this;
    }

    @Override
    public IAMPItemBuilder setDescription(String description) {
      this.delegate().setDescription(description);
      return this;
    }

  }

}
