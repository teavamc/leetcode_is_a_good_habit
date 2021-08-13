package handwrite.javaer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package handwrite.javaer
 * @date 2021/8/5 22:23
 */
public class 手写简单的hashmap {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ceshi");
        list.add("测试");
        list.add("爪哇");
        list.add("狗朗");
        list.add("为什么");
        list.add("why");
        list.add("牛批");
        list.add("伞兵");

        String[] tab = new String[8];

        for (String key:list){
            int idx = key.hashCode() & tab.length -1;
            System.out.println(String.format("key=[%s], Idx=[%d]",key,idx));
            if (null == tab[idx]){
                tab[idx] = key;
                continue;
            }
            tab[idx] = tab[idx] + "->" + key;
        }
        System.out.println(tab.toString());
    }
}
