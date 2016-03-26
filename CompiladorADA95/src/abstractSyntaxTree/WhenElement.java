/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Albertyson
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WhenElement {
    private WhenOptions whenOptions;
    private Statements statements;

    public WhenElement() {
    }

    public WhenElement(WhenOptions whenOptions, Statements statements) {
        this.whenOptions = whenOptions;
        this.statements = statements;
    }
    // Caso que usa OTHERS
    public WhenElement(Statements statements) {
        this.statements = statements;
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
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
}
