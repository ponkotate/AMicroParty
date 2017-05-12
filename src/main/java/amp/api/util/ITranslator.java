package amp.api.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.bukkit.entity.Player;

public interface ITranslator {

  static final String REGEX = "\\.";
  static final String REPLACEMENT = "_";

  void addDefault(Language lang, String key, String value);

  String translate(Player player, String key);

  String translate(Language lang, String key);

  static Language getLanguage(Player player) {
    if (player == null)
      return Language.ENGLISH;

    try {
      Class<? extends Player> classPlayer = player.getClass();
      Method methodGetHandle = classPlayer.getMethod("getHandle");
      Object eplayer = methodGetHandle.invoke(player);

      Class<? extends Object> classEntityPlayer = eplayer.getClass();
      Field fieldLocale = classEntityPlayer.getDeclaredField("locale");
      fieldLocale.setAccessible(true);

      return Language.getLanguage(fieldLocale.get(eplayer).toString());
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | NoSuchFieldException e) {
      e.printStackTrace();
      return Language.ENGLISH;
    }
  }

  void load();

  void save();

}
