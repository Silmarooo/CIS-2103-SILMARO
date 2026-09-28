package version5;

import java.util.Objects;

public class Name implements Cloneable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this.firstName = "N/A";
        this.middleName = "N/A";
        this.lastName = "N/A";
        this.suffix = "";
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName != null ? firstName : "N/A";
        this.middleName = "";
        this.lastName = lastName != null ? lastName : "N/A";
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName != null ? firstName : "N/A";
        this.middleName = middleName != null ? middleName : "";
        this.lastName = lastName != null ? lastName : "N/A";
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName != null ? firstName : "N/A";
        this.middleName = middleName != null ? middleName : "";
        this.lastName = lastName != null ? lastName : "N/A";
        this.suffix = suffix != null ? suffix : "";
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName != null ? firstName : "N/A"; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName != null ? middleName : ""; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName != null ? lastName : "N/A"; }

    public String getSuffix() { return suffix; }
    public void setSuffix(String suffix) { this.suffix = suffix != null ? suffix : ""; }

    public void displayName() {
        String mi = (middleName == null || middleName.trim().isEmpty() || middleName.equals("N/A")) 
                    ? "" : " " + middleName.trim().toUpperCase().charAt(0) + ".";
        System.out.printf("%s, %s%s%n", lastName, firstName, mi);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Name other = (Name) obj;
        return Objects.equals(firstName, other.firstName) &&
               Objects.equals(middleName, other.middleName) &&
               Objects.equals(lastName, other.lastName) &&
               Objects.equals(suffix, other.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, suffix);
    }

    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        String mi = (middleName == null || middleName.trim().isEmpty() || middleName.equals("N/A")) 
                    ? "" : " " + middleName.trim().toUpperCase().charAt(0) + ".";
        String suff = (suffix == null || suffix.trim().isEmpty()) ? "" : " " + suffix.trim();
        return String.format("%s, %s%s%s", lastName, firstName, mi, suff);
    }
}
