package amp.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AMPPluginManager<T extends IAMPAddon> {

  private T plugin;
  private List<IAMPAddon> listAddons = new ArrayList<IAMPAddon>();

  public void init(T plugin) {
    this.plugin = plugin;
    register(plugin);
  }

  public boolean isEnable() {
    return plugin != null;
  }

  public T get() {
    return Optional.of(plugin).get();
  }

  public void register(IAMPAddon addon) {
    listAddons.add(addon);
  }

  public void reload() {
    listAddons.stream().forEach(e -> e.reload());
  }

  public void save() {
    listAddons.stream().forEach(e -> e.save());
  }

}
