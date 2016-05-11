package visitor;

import java.util.Objects;


public abstract class SemanticTableNode {
    
    protected String name;
    protected String scope;

    public SemanticTableNode(String name, String scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getScope() {
        return scope;
    }

    public String getName() {
        return name;
    }
    
}
