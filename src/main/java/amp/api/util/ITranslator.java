package amp.api.util;

import org.bukkit.entity.Player;

public interface ITranslator {

  void addDefault(Language lang, String key, String value);

  String translate(Player player, String key);

  String translate(Language lang, String key);

  Language getLanguage(Player player);

  void load();

  void save();

}
