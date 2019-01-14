import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by zhl on 18/7/9 上午10:26.
 */
public class testGlobalParam {

    public static void main(String[] args) throws Exception{
       /* Integer currentNum = 0;
        String cur = "";
        for (int i = 0;i<10;i++){
            System.out.println("cur:"+cur);
            System.out.println("currentNum:"+currentNum);
            Integer result = printLog("zhl", i);
            if(result == 6){
                return;
            }
            cur = String.valueOf(result);
            currentNum = result;
            System.out.println("test test test:"+currentNum);
        }*/

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 0);
        Date theDate = calendar.getTime();

        //上个月第一天
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);

        Long day_first = gcLast.getTime().getTime() / 1000l;

        //上个月最后一天
        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);        //设置为该月第一天
        Long day_last = calendar.getTime().getTime() / 1000l;

        System.out.println("day_first:"+day_first.intValue());
        System.out.println("day_first:"+day_last.intValue());

        String vendorId = "0";
        System.out.println(Long.valueOf(vendorId));

    }



    public static Integer printLog(String string, Integer i) throws Exception{
        Thread.sleep(1000);
        System.out.println("你好啊:" +string+i);
        i = i+1;
        return i;
    }
}

