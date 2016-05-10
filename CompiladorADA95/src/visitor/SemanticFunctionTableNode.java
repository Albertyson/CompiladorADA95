package visitor;

import abstractSyntaxTree.VariableType;
import java.util.Vector;


public class SemanticFunctionTableNode extends SemanticTableNode {
    
    
    private VariableType returnType;
    private Vector<VariableType> params;

    public SemanticFunctionTableNode(VariableType returnType, Vector<VariableType> params, String name, String scope) {
        super(name, scope);
        this.returnType = returnType;
        this.params = params;
    }

    public Vector<VariableType> getParams() {
        return params;
    }

    public VariableType getReturnType() {
        return returnType;
    }
    
    
}
