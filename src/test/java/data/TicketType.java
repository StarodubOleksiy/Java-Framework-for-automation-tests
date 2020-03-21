package data;

public enum TicketType {
    MARKET("Market"),
    LIMIT("Limit"),
    STOP("Stop"),
    STOP_LIMIT("Stop-Limit");

    private final String name;
    private TicketType(String s) {
        name = s;
    }

}
