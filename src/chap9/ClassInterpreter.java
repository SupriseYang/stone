package chap9;

import chap6.BasicInterpreter;
import chap7.NestedEnv;
import chap8.Natives;
import stone.ClassParser;
import stone.ParseException;

public class ClassInterpreter extends BasicInterpreter {
    public static void main(String[] args) throws ParseException {
        run(new ClassParser(), new Natives().environment(new NestedEnv()));
    }
}
