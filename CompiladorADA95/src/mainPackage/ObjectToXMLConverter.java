/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Albertyson
 */
public class ObjectToXMLConverter {
    
    private File xmlFile;
    private Object objectToConvert;
    
    public ObjectToXMLConverter(File xmlFile, Object objectToConvert) {
        this.xmlFile = xmlFile;
        this.objectToConvert = objectToConvert;
    }
    
    public void toXML() {
        try {
            JAXBContext ctx = JAXBContext.newInstance(this.objectToConvert.getClass());
            Marshaller jaxbMarshaller = ctx.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(this.objectToConvert, this.xmlFile);
            //jaxbMarshaller.marshal(this.objectToConvert, System.out);
        } catch (Exception ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Object toObject() {
        try {
            Class objectClass = this.objectToConvert.getClass();
            JAXBContext jc = JAXBContext.newInstance(objectClass);
            Unmarshaller u = jc.createUnmarshaller();
            return u.unmarshal(this.xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
