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

    public ArrayList<WhenOption> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<WhenOption> options) {
        this.options = options;
    }
    
    
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
