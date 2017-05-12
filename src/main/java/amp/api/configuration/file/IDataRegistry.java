package amp.api.configuration.file;

import java.util.Optional;
import java.util.stream.Stream;

public interface IDataRegistry {

  Optional<String> getId(Object obj);

  Stream<String> getIds();

  <T> Optional<T> as(String id, Class<T> classOfT);

}
