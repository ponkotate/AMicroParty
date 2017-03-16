package amp.api.menu.item;

import java.util.Optional;

public interface IAMPIcon extends IAMPItem {

  public enum TagIcon {

    COMMAND("command");

    private final String tag;

    private TagIcon(String s) {
      this.tag = s;
    }

    public String tag() {
      return this.tag;
    }
  }

  Optional<String> getCommand();

  public interface IAMPIconBuilder extends IAMPItemBuilder {

    IAMPIconBuilder setCommand(String command);

    @Override
    IAMPIcon build();

  }

}
