import com.zhl.util.DateUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by zhl on 18/6/6 下午8:26.
 */
public class testList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);//0
        list.add(2);//1
        list.add(3);//2
//        list.add(4);//3
//        list.add(5);//4
//        list.add(6);//5
//        list.add(7);//6


        System.out.println(list);
        List<SplitVo> result = new ArrayList<>();
        //list.size() 7
        for(int i=0; i<list.size(); i++){
            SplitVo vo = new SplitVo();
            if(i<list.size()-1){
                vo.setStart(list.get(i));
                vo.setEnd(list.get(i+1));
                result.add(vo);
            }

        }

        System.out.println(result);

        String time = "9999-06-01";
        Date date = DateUtils.parseDate(time, DateUtils.dateFormat);
        System.out.println("date>>"+date);

        Calendar calendar = Calendar.getInstance();

        String redisKey = String.valueOf(calendar.get(Calendar.YEAR)) + "-"
                + String.valueOf((calendar.get(Calendar.MONTH) + 1) < 10 ? "0" + (calendar.get(Calendar.MONTH) + 1) : (calendar.get(Calendar.MONTH) + 1)) + "-"
                + String.valueOf((calendar.get(Calendar.DAY_OF_MONTH)) < 10 ? "0" + (calendar.get(Calendar.DAY_OF_MONTH)) : (calendar.get(Calendar.DAY_OF_MONTH)));


        System.out.println("redisKey: "+redisKey);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(weekDay);



        Calendar calendar1 = Calendar.getInstance();
        Integer returnYear = calendar1.get(Calendar.YEAR);
        String retuenMonth = calendar1.get(Calendar.MONTH)+1 < 10 ? "0"+ String.valueOf(calendar1.get(Calendar.MONTH)+1) : String.valueOf(calendar1.get(Calendar.MONTH)+1);
        System.out.println("returnYear:"+returnYear);
        System.out.println("retuenMonth"+retuenMonth);

        List<SplitVo> vos = new ArrayList<>();
        for(int i=0;i<6;i++) {
            SplitVo v = new SplitVo();
            v.setStart(i);
            if(i != 2){
                v.setEnd(i+1);
            }
            vos.add(v);
        }
        List<SplitVo> vos2 = vos.stream().filter(v -> v.getEnd() != null).collect(toList());
        System.out.println("vos2:"+vos2);

        String s1 = null;
        String s2 = "z";

        if(s2.equals(s1)) {
            System.out.println("sssssssss");
        }else{
            System.out.println("zzzzz");
        }


    }
}

class SplitVo {
    private Integer start;
    private Integer end;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "SplitVo{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
