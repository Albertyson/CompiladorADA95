package abstractSyntaxTree;

import AST_Path.ParentPath;

/**
 *
 * @author JosuéNoel
 */


public class CaseOthers extends Case {
    
    public Expression exp;
    public WhenOptions whenOptions;
    public Statements statementsOptions;
    public Statements statementsOthers;

    public CaseOthers(Expression exp, WhenOptions whenOptions, Statements statementsOptions,Statements statementsOthers) {
        this.exp = exp;
        this.whenOptions = whenOptions;
        this.statementsOptions = statementsOptions;
        this.statementsOthers = statementsOthers;
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

    public Statements getStatementsOptions() {
        return statementsOptions;
    }

    public void setStatementsOptions(Statements statementsOptions) {
        this.statementsOptions = statementsOptions;
    }

    public Statements getStatementsOthers() {
        return statementsOthers;
    }

    public void setStatementsOthers(Statements statementsOthers) {
        this.statementsOthers = statementsOthers;
    }
 
    
    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
