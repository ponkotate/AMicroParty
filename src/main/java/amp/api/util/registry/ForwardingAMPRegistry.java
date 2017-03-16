package amp.api.util.registry;

import java.io.File;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class ForwardingAMPRegistry<V> implements IAMPRegistry<V> {

  public ForwardingAMPRegistry() {}

  protected abstract IAMPRegistry<V> delegate();

  @Override
  public File getFolder() {
    return this.delegate().getFolder();
  }

  @Override
  public void register(String path, File file, V value) {
    this.delegate().register(path, file, value);
  }

  @Override
  public Stream<String> getIds() {
    return this.delegate().getIds();
  }

  @Override
  public boolean hasId(V value) {
    return this.delegate().hasId(value);
  }

  @Override
  public Optional<String> getId(V value) {
    return this.delegate().getId(value);
  }

  @Override
  public boolean hasValue(String path) {
    return this.delegate().hasValue(path);
  }

  @Override
  public Stream<? extends V> get(String path) {
    return this.delegate().get(path);
  }

  @Override
  public void load() {
    this.delegate().load();
  }

  @Override
  public void save() {
    this.delegate().save();
  }

}
