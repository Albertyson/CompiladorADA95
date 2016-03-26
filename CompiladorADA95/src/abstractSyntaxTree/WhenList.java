/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Albertyson
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WhenList {
    private ArrayList <WhenElement> whenElements;

    public WhenList() {
        whenElements = new ArrayList();
    }
    public void add(WhenElement w){
        whenElements.add(0,w);
    }
    public WhenElement getAt(int pos){
        return whenElements.get(pos);
    }
    public int size(){
        return whenElements.size();
    }

    public ArrayList<WhenElement> getWhenElements() {
        return whenElements;
    }

    public void setWhenElements(ArrayList<WhenElement> whenElements) {
        this.whenElements = whenElements;
    }
    
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
}
