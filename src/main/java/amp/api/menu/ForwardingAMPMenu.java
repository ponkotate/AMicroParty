package amp.api.menu;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public abstract class ForwardingAMPMenu implements IAMPMenu {

  protected ForwardingAMPMenu() {}

  protected abstract IAMPMenu delegate();

  @Override
  public Inventory getInventory() {
    return this.delegate().getInventory();
  }

  @Override
  public boolean openInventory(Player player) {
    return this.delegate().openInventory(player);
  }

  @Override
  public void updateInventory(Player player) {
    this.delegate().updateInventory(player);
  }

  @Override
  public boolean clickInventory(int slot, Player player, InventoryAction action, ClickType clickType) {
    return this.delegate().clickInventory(slot, player, action, clickType);
  }

  @Override
  public void closeInventory() {
    this.delegate().closeInventory();
  }

  @Override
  public int getSize() {
    return this.delegate().getSize();
  }

  @Override
  public int getMaxStackSize() {
    return this.delegate().getMaxStackSize();
  }

  @Override
  public void setMaxStackSize(int size) {
    this.delegate().setMaxStackSize(size);
  }

  @Override
  public String getName() {
    return this.delegate().getName();
  }

  @Override
  public ItemStack getItem(int index) {
    return this.delegate().getItem(index);
  }

  @Override
  public boolean isValid(int slot, ItemStack itemstack) {
    return this.delegate().isValid(slot, itemstack);
  }

  @Override
  public void setItem(int slot, ItemStack itemstack) {
    this.delegate().setItem(slot, itemstack);
  }

  @Override
  public void fillItem(ItemStack itemstack) {
    this.delegate().fillItem(itemstack);
  }

  @Override
  public HashMap<Integer, ItemStack> addItem(ItemStack... items) throws IllegalArgumentException {
    return this.delegate().addItem(items);
  }

  @Override
  public HashMap<Integer, ItemStack> removeItem(ItemStack... items) throws IllegalArgumentException {
    return this.delegate().removeItem(items);
  }

  @Override
  public ItemStack[] getContents() {
    return this.delegate().getContents();
  }

  @Override
  public void setContents(ItemStack[] items) throws IllegalArgumentException {
    this.delegate().setContents(items);
  }

  @Override
  public ItemStack[] getStorageContents() {
    return this.delegate().getStorageContents();
  }

  @Override
  public void setStorageContents(ItemStack[] items) throws IllegalArgumentException {
    this.delegate().setStorageContents(items);
  }

  @Deprecated
  @Override
  public boolean contains(int materialId) {
    return this.delegate().contains(materialId);
  }

  @Override
  public boolean contains(Material material) throws IllegalArgumentException {
    return this.delegate().contains(material);
  }

  @Override
  public boolean contains(ItemStack item) {
    return this.delegate().contains(item);
  }

  @Deprecated
  @Override
  public boolean contains(int materialId, int amount) {
    return this.delegate().contains(materialId, amount);
  }

  @Override
  public boolean contains(Material material, int amount) throws IllegalArgumentException {
    return this.delegate().contains(material, amount);
  }

  @Override
  public boolean contains(ItemStack item, int amount) {
    return this.delegate().contains(item, amount);
  }

  @Override
  public boolean containsAtLeast(ItemStack item, int amount) {
    return this.delegate().containsAtLeast(item, amount);
  }

  @Deprecated
  @Override
  public HashMap<Integer, ? extends ItemStack> all(int materialId) {
    return this.delegate().all(materialId);
  }

  @Override
  public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException {
    return this.delegate().all(material);
  }

  @Override
  public HashMap<Integer, ? extends ItemStack> all(ItemStack item) {
    return this.delegate().all(item);
  }

  @Deprecated
  @Override
  public int first(int materialId) {
    return this.delegate().first(materialId);
  }

  @Override
  public int first(Material material) throws IllegalArgumentException {
    return this.delegate().first(material);
  }

  @Override
  public int first(ItemStack item) {
    return this.delegate().first(item);
  }

  @Override
  public int firstEmpty() {
    return this.delegate().firstEmpty();
  }

  @Deprecated
  @Override
  public void remove(int materialId) {
    this.delegate().remove(materialId);
  }

  @Override
  public void remove(Material material) throws IllegalArgumentException {
    this.delegate().remove(material);
  }

  @Override
  public void remove(ItemStack item) {
    this.delegate().remove(item);
  }

  @Override
  public void clear(int index) {
    this.delegate().clear(index);
  }

  @Override
  public void clear() {
    this.delegate().clear();
  }

  @Override
  public List<HumanEntity> getViewers() {
    return this.delegate().getViewers();
  }

  @Override
  public String getTitle() {
    return this.delegate().getTitle();
  }

  @Override
  public InventoryType getType() {
    return this.delegate().getType();
  }

  @Override
  public InventoryHolder getHolder() {
    return this.delegate().getHolder();
  }

  @Override
  public ListIterator<ItemStack> iterator() {
    return this.delegate().iterator();
  }

  @Override
  public ListIterator<ItemStack> iterator(int index) {
    return this.delegate().iterator(index);
  }

  @Override
  public Location getLocation() {
    return this.delegate().getLocation();
  }

  @Override
  public IAMPMenu copyAs(String title) {
    return this.delegate().copyAs(title);
  }

  @Override
  public IAMPMenu copy() {
    return this.delegate().copy();
  }

  @Override
  public Map<String, Object> serialize() {
    return this.delegate().serialize();
  }

}
