package amp.api.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public interface IAMPMenu extends Inventory, InventoryHolder {

  boolean openInventory(Player player);

  void updateInventory(Player player);

  boolean clickInventory(int slot, Player player, InventoryAction action, ClickType clickType);

  void closeInventory();

  boolean isValid(int slot, ItemStack itemstack);

  void fillItem(ItemStack itemstack);

  IAMPMenu copyAs(String title);

  IAMPMenu copy();

}
