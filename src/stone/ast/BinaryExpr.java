package stone.ast;

import stone.Token;

public class BinaryExpr extends ASTLeaf {
    public BinaryExpr(List<ASTree> c ) { super(c); }
    public ASTree left() { return child(0); }
    public String operator() {
        return ((ASTLeaf)child(1)).token().getText();
    }
    public ASTree right() { return child(2); }
}