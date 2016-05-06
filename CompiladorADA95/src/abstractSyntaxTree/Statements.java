package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

@XmlAccessorType(XmlAccessType.FIELD)
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

    public ArrayList<Statement> getStatements() {
        return statements;
    }

    public void setStatements(ArrayList<Statement> statements) {
        this.statements = statements;
    }
    
    
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
