package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author JosuéNoel
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class While extends Statement {
    
    public Expression exp;
    public Statements est;

    public While() {
    }

    public While(Expression exp, Statements est) {
        this.exp = exp;
        this.est = est;
    }

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }

    public Statements getEst() {
        return est;
    }

    public void setEst(Statements est) {
        this.est = est;
    }
    
    
    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
