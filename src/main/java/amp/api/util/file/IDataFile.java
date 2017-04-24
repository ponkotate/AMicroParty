package amp.api.util.file;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface IDataFile extends Map<String, Object>, IDataRegistry {

  File getFile();

  void readFromFile();

  void writeToFile();

  boolean backup() throws IOException;

  Object put(String[] keyArray, Object value);

}
