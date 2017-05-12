package amp.api.util;

import java.util.Arrays;
import java.util.Objects;

public enum Language {

  ENGLISH("en_US"), JAPANESE("ja_JP");

  private final String asString;

  private Language(String asString) {
    this.asString = asString;
  }

  public static Language getLanguage(String asString) {
    return Arrays.stream(values()).filter(l -> Objects.equals(l.asString(), asString)).findFirst().orElse(ENGLISH);
  }

  public String asString() {
    return this.asString;
  }

}
