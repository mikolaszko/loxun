package loxun;

import java.util.List;

public class LoxunFunction implements LoxunCallable {
  private final Stmt.Function declaration;
  private final Environment closure;
  private final boolean isInitializer;

  public LoxunFunction(Stmt.Function declaration, Environment closure, boolean isInitializer) {
    this.isInitializer = isInitializer;
    this.closure = closure;
    this.declaration = declaration;
  }

  @Override
  public int arity() {
    return declaration.params.size();
  }

  @Override
  public String toString() {
    return "<fn" + declaration.name.lexeme + ">";
  }

  @Override
  public Object call(Interpreter interpreter, List<Object> arguments) {
    Environment environment = new Environment(closure);

    for (int i = 0; i < declaration.params.size(); i++) {
      environment.define(declaration.params.get(i).lexeme, arguments.get(i));
    }

    try {
      interpreter.executeBlock(declaration.body, environment);
    } catch (Return returnValue) {
      if (isInitializer)
        return closure.getAt(0, "this");
      return returnValue.value;
    }

    if (isInitializer)
      return closure.getAt(0, "this");
    return null;
  }

  public LoxunFunction bind(LoxunInstance instance) {
    Environment environment = new Environment(closure);
    environment.define("this", instance);
    return new LoxunFunction(declaration, environment, isInitializer);
  }
}
