package fams.entities.enums;

public enum Status {
    ACTIVE("ACTIVE"),DE_ACTIVE("DE_ACTIVE");
    private final String text;
    private Status(final String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
