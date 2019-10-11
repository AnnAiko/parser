package saxinitialization;
//Перечисление
public enum TariffEnum {
    TARIFFS("tariffs"),
    ID("id"),
    OPERATOR("operator"),
    TARIFF("tariff"),
    NAME("name"),
    PAYROLL("payroll"),
    INSIDE("inside"),
    OUTSIDE("outside"),
    STATIONARYPHONE("stationaryphone"),
    SMSPRICE("SMSprice"),
    LIKEPHONE("likephone"),
    TARIFFING("tariffing"),
    CONNECTION("connection"),
    CALLPRICES("callprices"),
    PARAMETERS("parameters"),;
    private String value;

    private TariffEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
