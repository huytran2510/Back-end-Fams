package fams.entities.enums;

public enum SyllabusPublishStatus {
    ACTIVE("ACTIVE"),DE_ACTIVE("DE_ACTIVE");
    private final String text;
    private SyllabusPublishStatus(final String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
