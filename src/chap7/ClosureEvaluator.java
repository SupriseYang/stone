package chap7;

import chap6.Environment;
import javassist.gluonj.Require;
import javassist.gluonj.Reviser;
import stone.ast.ASTree;
import stone.ast.Fun;

import java.util.List;

@Require(FuncEvaluator.class)
@Reviser
public class ClosureEvaluator {
    @Reviser
    public static class FunEx extends Fun {
        public FunEx(List<ASTree> c) { super(c); }
        public Object eva(Environment env) {
            return new Function(parameters(), body(), env);
        }
    }

}
