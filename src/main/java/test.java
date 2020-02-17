import java.sql.Date;

public class test {
    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis());
        Date date1 = new Date(2000, 1, 1);

        System.out.println(date.getTime() + "<" + date1.getTime());

    }
}
