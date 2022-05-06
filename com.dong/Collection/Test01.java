package Collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        Integer  [] integer= new Integer[]{1,2,4,5,6,7,8};
        List<Integer> integers = Arrays.asList(integer);
        Collections.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(integers);
        method3(1,2,4,5);
    }

      public static void method3(Integer... nums){
        // 使用:把nums可变参数当成数组使用
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
