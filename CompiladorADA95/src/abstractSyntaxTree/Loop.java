package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Loop extends Statement {
    
    public Statements s;

    
    public Loop() {}

    public Loop(Statements s) {
        this.s = s;
    }

    public Statements getS() {
        return s;
    }

    public void setS(Statements s) {
        this.s = s;
    }

    @Override
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    @Override
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
