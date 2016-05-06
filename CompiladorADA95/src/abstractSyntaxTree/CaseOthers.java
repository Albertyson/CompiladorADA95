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
public class CaseOthers extends Case {
    
    public Expression exp;
    public WhenList whenList;
    public Statements statementsOthers;
    
    public CaseOthers() {}
    
    public CaseOthers(Expression exp, WhenList whenList, Statements statementsOthers) {
        this.exp = exp;
        this.whenList = whenList;
        this.statementsOthers = statementsOthers;
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

    public Statements getStatementsOthers() {
        return statementsOthers;
    }

    public void setStatementsOthers(Statements statementsOthers) {
        this.statementsOthers = statementsOthers;
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
