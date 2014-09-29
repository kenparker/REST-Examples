
package com.maggioni.Demo;

import com.maggioni.Entities.Stock;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * http://blog.bdoughan.com/2012/08/jaxbs-xmltransient-and-property-order.html
 */
public class Demo
{
    
    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Stock.class);
 
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("input.xml");
        Stock stock = (Stock) unmarshaller.unmarshal(xml);
 
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(stock, System.out);
    }
}
