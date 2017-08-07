package kenny.algorithm.date_and_time.date;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    public static void main(String[] args){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        String dateNowStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS").format(new Date());
        System.out.println("格式化后的日期：" + dateNowStr);

        // TEST
        dateStringConvertTest();
    }

    public static void dateStringConvertTest() {
        // string to date
        String dateStr = "2017-08-01 18:00:00";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date date = formatter.parse(dateStr, pos);
        // date to string
        String dateStr2 = formatter.format(date);
        System.out.println(dateStr);
        System.out.println(dateStr2);

    }
}
