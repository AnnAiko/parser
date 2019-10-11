package saxinitialization;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class tariffHandler extends DefaultHandler {

    private Set<Tariff> tariffs;
    private Tariff current = null;
    private TariffEnum currentEnum = null;
    private EnumSet<TariffEnum> withText;

    public tariffHandler() {
        tariffs = new HashSet<Tariff>();
        withText = EnumSet.range(TariffEnum.NAME, TariffEnum.CONNECTION);
    }

    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    //Получить элемент
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("tariff".equals(localName)) {
            current = new Tariff();
            current.setId(attrs.getValue(0));
            if (attrs.getLength() == 2) {
                current.setOperator(attrs.getValue(1));
            }
        } else {
            TariffEnum temp = TariffEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    //Закрыть элемент
    public void endElement(String uri, String localName, String qName) {
        if ("tariff".equals(localName)) {
            tariffs.add(current);
        }
    }

    //Получить информацию внутри элементов
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    current.setName(s);
                    break;
                case PAYROLL:
                    current.setPayroll(s);
                    break;
                case INSIDE:
                    current.getCallprices().setInside(s);
                    break;
                case OUTSIDE:
                    current.getCallprices().setOutside(s);
                    break;
                case STATIONARYPHONE:
                    current.getCallprices().setStationaryphone(s);
                    break;
                case SMSPRICE:
                    current.setSMSprice(s);
                    break;
                case LIKEPHONE:
                    current.getParameters().setTariffing(s);
                    break;
                case TARIFFING:
                    current.getParameters().setLikephone(s);
                    break;
                case CONNECTION:
                    current.getParameters().setConnection(s);
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
