package amp.api.registry;

import java.util.Optional;

import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;

import amp.api.configuration.file.IDataDirectory;
import amp.api.menu.IAMPMenu;

public interface IAMPMenuRegistry extends IDataDirectory, Listener {

  IAMPMenu newMenu(InventoryType type);

  IAMPMenu newMenu(InventoryType type, String title);

  IAMPMenu newMenu(int size);

  IAMPMenu newMenu(int size, String title);

  IAMPMenu newCommandMenu(InventoryType type);

  IAMPMenu newCommandMenu(InventoryType type, String title);

  IAMPMenu newCommandMenu(int size);

  IAMPMenu newCommandMenu(int size, String title);

  Optional<IAMPMenu> getMenu(String id);

}
