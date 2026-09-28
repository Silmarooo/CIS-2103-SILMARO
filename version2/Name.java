package version2;

public class Name {
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

    private String getFormattedName() {
        String mi = (middleName == null || middleName.trim().isEmpty() || middleName.equals("N/A")) 
                    ? "" : " " + middleName.trim().toUpperCase().charAt(0) + ".";
        String suff = (suffix == null || suffix.trim().isEmpty()) ? "" : " " + suffix.trim();
        return String.format("%s, %s%s%s", lastName, firstName, mi, suff);
    }

    public void displayName() {
        String mi = (middleName == null || middleName.trim().isEmpty() || middleName.equals("N/A")) 
                    ? "" : " " + middleName.trim().toUpperCase().charAt(0) + ".";
        System.out.printf("%s, %s%s%n", lastName, firstName, mi);
    }

    @Override
    public String toString() {
        return getFormattedName();
    }
}
