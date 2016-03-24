package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author JosuéNoel
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class CaseNotOthers extends Case {
    
    public Expression exp;
    public WhenOptions whenOptions;
    public Statements statements;

    public CaseNotOthers() {
    }
    
    public CaseNotOthers(Expression exp, WhenOptions whenOptions, Statements statements) {
        this.exp = exp;
        this.whenOptions = whenOptions;
        this.statements = statements;
    }

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }

    public WhenOptions getWhenOptions() {
        return whenOptions;
    }

    public void setWhenOptions(WhenOptions whenOptions) {
        this.whenOptions = whenOptions;
    }

    public Statements getStatements() {
        return statements;
    }

    public void setStatements(Statements statements) {
        this.statements = statements;
    }
    
    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
