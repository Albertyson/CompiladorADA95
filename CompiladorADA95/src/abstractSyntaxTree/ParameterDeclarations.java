package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;
import visitor.TypeVisitor;

/**
 *
 * @author Albertyson
 */
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


}
