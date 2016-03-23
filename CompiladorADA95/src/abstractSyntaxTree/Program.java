/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractSyntaxTree;

import AST_Path.ParentPath;

/**
 *
 * @author Albertyson
 */
public class Program {
    private Identifier id;
    private DeclarationPart declarations;
    private Statements statements;

    public Program(Identifier id, DeclarationPart declarations, Statements statements) {
        this.id = id;
        this.declarations = declarations;
        this.statements = statements;
    }
    public void callPath(ParentPath PP) {
        PP.path(this);
    }

    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }

    public DeclarationPart getDeclarations() {
        return declarations;
    }

    public void setDeclarations(DeclarationPart declarations) {
        this.declarations = declarations;
    }

    public Statements getStatements() {
        return statements;
    }

    public void setStatements(Statements statements) {
        this.statements = statements;
    }
    
}
