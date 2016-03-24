package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author JosuéNoel
 */

@XmlSeeAlso({CaseNotOthers.class,CaseOthers.class})
@XmlType
public abstract class Case extends Statement {
    
    @Override
    public abstract void callPath(ParentPath PP);
    
}
