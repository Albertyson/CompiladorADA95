package visitor;

import abstractSyntaxTree.VariableType;


public class SemanticVariableTableNode extends SemanticTableNode{
    
    private VariableType type;
    private boolean parameter;
    private int direction;

    public SemanticVariableTableNode(VariableType type, String name, String scope, boolean parameter, int direction) {
        super(name, scope);
        this.type = type;
        this.parameter = parameter;
        this.direction = direction;
    }

    public boolean isParameter() {
        return parameter;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return this.direction;
    }

    public VariableType getType() {
        return type;
    }
    
    
}
