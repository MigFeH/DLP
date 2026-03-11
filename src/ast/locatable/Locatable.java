package ast.locatable;

import ast.ASTNode;

public interface Locatable extends ASTNode {
    int getLinea();
    int getColumna();
}
