package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import java.util.ArrayList;
import visitor.TypeVisitor;


public class Statements {
    
    private ArrayList<Statement> statements;
    
    public Statements() {
        statements = new ArrayList();
    }
    
    public void add(Statement s) {
        statements.add(0,s);
    }
    
    public int size() {
        return statements.size();
    }
    
    public Statement getAt(int pos) {
        return statements.get(pos);
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
