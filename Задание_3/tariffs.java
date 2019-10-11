package generclass;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class tariffs {

    @XmlElement(name = "tariff")
    private ArrayList<Tariff> list = new ArrayList<Tariff>();

    public tariffs() {
        super();
    }

    public void setList(ArrayList<Tariff> list) {
        this.list = list;
    }

    public boolean add(Tariff traf) {
        return list.add(traf);
    }

    @Override
    public String toString() {
        return "[list=" + list + "]";
    }
}
