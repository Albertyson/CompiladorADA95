package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;


public class Statements {
    
    private ArrayList<Statement> statements;
    
    public Statements() {
        statements = new ArrayList();
    }
    
    public void add(Statement s) {
        statements.add(s);
    }
    
    public int size() {
        return statements.size();
    }
    
    public Statement getAt(int pos) {
        return statements.get(pos);
    }

    public ArrayList<Statement> getStatements() {
        return statements;
    }

    public void setStatements(ArrayList<Statement> statements) {
        this.statements = statements;
    }
    
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
