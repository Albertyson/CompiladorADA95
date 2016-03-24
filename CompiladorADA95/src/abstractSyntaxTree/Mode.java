package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author JosuéNoel
 */
@XmlSeeAlso({ModeIn.class,ModeOut.class,ModeInOut.class})
@XmlType
public abstract class Mode {
    
    public abstract void callPath(ParentPath PP);
    
}
