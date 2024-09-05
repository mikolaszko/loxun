package loxun;

import java.util.HashMap;
import java.util.Map;

public class LoxunInstance {
  private LoxunClass klass;
  private final Map<String, Object> fields = new HashMap<>();

  public LoxunInstance(LoxunClass klass) {
    this.klass = klass;
  }

  public Object get(Token name) {
    if (fields.containsKey(name.lexeme)) {
      return fields.get(name.lexeme);
    }

    throw new RuntimeError(name, "Undefined property '" + name.lexeme + "'.");
  }

  public void set(Token name, Object value) {
    fields.put(name.lexeme, value);
  }

  @Override
  public String toString() {
    return klass.name + " instance";
  }
}
