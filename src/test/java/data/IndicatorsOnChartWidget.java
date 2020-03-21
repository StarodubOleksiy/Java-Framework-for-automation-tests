package data;

public enum IndicatorsOnChartWidget {
    EMA("EMA"),
    SMA("SMA"),
    WMA("WMA"),
    TMA("TMA"),
    BollingerBand("Bollinger band");

    private final String name;

    private IndicatorsOnChartWidget(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
