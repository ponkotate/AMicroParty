package amp.api;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;

import amp.api.menu.IAMPMenu;
import amp.api.menu.item.IAMPIcon.IAMPIconBuilder;
import amp.api.menu.item.IAMPItem.IAMPItemBuilder;

public final class AMicroPartyAPI {

  private static final AMPPluginManager<IAMicroParty> MANAGER = new AMPPluginManager<IAMicroParty>();

  private AMicroPartyAPI() {}

  public static AMPPluginManager<IAMicroParty> getRegistry() {
    return MANAGER;
  }

  public static IAMicroParty getPlugin() {
    return MANAGER.get();
  }

  public static IAMPItemBuilder newItem(Material material, short damage) {
    return getPlugin().getAMPItemRegistry().newItem(material, damage);
  }

  public static IAMPIconBuilder newIcon(Material material, short damage) {
    return getPlugin().getAMPItemRegistry().newIcon(material, damage);
  }

  public static IAMPMenu newMenu(InventoryType type) {
    return getPlugin().getAMPMenuRegistry().newMenu(type);
  }

  public static IAMPMenu newMenu(InventoryType type, String title) {
    return getPlugin().getAMPMenuRegistry().newMenu(type, title);
  }

  public static IAMPMenu newMenu(int size) {
    return getPlugin().getAMPMenuRegistry().newMenu(size);
  }

  public static IAMPMenu newMenu(int size, String title) {
    return getPlugin().getAMPMenuRegistry().newMenu(size, title);
  }

}
