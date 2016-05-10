package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;
import visitor.TypeVisitor;

/**
 *
 * @author Albertyson
 */
public class WhenList {
    private ArrayList <WhenElement> whenElements;

    public WhenList() {
        whenElements = new ArrayList();
    }
    
    public void add(WhenElement w){
        whenElements.add(0,w);
    }
    
    public WhenElement getAt(int pos){
        return whenElements.get(pos);
    }
    
    public int size(){
        return whenElements.size();
    }
    
    
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
