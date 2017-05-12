package amp.api.configuration.file;

import java.io.File;
import java.util.stream.Stream;

public interface IDataDirectory extends IDataRegistry {

  File getDirectory();

  String getExtension();

  Stream<IDataFile> getDataFiles();

  IDataFile getDataFile(File file);

  void load();

  void save();

}
