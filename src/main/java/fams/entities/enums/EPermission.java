package fams.entities.enums;

public enum EPermission {
    ACCESS_DENIED("ACCESS_DENIED"),VIEW("VIEW"),MODIFY("MODIFY"),CREATE("CREATE"),FULL_ACCESS("FULL_ACCESS");
    private final String text;

    EPermission(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
