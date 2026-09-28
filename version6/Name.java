package version6;

import java.util.Objects;

public final class Name implements Cloneable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this.firstName = "N/A";
        this.middleName = "";
        this.lastName = "N/A";
        this.suffix = "";
    }

    public Name(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        this.middleName = "";
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        this.middleName = middleName != null ? middleName : "";
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        setFirstName(firstName);
        setLastName(lastName);
        this.middleName = middleName != null ? middleName : "";
        this.suffix = suffix != null ? suffix : "";
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        this.firstName = firstName.trim();
    }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName != null ? middleName.trim() : ""; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        this.lastName = lastName.trim();
    }

    public String getSuffix() { return suffix; }
    public void setSuffix(String suffix) { this.suffix = suffix != null ? suffix.trim() : ""; }

    public void displayName() {
        String mi = (middleName.isEmpty()) ? "" : " " + middleName.toUpperCase().charAt(0) + ".";
        System.out.printf("%s, %s%s%n", lastName, firstName, mi);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Name other = (Name) obj;
        return firstName.equalsIgnoreCase(other.firstName) &&
               middleName.equalsIgnoreCase(other.middleName) &&
               lastName.equalsIgnoreCase(other.lastName) &&
               suffix.equalsIgnoreCase(other.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), middleName.toLowerCase(), lastName.toLowerCase(), suffix.toLowerCase());
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
        String mi = (middleName.isEmpty()) ? "" : " " + middleName.toUpperCase().charAt(0) + ".";
        String suff = (suffix.isEmpty()) ? "" : " " + suffix;
        return String.format("%s, %s%s%s", lastName, firstName, mi, suff);
    }
}
