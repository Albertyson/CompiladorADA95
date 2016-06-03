package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;


public class IfWithElsIfAndElse extends If {
    public Expression expression;
    public Statements statements;
    public ElsIfList elsIfList;
    public Statements elseStatements;
    public int line, column;

    public IfWithElsIfAndElse(Expression expression, Statements statements, ElsIfList elsIfList, Statements elseStatements, int l, int c) {
        this.expression = expression;
        this.statements = statements;
        this.elsIfList = elsIfList;
        this.elseStatements = elseStatements;
        this.line = l;
        this.column = c;
    }
    
    @Override
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    @Override
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }
    @Override
    public String generate(IntermediateGenerable IG) {
        return IG.visit(this);
    }
}
