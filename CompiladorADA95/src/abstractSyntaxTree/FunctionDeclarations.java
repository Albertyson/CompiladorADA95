
package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;

/**
 *
 * @author JosuéNoel
 */
public class FunctionDeclarations extends DeclarationPart {
    
    private ArrayList<FunctionDeclaration> declarations;
    
    public FunctionDeclarations() {
        this.declarations = new ArrayList();
    }
    
    public int size() {
        return declarations.size();
    }
    
    public void add(FunctionDeclaration p) {
        declarations.add(p);
    }
    
    public FunctionDeclaration getAt(int pos) {
        return declarations.get(pos);
    }

    public ArrayList<FunctionDeclaration> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(ArrayList<FunctionDeclaration> declarations) {
        this.declarations = declarations;
    }
    
    

    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
