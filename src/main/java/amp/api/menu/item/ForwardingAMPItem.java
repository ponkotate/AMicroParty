package amp.api.menu.item;

import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.ItemStack;

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
  public ItemStack toItemStack(int amount) {
    return this.delegate().toItemStack(amount);
  }

  @Override
  public Map<String, Object> serialize() {
    return this.delegate().serialize();
  }

  @Override
  public String toString() {
    return this.delegate().toString();
  }

}
