package domparser;

public class DomParser {

    public static void main(String[] args) {
        tariffDOMBuilder domBuilder = new tariffDOMBuilder();
        domBuilder.buildSetTariffs("tariffDocument.xml");
        System.out.println(domBuilder.getTariffs());
    }
}
