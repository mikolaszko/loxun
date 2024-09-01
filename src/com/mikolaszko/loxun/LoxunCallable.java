package loxun;

import java.util.List;

public interface LoxunCallable {
    int arity();
    Object call(Interpreter interpreter, List<Object> aruguments);
}
