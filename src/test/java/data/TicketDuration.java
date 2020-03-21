package data;

public enum TicketDuration {
    FILL_OR_KILL("Fill or kill"),
    LIMIT("Limit");

    private final String name;
    private TicketDuration(String s) {
        name = s;
    }

}
