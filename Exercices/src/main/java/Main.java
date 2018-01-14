/**
 * Created by sunye on 09/12/2016.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(-1 % 20);

        System.out.println((double) (18/4));

        Date d = new Date(21,2,2002);
        System.out.println(d.dayOfWeek());

        d = new Date(11,7,1932);
        System.out.println(d.dayOfWeek());

        d = new Date(15,2,1950);
        System.out.println(d.dayOfWeek());

        d = new Date(5,3,1964);
        System.out.println(d.dayOfWeek());

        d = new Date(2,1,2000);
        System.out.println(d.dayOfWeek());

    }
}
