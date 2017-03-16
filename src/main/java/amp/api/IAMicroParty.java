package amp.api;

import amp.api.command.AMPParentCommand;
import amp.api.util.IMessenger;
import amp.api.util.ITranslator;
import amp.api.util.registry.IAMPItemRegistry;
import amp.api.util.registry.IAMPMenuRegistry;

public interface IAMicroParty extends IAMPAddon {

  ITranslator getTranslator();

  IMessenger getMessenger();

  AMPParentCommand getBasicCommand();

  IAMPItemRegistry getAMPItemRegistry();

  IAMPMenuRegistry getAMPMenuRegistry();

}
