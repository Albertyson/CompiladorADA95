package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;

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
        parameters.add(p);
    }

    public Parameter getAt(int pos) {
        return parameters.get(pos);
    }

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
    }
    
    public void callPath(ParentPath PP) {
        PP.path(this);
    }

}
