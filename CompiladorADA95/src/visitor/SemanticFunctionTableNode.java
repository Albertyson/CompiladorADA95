package visitor;

import abstractSyntaxTree.VariableType;
import java.util.ArrayList;


public class SemanticFunctionTableNode extends SemanticTableNode {
    
    private VariableType returnType;
    private ArrayList<SemanticVariableTableNode> params;

    public SemanticFunctionTableNode(VariableType returnType, String name, String scope) {
        super(name, scope);
        this.returnType = returnType;
        this.params = new ArrayList();
    }

    public ArrayList<SemanticVariableTableNode> getParams() {
        return params;
    }

    public VariableType getReturnType() {
        return returnType;
    }
    
    public void addParam(SemanticVariableTableNode node) {
        this.params.add(0,node);
    }
    
}
