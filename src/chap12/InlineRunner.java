package chap12;

import chap8.NativeEvaluator;
import javassist.gluonj.util.Loader;

public class InlineRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(ObjOptInterpreter.class, args, InlineCache.class, NativeEvaluator.class);
    }
}
