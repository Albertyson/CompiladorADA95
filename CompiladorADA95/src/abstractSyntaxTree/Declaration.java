package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author JosuéNoel
 */
@XmlSeeAlso({VariableDeclaration.class,FunctionDeclaration.class,ProcedureDeclaration.class})
@XmlType
public abstract class Declaration {
    
    public abstract void callPath(ParentPath PP);
    
}
