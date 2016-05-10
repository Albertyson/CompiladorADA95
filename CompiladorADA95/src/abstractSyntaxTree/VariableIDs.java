package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */
public class VariableIDs {
   
    private ArrayList<Identifier> ids;
    
    public VariableIDs() {
        ids = new ArrayList();
    }
    
    public void add(Identifier e) {
        ids.add(0,e);
    }
    
    public int size() {
        return ids.size();
    }
    
    public Identifier getAt(int pos) {
        return ids.get(pos);
    }
    
    
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
