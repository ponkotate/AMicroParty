package amp.api.configuration.file;

import java.io.File;
import java.util.Optional;
import java.util.stream.Stream;

import com.google.common.collect.ForwardingObject;

public abstract class ForwardingDataDirectory extends ForwardingObject implements IDataDirectory {

  @Override
  protected abstract IDataDirectory delegate();

  @Override
  public File getDirectory() {
    return this.delegate().getDirectory();
  }

  @Override
  public String getExtension() {
    return this.delegate().getExtension();
  }

  @Override
  public IDataFile getDataFile(File file) {
    return this.delegate().getDataFile(file);
  }

  @Override
  public Stream<IDataFile> getDataFiles() {
    return this.delegate().getDataFiles();
  }

  @Override
  public <T> Optional<T> as(String id, Class<T> classOfT) {
    return this.delegate().as(id, classOfT);
  }

  @Override
  public Optional<String> getId(Object obj) {
    return this.delegate().getId(obj);
  }

  @Override
  public Stream<String> getIds() {
    return this.delegate().getIds();
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
