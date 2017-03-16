package amp.api.util.registry;

import java.io.File;
import java.util.Optional;
import java.util.stream.Stream;

public interface IAMPRegistry<V> {

  File getFolder();

  void register(String path, File file, V value);

  Stream<String> getIds();

  boolean hasId(V value);

  Optional<String> getId(V value);

  boolean hasValue(String path);

  Stream<? extends V> get(String path);

  void load();

  void save();

}
