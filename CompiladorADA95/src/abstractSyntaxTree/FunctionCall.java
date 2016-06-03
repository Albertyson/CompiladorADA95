package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;


public class FunctionCall extends Expression {
    
    public Identifier id;
    public FunctionParameters fp;
    public int line, column;
    

    public FunctionCall(Identifier id, FunctionParameters fp, int l, int c) {
        this.id = id;
        this.fp = fp;
        this.line = l;
        this.column = c;
    }
    
    public FunctionCall(Identifier id, int l, int c) {
        this.id = id;
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
