package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;

/**
 *
 * @author JosuéNoel
 */
public class VariableDeclarations extends DeclarationPart {
    
    private ArrayList<VariableDeclaration> declarations;
    
    public VariableDeclarations() {
        this.declarations = new ArrayList();
    }
    
    public int size() {
        return declarations.size();
    }
    
    public void add(VariableDeclaration p) {
        declarations.add(p);
    }
    
    public VariableDeclaration getAt(int pos) {
        return declarations.get(pos);
    }

    public ArrayList<VariableDeclaration> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(ArrayList<VariableDeclaration> declarations) {
        this.declarations = declarations;
    }
    
    

    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
