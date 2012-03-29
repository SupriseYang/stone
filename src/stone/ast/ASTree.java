package stone.ast;

import java.util.Iterator;

public abstract class ASTree implements Iterator<ASTree> {
    public abstract ASTree child(int i);
    public abstract int numChildren();
    public abstract Iterator<ASTree> children();
    public abstract String location();
    public Iterator<ASTree> iterator() { return chiildren(); }
}