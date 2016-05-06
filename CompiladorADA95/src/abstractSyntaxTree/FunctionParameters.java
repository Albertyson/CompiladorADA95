package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class FunctionParameters {
    
    private ArrayList<Expression> exps;
    
    public FunctionParameters() {
        exps = new ArrayList();
    }
    
    public void add(Expression e) {
        exps.add(0,e);
    }
    
    public int size() {
        return exps.size();
    } 
    
    public Expression getAt(int pos) {
        return exps.get(pos);
    }
    
    public ArrayList<Expression> getExps() {
        return exps;
    }

    public void setExps(ArrayList<Expression> exps) {
        this.exps = exps;
    }
    
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
