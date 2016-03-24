package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Albertyson
 */
@XmlAccessorType(XmlAccessType.FIELD)
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
