package loxun;

import java.util.List;
import java.util.Map;

public class LoxunClass implements LoxunCallable {
  final String name;
  private final Map<String, LoxunFunction> methods;

  public LoxunClass(String name, Map<String, LoxunFunction> methods) {
    this.name = name;
    this.methods = methods;
  }

  public LoxunFunction findMethod(String name) {
    if (methods.containsKey(name)) {
      return methods.get(name);
    }

    return null;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public Object call(Interpreter interpreter, List<Object> arguments) {
    LoxunInstance instance = new LoxunInstance(this);
    return instance;
  }

  @Override
  public int arity() {
    return 0;
  }
}
