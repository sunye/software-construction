
public class Date {

    private int day;
    private int month;
    private int year;

    public Date (int d, int m, int y) {
        assert isValidDate(d,m,y);

        day = d;
        month = m;
        year = y;
    }

    /**
     * Calculate day of week using Zeller's algorithm
     *
     * @return 0 for  Saturday, 1 for Sunday, etc.
     */
    public int dayOfWeek() {
        assert isValid() : "Valid" ;
        assert year > 1752 : "Modern";  // and not russia < 19xx ...

        int hundreds = this.year / 100;
        int centuryYear = this.year % 100;
        int m = this.month;
        int result;

        // march = 3; jan = 13, feb = 14 of previous year.
        if (m < 3) {
            m += 12;
            if (centuryYear > 0) {
                centuryYear -= 1;
            } else {
                centuryYear = 99;
                hundreds -=  1;
            }
        }

        // Zeller formula.
        result =  ((this.day + ((26 * (m + 1)) / 10) +
                centuryYear + (centuryYear / 4) + (hundreds / 4)
                - (2 * hundreds)) % 7);

        // remainder to modulo
        if (result < 0) {
            result = result + 7;
        }

        assert result >= 0 && result < 7 : "Valid result";

        return result;
    }

    private boolean isValidDate(int d, int m, int y) {
        return d >= 1 && d <= 31 &&
                m >= 1 && m <= 12 &&
                y > 0;
    }
    private boolean isValid() {
        return this.isValidDate(day,month,year);
    }
}