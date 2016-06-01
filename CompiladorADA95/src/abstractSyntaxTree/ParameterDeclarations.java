package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import java.util.ArrayList;
import visitor.TypeVisitor;


public class ParameterDeclarations {

    private ArrayList<Parameter> parameters;

    public ParameterDeclarations() {
        this.parameters = new ArrayList();
    }

    public int size() {
        return parameters.size();
    }

    public void add(Parameter p) {
        parameters.add(0,p);
    }

    public Parameter getAt(int pos) {
        return parameters.get(pos);
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
