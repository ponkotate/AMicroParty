package amp.api;

import amp.api.command.AMPParentCommand;
import amp.api.registry.IAMPItemRegistry;
import amp.api.registry.IAMPMenuRegistry;
import amp.api.util.IMessenger;
import amp.api.util.ITranslator;

public interface IAMicroParty extends IAMPAddon {

  ITranslator getTranslator();

  IMessenger getMessenger();

  AMPParentCommand getBasicCommand();

  IAMPItemRegistry getAMPItemRegistry();

  IAMPMenuRegistry getAMPMenuRegistry();

}
