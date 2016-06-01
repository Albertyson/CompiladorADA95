package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import java.util.ArrayList;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */
public class ElsIfList {
    
    private ArrayList<ElsIf> list;
    
    public ElsIfList() {
        list = new ArrayList();
    }
    
    public void add(ElsIf e) {
        list.add(0,e);
    }
    
    public int size() {
        return list.size();
    }
    
    public ElsIf getAt(int pos) {
        return list.get(pos);
    }

    
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }
    
    public Cuadruplo generate(IntermediateGenerable IG) {
        return IG.visit(this);
    }

    
}
