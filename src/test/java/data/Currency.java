package data;

public enum Currency {
    USD("USD"),
    EUR("EUR"),
    RUB("RUB"),
    GBP("GBP");
   private final String name;

    private Currency(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public static Currency getCurrency(String currency) {
        switch (currency) {
            case "USD":
                return USD;
            case "EUR":
                return EUR;
            case "RUB":
                return RUB;
            default:
                return GBP;
        }
    }

    public String toString() {
        return this.name;
    }
}
