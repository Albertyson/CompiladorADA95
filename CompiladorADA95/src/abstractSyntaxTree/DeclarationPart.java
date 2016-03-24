package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;

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
        declaration.add(e);
    }
    
    public int size() {
        return declaration.size();
    } 
    
    public Declaration getAt(int pos) {
        return declaration.get(pos);
    }

    public ArrayList<Declaration> getDeclaration() {
        return declaration;
    }

    public void setDeclaration(ArrayList<Declaration> declaration) {
        this.declaration = declaration;
    }
    
    
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
