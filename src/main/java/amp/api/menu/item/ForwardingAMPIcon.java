package amp.api.menu.item;

import java.util.Optional;

public abstract class ForwardingAMPIcon extends ForwardingAMPItem implements IAMPIcon {

  protected ForwardingAMPIcon() {}

  @Override
  protected abstract IAMPIcon delegate();

  @Override
  public Optional<String> getCommand() {
    return this.delegate().getCommand();
  }

}
