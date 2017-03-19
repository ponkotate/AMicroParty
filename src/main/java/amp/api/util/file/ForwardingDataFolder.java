package amp.api.util.file;

import java.io.File;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class ForwardingDataFolder implements IDataFolder {

  protected ForwardingDataFolder() {}

  protected abstract IDataFolder delegate();

  @Override
  public File getFolder() {
    return this.delegate().getFolder();
  }

  @Override
  public String getExtension() {
    return this.delegate().getExtension();
  }

  @Override
  public Optional<? extends IDataFile> createDataFile(File file) {
    return this.delegate().createDataFile(file);
  }

  @Override
  public void load() {
    this.delegate().load();
  }

  @Override
  public Optional<? extends IDataFile> getDataFile(File file) {
    return this.delegate().getDataFile(file);
  }

  @Override
  public Stream<? extends IDataFile> getDataFiles() {
    return this.delegate().getDataFiles();
  }

  @Override
  public void save() {
    this.delegate().save();
  }

}
