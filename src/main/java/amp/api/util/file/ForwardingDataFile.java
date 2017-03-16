package amp.api.util.file;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.Color;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationOptions;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public abstract class ForwardingDataFile implements IDataFile {

  protected ForwardingDataFile() {}

  protected abstract IDataFile delegate();

  @Override
  public File getFile() {
    return this.delegate().getFile();
  }

  @Override
  public void load() {
    this.delegate().load();
  }

  @Override
  public void save() {
    this.delegate().save();
  }

  @Override
  public boolean backup() throws IOException {
    return this.delegate().backup();
  }

  @Override
  public void addDefault(String path, Object value) {
    this.delegate().addDefault(path, value);
  }

  @Override
  public void addDefaults(Map<String, Object> defaults) {
    this.delegate().addDefaults(defaults);
  }

  @Override
  public void addDefaults(Configuration defaults) {
    this.delegate().addDefaults(defaults);
  }

  @Override
  public void setDefaults(Configuration defaults) {
    this.delegate().setDefaults(defaults);
  }

  @Override
  public Configuration getDefaults() {
    return this.delegate().getDefaults();
  }

  @Override
  public ConfigurationOptions options() {
    return this.delegate().options();
  }

  @Override
  public Set<String> getKeys(boolean deep) {
    return this.delegate().getKeys(deep);
  }

  @Override
  public Map<String, Object> getValues(boolean deep) {
    return this.delegate().getValues(deep);
  }

  @Override
  public boolean contains(String path) {
    return this.delegate().contains(path);
  }

  @Override
  public boolean contains(String path, boolean ignoreDefault) {
    return this.delegate().contains(path, ignoreDefault);
  }

  @Override
  public boolean isSet(String path) {
    return this.delegate().isSet(path);
  }

  @Override
  public String getCurrentPath() {
    return this.delegate().getCurrentPath();
  }

  @Override
  public String getName() {
    return this.delegate().getName();
  }

  @Override
  public Configuration getRoot() {
    return this.delegate().getRoot();
  }

  @Override
  public ConfigurationSection getParent() {
    return this.delegate().getParent();
  }

  @Override
  public Object get(String path) {
    return this.delegate().get(path);
  }

  @Override
  public Object get(String path, Object def) {
    return this.delegate().get(path, def);
  }

  @Override
  public void set(String path, Object value) {
    this.delegate().set(path, value);
  }

  @Override
  public ConfigurationSection createSection(String path) {
    return this.delegate().createSection(path);
  }

  @Override
  public ConfigurationSection createSection(String path, Map<?, ?> map) {
    return this.delegate().createSection(path, map);
  }

  @Override
  public String getString(String path) {
    return this.delegate().getString(path);
  }

  @Override
  public String getString(String path, String def) {
    return this.delegate().getString(path, def);
  }

  @Override
  public boolean isString(String path) {
    return this.delegate().isString(path);
  }

  @Override
  public int getInt(String path) {
    return this.delegate().getInt(path);
  }

  @Override
  public int getInt(String path, int def) {
    return this.delegate().getInt(path, def);
  }

  @Override
  public boolean isInt(String path) {
    return this.delegate().isInt(path);
  }

  @Override
  public boolean getBoolean(String path) {
    return this.delegate().getBoolean(path);
  }

  @Override
  public boolean getBoolean(String path, boolean def) {
    return this.delegate().getBoolean(path, def);
  }

  @Override
  public boolean isBoolean(String path) {
    return this.delegate().isBoolean(path);
  }

  @Override
  public double getDouble(String path) {
    return this.delegate().getDouble(path);
  }

  @Override
  public double getDouble(String path, double def) {
    return this.delegate().getDouble(path, def);
  }

  @Override
  public boolean isDouble(String path) {
    return this.delegate().isDouble(path);
  }

  @Override
  public long getLong(String path) {
    return this.delegate().getLong(path);
  }

  @Override
  public long getLong(String path, long def) {
    return this.delegate().getLong(path, def);
  }

  @Override
  public boolean isLong(String path) {
    return this.delegate().isLong(path);
  }

  @Override
  public List<?> getList(String path) {
    return this.delegate().getList(path);
  }

  @Override
  public List<?> getList(String path, List<?> def) {
    return this.delegate().getList(path, def);
  }

  @Override
  public boolean isList(String path) {
    return this.delegate().isList(path);
  }

  @Override
  public List<String> getStringList(String path) {
    return this.delegate().getStringList(path);
  }

  @Override
  public List<Integer> getIntegerList(String path) {
    return this.delegate().getIntegerList(path);
  }

  @Override
  public List<Boolean> getBooleanList(String path) {
    return this.delegate().getBooleanList(path);
  }

  @Override
  public List<Double> getDoubleList(String path) {
    return this.delegate().getDoubleList(path);
  }

  @Override
  public List<Float> getFloatList(String path) {
    return this.delegate().getFloatList(path);
  }

  @Override
  public List<Long> getLongList(String path) {
    return this.delegate().getLongList(path);
  }

  @Override
  public List<Byte> getByteList(String path) {
    return this.delegate().getByteList(path);
  }

  @Override
  public List<Character> getCharacterList(String path) {
    return this.delegate().getCharacterList(path);
  }

  @Override
  public List<Short> getShortList(String path) {
    return this.delegate().getShortList(path);
  }

  @Override
  public List<Map<?, ?>> getMapList(String path) {
    return this.delegate().getMapList(path);
  }

  @Override
  public Vector getVector(String path) {
    return this.delegate().getVector(path);
  }

  @Override
  public Vector getVector(String path, Vector def) {
    return this.delegate().getVector(path, def);
  }

  @Override
  public boolean isVector(String path) {
    return this.delegate().isVector(path);
  }

  @Override
  public OfflinePlayer getOfflinePlayer(String path) {
    return this.delegate().getOfflinePlayer(path);
  }

  @Override
  public OfflinePlayer getOfflinePlayer(String path, OfflinePlayer def) {
    return this.delegate().getOfflinePlayer(path, def);
  }

  @Override
  public boolean isOfflinePlayer(String path) {
    return this.delegate().isOfflinePlayer(path);
  }

  @Override
  public ItemStack getItemStack(String path) {
    return this.delegate().getItemStack(path);
  }

  @Override
  public ItemStack getItemStack(String path, ItemStack def) {
    return this.delegate().getItemStack(path, def);
  }

  @Override
  public boolean isItemStack(String path) {
    return this.delegate().isItemStack(path);
  }

  @Override
  public Color getColor(String path) {
    return this.delegate().getColor(path);
  }

  @Override
  public Color getColor(String path, Color def) {
    return this.delegate().getColor(path, def);
  }

  @Override
  public boolean isColor(String path) {
    return this.delegate().isColor(path);
  }

  @Override
  public ConfigurationSection getConfigurationSection(String path) {
    return this.delegate().getConfigurationSection(path);
  }

  @Override
  public boolean isConfigurationSection(String path) {
    return this.delegate().isConfigurationSection(path);
  }

  @Override
  public ConfigurationSection getDefaultSection() {
    return this.delegate().getDefaultSection();
  }

}
