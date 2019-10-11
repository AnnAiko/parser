package domparser;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class tariffDOMBuilder {

    private Set<Tariff> tariffs;
    private DocumentBuilder docBuilder;

    public tariffDOMBuilder() {
        this.tariffs = new HashSet<Tariff>();
        // создание DOM-анализатора
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    public void buildSetTariffs(String fileName) {
        Document doc = null;
        try {
// parsing XML-документа и создание древовидной структуры
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
// получение списка дочерних элементов <student>
            NodeList tariffList = root.getElementsByTagName("tariff");
            for (int i = 0; i < tariffList.getLength(); i++) {
                Element tariffElement = (Element) tariffList.item(i);
                Tariff tariff = buildTariff(tariffElement);
                tariffs.add(tariff);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }

    private Tariff buildTariff(Element tariffElement) {
        Tariff tariff = new Tariff();
        // заполнение объекта tariff
        tariff.setOperator(tariffElement.getAttribute("operator"));

        tariff.setName(getElementTextContent(tariffElement, "name"));
        tariff.setPayroll(getElementTextContent(tariffElement, "payroll"));

        Tariff.Callprices callprices = tariff.getCallprices();
        // заполнение объекта callprices
        Element callElement = (Element) tariffElement.getElementsByTagName("callprices").item(0);

        callprices.setInside(getElementTextContent(callElement, "inside"));
        callprices.setOutside(getElementTextContent(callElement, "outside"));
        callprices.setStationaryphone(getElementTextContent(callElement, "stationaryphone"));

        tariff.setSMSprice(getElementTextContent(tariffElement, "SMSprice"));

        Tariff.Parameters parameters = tariff.getParameters();
        // заполнение объекта parameters
        Element parametersElement = (Element) tariffElement.getElementsByTagName("parameters").item(0);
        parameters.setTariffing(getElementTextContent(parametersElement, "tariffing"));
        parameters.setLikephone(getElementTextContent(parametersElement, "likephone"));
        parameters.setConnection(getElementTextContent(parametersElement, "connection"));

        tariff.setId(tariffElement.getAttribute("id"));
        return tariff;
    }
    // получение текстового содержимого тега

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        //System.out.println(element + " " + elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();

        return text;
    }

}
