package chap13;

import chap8.NativeEvaluator;
import javassist.gluonj.util.Loader;

public class VmRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(VmInterpreter.class, args, VmEvaluator.class, NativeEvaluator.class);
    }
}
