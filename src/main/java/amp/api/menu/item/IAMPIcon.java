package amp.api.menu.item;

import java.util.Optional;

public interface IAMPIcon extends IAMPItem {

  Optional<String> getCommand();

  interface IAMPIconBuilder extends IAMPItemBuilder {

    IAMPIconBuilder setCommand(String command);

    @Override
    IAMPIcon build();

  }

}
