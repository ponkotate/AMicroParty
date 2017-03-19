package amp.api.util.file;

import java.io.File;
import java.util.Optional;
import java.util.stream.Stream;

public interface IDataFolder {

  File getFolder();

  String getExtension();

  Optional<? extends IDataFile> createDataFile(File file);

  void load();

  Optional<? extends IDataFile> getDataFile(File file);

  Stream<? extends IDataFile> getDataFiles();

  void save();

}
