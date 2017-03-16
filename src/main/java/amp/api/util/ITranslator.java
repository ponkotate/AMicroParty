package amp.api.util;

import java.util.Arrays;
import java.util.Objects;

import org.bukkit.entity.Player;

public interface ITranslator {

  public enum Language {

    ENGLISH("en_US"), JAPANESE("ja_JP");

    private final String lang;

    private Language(String lang) {
      this.lang = lang;
    }

    public static Language getLanguage(String lang) {
      return Arrays.stream(values()).filter(l -> Objects.equals(l.lang(), lang)).findFirst().orElse(ENGLISH);
    }

    public String lang() {
      return this.lang;
    }

  }

  void addDefault(Language lang, String key, String value);

  String translate(Player player, String key);

  String translate(Language lang, String key);

  Language getLanguage(Player player);

}
