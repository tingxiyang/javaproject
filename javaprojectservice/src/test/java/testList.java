import java.util.ArrayList;
import java.util.List;

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
