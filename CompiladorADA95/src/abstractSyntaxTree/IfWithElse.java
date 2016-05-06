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
public class IfWithElse extends If {
    
    public Expression exp;
    public Statements s1;
    public Statements s2;

    
    public IfWithElse() {}

    public IfWithElse(Expression exp, Statements s1, Statements s2) {
        this.exp = exp;
        this.s1 = s1;
        this.s2 = s2;
    }

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }

    public Statements getS1() {
        return s1;
    }

    public void setS1(Statements s1) {
        this.s1 = s1;
    }

    public Statements getS2() {
        return s2;
    }

    public void setS2(Statements s2) {
        this.s2 = s2;
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
