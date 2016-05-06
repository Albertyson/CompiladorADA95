package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import visitor.TypeVisitor;

/**
 *
 * @author Albertyson
 */
@XmlAccessorType(XmlAccessType.FIELD)
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

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
    }
    
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }


}
