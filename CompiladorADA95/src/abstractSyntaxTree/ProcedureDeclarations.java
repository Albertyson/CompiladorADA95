package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;

/**
 *
 * @author JosuéNoel
 */
public class ProcedureDeclarations extends DeclarationPart{
    
    private ArrayList<ProcedureDeclaration> declarations;
    
    public ProcedureDeclarations() {
        this.declarations = new ArrayList();
    }
    
    public int size() {
        return declarations.size();
    }
    
    public void add(ProcedureDeclaration p) {
        declarations.add(p);
    }
    
    public ProcedureDeclaration getAt(int pos) {
        return declarations.get(pos);
    }

    public ArrayList<ProcedureDeclaration> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(ArrayList<ProcedureDeclaration> declarations) {
        this.declarations = declarations;
    }
    
    

    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
