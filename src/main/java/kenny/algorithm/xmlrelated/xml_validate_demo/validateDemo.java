package kenny.algorithm.xmlrelated.xml_validate_demo;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;


public class validateDemo {

    public static void main(String[] args) throws Exception {
        Customer customer = new Customer();
        customer.setName("Jane Doe");
//        customer.setName("kenny");
        customer.getPhoneNumbers().add(new PhoneNumber());
        customer.getPhoneNumbers().add(new PhoneNumber());
        customer.getPhoneNumbers().add(new PhoneNumber());

        JAXBContext jc = JAXBContext.newInstance(Customer.class);
        JAXBSource source = new JAXBSource(jc, customer);

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("./src/main/java/kenny/lang/xmlrelated/xml_validate_demo/customer.xsd"));

        Validator validator = schema.newValidator();

        validator.setErrorHandler(new MyErrorHandler());

        validator.validate(source);
    }
}
