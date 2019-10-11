package saxinitialization;

import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.IOException;
import java.util.Set;

public class tariffBuilder {

    private Set<Tariff> tariffs;
    private tariffHandler sh;
    private XMLReader reader;

    public tariffBuilder() {
        // создание SAX-анализатора
        sh = new tariffHandler();
        try {
            // создание объекта-обработчика
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(sh);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        }
    }

    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    public void buildSetStudents(String fileName) {
        try {
            // разбор XML-документа
            reader.parse(fileName);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }
        tariffs = sh.getTariffs();
    }
}
