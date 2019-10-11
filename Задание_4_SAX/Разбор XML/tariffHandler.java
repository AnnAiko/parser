package saxparser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
//Чтение и вывод XML-документа

public class tariffHandler extends DefaultHandler {
    //Начало документа
    @Override
    public void startDocument() {
        System.out.println("Parsing started");
    }
    //Открыть элемент
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        String s = localName;
        //Получить и вывести информацию об атрибутах элемента
        for (int i = 0; i < attrs.getLength(); i++) {
            s += " " + attrs.getLocalName(i) + "=" + attrs.getValue(i);
        }
        System.out.print(s.trim());
    }
    //Получить информацию внутри элементов
    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.print(new String(ch, start, length));
    }
    //Закрыть элемент
    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.print(localName);
    }
    //Конец документа
    @Override
    public void endDocument() {
        System.out.println("\nParsing ended");
    }
}
