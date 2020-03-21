package data;

public enum TransactionsTypes {
    ALL_TYPES("All types"),
    CASH_IN("Cash in"),
    CASH_OUT("Cash out"),
    CASH_OUT_COMMISSION("Cash out commission"),
    TRANSFER("Transfer"),
    DAILY_PL("Daily P/L"),
    TRADE_COMMISSION("Trade commission"),
    COUPON("Coupon"),
    EXTERNAL_TRANSFER("External transfer"),
    EXTERNAL_TRANSFER_COMMISSION("External transfer commission"),
    SETTLEMENT("Settlement"),
    SERVICE_FEE("Service fee");

    private final String name;

    private TransactionsTypes(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

}
