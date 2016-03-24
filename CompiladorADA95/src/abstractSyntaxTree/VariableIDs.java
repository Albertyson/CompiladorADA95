package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author JosuéNoel
 */

@XmlAccessorType(XmlAccessType.FIELD)
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
    
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
