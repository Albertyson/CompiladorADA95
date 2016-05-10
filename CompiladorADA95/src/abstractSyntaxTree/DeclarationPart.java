package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;
import visitor.TypeVisitor;

/**
 *
 * @author Albertyson
 */
public class DeclarationPart {
    
    private ArrayList<Declaration> declaration;
    
    public DeclarationPart() {
        declaration = new ArrayList();
    }
    
    public void add(Declaration e) {
        declaration.add(0,e);
    }
    
    public int size() {
        return declaration.size();
    } 
    
    public Declaration getAt(int pos) {
        return declaration.get(pos);
    }
    
    
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
