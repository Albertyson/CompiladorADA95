package visitor;

import abstractSyntaxTree.VariableType;


public class SemanticVariableTableNode extends SemanticTableNode{
    
    public static final int IN = 1;
    public static final int OUT = 2;
    public static final int INOUT = 3;
    public static final int NO_PARAM = 4;
    
    private VariableType type;
    private int direction = 0;
    private int varType;

    public SemanticVariableTableNode(VariableType type, String name, String scope, int varType, int direction) {
        super(name, scope);
        this.type = type;
        this.varType = varType;
        this.direction = direction;
    }

    public boolean isParameter() {
        return this.varType != NO_PARAM;
    }

    public int getVarType() {
        return varType;
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
