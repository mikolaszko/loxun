package loxun;

import java.util.List;

public class LoxunClass implements LoxunCallable {
  final String name;

  public LoxunClass(String name) {
    this.name = name;
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
