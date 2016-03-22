package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;


public class VariableIDs {
   
    private ArrayList<Identifier> ids;
    
    public VariableIDs() {
        ids = new ArrayList();
    }
    
    public void add(Identifier e) {
        ids.add(e);
    }
    
    public int size() {
        return ids.size();
    }
    
    public Identifier getAt(int pos) {
        return ids.get(pos);
    }
    
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
