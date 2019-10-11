package saxinitialization;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
// задание последовательности элементов XML
@XmlType(name = "Student", propOrder = {
    "name",
    "payroll",
    "callprices",
    "SMSprice",
    "parameters"})
public class Tariff {

    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private String id;
    @XmlElement(required = true)
    private String name;
    @XmlAttribute(required = false)
    private String operator;
    @XmlElement(required = true)
    private String payroll;
    @XmlElement(required = true)
    private Callprices callprices = new Callprices();
    @XmlElement(required = true)
    private String SMSprice;
    @XmlElement(required = true)
    private Parameters parameters = new Parameters();

    // необходим для маршаллизации/демаршалиизации XML
    public Tariff() {
    }

    public Tariff(String id, String operator, String name, String payroll, int telephone, Callprices callprices, String SMSprice, Parameters parameters) {
        this.id = id;
        this.name = name;
        this.operator = operator;
        this.payroll = payroll;
        this.callprices = callprices;
        this.SMSprice = SMSprice;
        this.parameters = parameters;
    }

    public Callprices getCallprices() {
        return callprices;
    }

    public void setCallprices(Callprices callprices) {
        this.callprices = callprices;
    }

    public String getSMSprice() {
        return SMSprice;
    }

    public void setSMSprice(String SMSprice) {
        this.SMSprice = SMSprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayroll() {
        return payroll;
    }

    public void setPayroll(String payroll) {
        this.payroll = payroll;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "callprices = " + callprices + ", SMSprice = " + SMSprice + ", name = " + name + ", id = " + id + ", payroll = " + payroll + ", parameters = " + parameters + ", operator = " + operator;
    }

    //Внутрений класс
    @XmlAccessorType(XmlAccessType.FIELD)
    // задание последовательности элементов XML
    @XmlType(name = "Callprices", propOrder = {
        "inside",
        "outside",
        "stationaryphone"
    })
    public class Callprices {

        //@XmlElement(required = true)
        private String stationaryphone;
        //@XmlElement(required = true)
        private String outside;
        //@XmlElement(required = true)
        private String inside;

        // необходим для маршаллизации/демаршалиизации XML
        public Callprices() {
        }

        public Callprices(String inside, String outside, String stationaryphone) {
            this.inside = inside;
            this.outside = outside;
            this.stationaryphone = stationaryphone;
        }

        public String getStationaryphone() {
            return stationaryphone;
        }

        public void setStationaryphone(String stationaryphone) {
            this.stationaryphone = stationaryphone;
        }

        public String getOutside() {
            return outside;
        }

        public void setOutside(String outside) {
            this.outside = outside;
        }

        public String getInside() {
            return inside;
        }

        public void setInside(String inside) {
            this.inside = inside;
        }

        @Override
        public String toString() {
            return "stationaryphone = " + stationaryphone + ", outside = " + outside + ", inside = " + inside;
        }
    }

    //Внутрений класс
    @XmlAccessorType(XmlAccessType.FIELD)
    // задание последовательности элементов XML
    @XmlType(name = "Parameters", propOrder = {
        "likephone",
        "tariffing",
        "connection"
    })
    public class Parameters {

        private String tariffing;

        private String connection;

        private String likephone;

        // необходим для маршаллизации/демаршалиизации XML
        public Parameters() {
        }

        public Parameters(String likephone, String tariffing, String connection) {
            this.likephone = likephone;
            this.tariffing = tariffing;
            this.connection = connection;
        }

        public String getTariffing() {
            return tariffing;
        }

        public void setTariffing(String tariffing) {
            this.tariffing = tariffing;
        }

        public String getConnection() {
            return connection;
        }

        public void setConnection(String connection) {
            this.connection = connection;
        }

        public String getLikephone() {
            return likephone;
        }

        public void setLikephone(String likephone) {
            this.likephone = likephone;
        }

        @Override
        public String toString() {
            return "tariffing = " + tariffing + ", connection = " + connection + ", likephone = " + likephone;
        }
    }
}
