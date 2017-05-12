package amp.api.configuration.file;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.Configuration;

public interface IDataFile extends Configuration, IDataRegistry {

  File getFile();

  void readFromFile();

  void writeToFile();

  boolean backup() throws IOException;

}
