package kenny.algorithm.xml_vs_schema.schema_validate_demo;

import kenny.algorithm.xml_vs_schema.xml_obj_convert_demo.ObjXmlConvert;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;


public class Test {

    public static void main(String[] args) throws Exception {

        // 1.用XSD校验对象
        Customer customer = new Customer();
        customer.setName("kenny");

        customer.getPhoneNumbers().add(new PhoneNumber());
        customer.getPhoneNumbers().add(new PhoneNumber());
        customer.getPhoneNumbers().add(new PhoneNumber());

        JAXBContext jc = JAXBContext.newInstance(Customer.class);
        JAXBSource source = new JAXBSource(jc, customer);

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("./src/main/java/kenny/algorithm/xml_vs_schema/schema_validate_demo/customer.xsd"));

        Validator validator = schema.newValidator();

        validator.setErrorHandler(new MyErrorHandler());

        validator.validate(source);

        // 2.用XSD校验XML
        String customerXml = ObjXmlConvert.convertToXml(customer);
        System.out.println(customerXml);
        // 这里待添加XML校验的步骤
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

    }
}
