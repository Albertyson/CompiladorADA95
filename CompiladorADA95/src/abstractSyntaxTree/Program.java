package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;


public class Program {
    public Identifier id1;
    public DeclarationPart declarations;
    public Statements statements;
    public Identifier id2;
    public int line, column;

    
    public Program(Identifier id1, DeclarationPart declarations, Statements statements, Identifier id2, int l, int c) {
        this.id1 = id1;
        this.declarations = declarations;
        this.statements = statements;
        this.id2 = id2;
        this.line = l;
        this.column = c;
    }
    
    public Program(Identifier id1, Identifier id2, int l, int c) {
        this.id1 = id1;
        this.id2 = id2;
        this.line = l;
        this.column = c;
    }
    
    public Program(Identifier id1, DeclarationPart declarations, Identifier id2, int l, int c) {
        this.id1 = id1;
        this.declarations = declarations;
        this.id2 = id2;
        this.line = l;
        this.column = c;
    }

    public Program(Identifier id1, Statements statements, Identifier id2, int l, int c) {
        this.id1 = id1;
        this.statements = statements;
        this.id2 = id2;
        this.line = l;
        this.column = c;
    }
    
    
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }
    
    public Cuadruplo generate(IntermediateGenerable IG) {
        return IG.visit(this);
    }

    
}
