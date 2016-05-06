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
public class CaseNotOthers extends Case {
    
    public Expression exp;
    public WhenList whenList;
    
    public CaseNotOthers() {}
    
    public CaseNotOthers(Expression exp, WhenList wl) {
        this.exp = exp;
        this.whenList = wl;
    }

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }

    public WhenList getWhenList() {
        return whenList;
    }

    public void setWhenList(WhenList whenList) {
        this.whenList = whenList;
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
