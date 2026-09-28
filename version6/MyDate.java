package version6;

import java.util.Objects;

public final class MyDate implements Cloneable {
    private int day;
    private int month;
    private int year;

    private static final String[] MONTH_NAMES = {
        "", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    public MyDate() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    public MyDate(int day, int month, int year) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public int getDay() { return day; }
    public void setDay(int day) {
        int maxDays = getMaxDaysInMonth(this.month, this.year);
        if (day < 1 || day > maxDays) {
            throw new IllegalArgumentException("Invalid day for the specified month.");
        }
        this.day = day;
    }

    public int getMonth() { return month; }
    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must fall between 1 and 12.");
        }
        this.month = month;
    }

    public int getYear() { return year; }
    public void setYear(int year) {
        if (year <= 1900) {
            throw new IllegalArgumentException("Year must be a valid positive calendar year (> 1900).");
        }
        this.year = year;
    }

    private int getMaxDaysInMonth(int m, int y) {
        switch (m) {
            case 4: case 6: case 9: case 11: return 30;
            case 2: return (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) ? 29 : 28;
            default: return 31;
        }
    }

    public void displayDate() {
        System.out.println(this.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyDate other = (MyDate) obj;
        return day == other.day && month == other.month && year == other.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public MyDate clone() {
        try {
            return (MyDate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        String mStr = (month >= 1 && month <= 12) ? MONTH_NAMES[month] : "Jan";
        return String.format("%02d %s %d", day, mStr, year);
    }
}
