package data;

public class AccountVariables {
    private String totalAssets;
    private String unrealizedPL;
    private String closedPL;
    private String marginAvailable;
    private String margin;

    public AccountVariables(String firstTotalAssets, String firstUnrealizedPL, String firstClosedPL, String firstMarginAvailable, String firstMargin) {
        this.totalAssets = firstTotalAssets;
        this.unrealizedPL = firstUnrealizedPL;
        this.closedPL = firstClosedPL;
        this.marginAvailable = firstMarginAvailable;
        this.margin = firstMargin;
    }

    public String getTotalAssets() {
        return totalAssets;
    }

    public String getUnrealizedPL() {
        return unrealizedPL;
    }

    public String getClosedPL() {
        return closedPL;
    }

    public String getMarginAvailable() {
        return marginAvailable;
    }

    public String getMargin() {
        return margin;
    }

    @Override
    public String toString() {
        return "AccountVariables{" +
                "totalAssets='" + totalAssets + '\'' +
                ", unrealizedPL='" + unrealizedPL + '\'' +
                ", closedPL='" + closedPL + '\'' +
                ", marginAvailable='" + marginAvailable + '\'' +
                ", margin='" + margin + '\'' +
                '}';
    }
}
