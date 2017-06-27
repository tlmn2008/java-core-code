package kenny.algorithm.date_and_time.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    public static void main(String[] args){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        String dateNowStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS").format(new Date());
        System.out.println("格式化后的日期：" + dateNowStr);
    }
}
