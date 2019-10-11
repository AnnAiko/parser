package saxparser;

import java.io.IOException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXException;

public class SaxParser {

    public static void main(String[] args) {
        try {
            // Создать фабрику
            XMLReader reader = XMLReaderFactory.createXMLReader();
            tariffHandler handler = new tariffHandler();
            reader.setContentHandler(handler);
            reader.parse("tariffDocument.xml");
        } catch (SAXException e) {
            System.err.print("Ошибка SAX парсера " + e);
        } catch (IOException e) {
            System.err.print("Ошибка I/О потока " + e);
        }
    }

}
