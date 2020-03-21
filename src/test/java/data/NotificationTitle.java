package data;

public enum NotificationTitle {
    ORDER_REQUEST("Order request"),
    ORDER_EXECUTED("Order executed"),
    ORDER_REJECTED("Order rejected");

    private final String name;
    private NotificationTitle(String s) {
        name = s;
    }
    public String getName() {
        return name;
    }


}
