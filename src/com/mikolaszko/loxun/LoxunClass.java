package loxun;

import java.util.List;
import java.util.Map;

public class LoxunClass implements LoxunCallable {
  final String name;
  final LoxunClass superclass;
  private final Map<String, LoxunFunction> methods;

  public LoxunClass(String name, LoxunClass superclass, Map<String, LoxunFunction> methods) {
    this.superclass = superclass;
    this.name = name;
    this.methods = methods;
  }

  public LoxunFunction findMethod(String name) {
    if (methods.containsKey(name)) {
      return methods.get(name);
    }

    // poetic
    if (superclass != null) {
      return superclass.findMethod(name);
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
    LoxunFunction initializer = findMethod("init");
    if (initializer != null) {
      initializer.bind(instance).call(interpreter, arguments);
    }
    return instance;
  }

  @Override
  public int arity() {
    LoxunFunction initializer = findMethod("init");
    if (initializer == null)
      return 0;
    return initializer.arity();
  }
}
