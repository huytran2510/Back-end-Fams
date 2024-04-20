package fams.entities.enums;

public enum SyllabusStatus {
    ACTIVE("ACTIVE"),DRAF("DRAF"),INACTIVE("INACTIVE");
    private final String text;
    private SyllabusStatus(final String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
