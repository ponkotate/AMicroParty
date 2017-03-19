package amp.api.util.file;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

import org.bukkit.configuration.Configuration;

public interface IDataFile extends Configuration {

  File getFile();

  void load();

  void save();

  boolean backup() throws IOException;

  Optional<String> getPath(Object obj);

  Stream<String> getPaths();

}
