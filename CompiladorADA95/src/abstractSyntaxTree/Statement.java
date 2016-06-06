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
public abstract class Statement {
    
    public ArrayList<Integer> listaSiguiente = new ArrayList();
    
    public abstract void accept(ParentPath PP);
    
    public abstract VariableType accept(TypeVisitor PP);
    
    public abstract String generate(IntermediateGenerable IG);
    
}
