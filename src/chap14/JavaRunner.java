package chap14;

import chap8.NativeEvaluator;
import javassist.gluonj.util.Loader;

/**
 * Created with IntelliJ IDEA.
 * User: kametaro-main
 * Date: 2013/11/05
 * Time: 23:44
 * To change this template use File | Settings | File Templates.
 */
public class JavaRunner {
    public static void main(String[] args) throws Throwable {
        Loader.run(TypedInterpreter.class, args, ToJava.class,
                InferFuncTypes.class, NativeEvaluator.class);
    }
}
