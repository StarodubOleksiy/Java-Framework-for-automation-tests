package data;

public enum Status {
    ALL("All"),
    FILLED("Filled"),
    CANCELED("Canceled"),
    REPLACED("Replaced"),
    REJECTED("Rejected"),
    EXPIRED("Expired");


    private final String name;

    private Status(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
