package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import java.util.ArrayList;
import visitor.TypeVisitor;


public class WhenOptions {
    
    private ArrayList<WhenOption> options;
    
    public WhenOptions() {
        options = new ArrayList();
    }
    
    public void add(WhenOption e) {
        options.add(0,e);
    }
    
    public int size() {
        return options.size();
    }
    
    public WhenOption getAt(int pos) {
        return options.get(pos);
    }

    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }
    
    public String generate(IntermediateGenerable IG) {
        return IG.visit(this);
    }

    
}
