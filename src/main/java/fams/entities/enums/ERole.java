package fams.entities.enums;
public enum ERole {
  SUPER_ADMIN("SUPER_ADMIN"), CLASS_ADMIN("CLASS_ADMIN"), TRAINER("TRAINER");
  private final String text;

  private ERole(final String text) {
    this.text = text;
  }
  @Override
  public String toString() {
    return text;
  }
}
