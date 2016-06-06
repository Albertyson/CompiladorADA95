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

public abstract class Expression extends Statement {
    
    public ArrayList<Integer> listaVerdadero = new ArrayList();
    public ArrayList<Integer> listaFalso = new ArrayList();
    
    @Override
    public abstract void accept(ParentPath PP);
    
    @Override
    public abstract VariableType accept(TypeVisitor PP);
    
    @Override
    public abstract String generate(IntermediateGenerable IG);
    
}
