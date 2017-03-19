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

  public static abstract class ForwardingAMPIconBuilder extends ForwardingAMPItemBuilder implements IAMPIconBuilder {

    @Override
    protected abstract IAMPIconBuilder delegate();

    @Override
    public IAMPIconBuilder setCommand(String command) {
      this.delegate().setCommand(command);
      return this;
    }

    @Override
    public IAMPIcon build() {
      return this.delegate().build();
    }

  }

}
