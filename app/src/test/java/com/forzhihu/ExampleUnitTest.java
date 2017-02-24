package com.forzhihu;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void test() {

        int index = 0;

        String[] strings = {"a", "b", "c", "a", "a", "a", "b", "b", "b", "b","c", "d"};


//        StringBuffer sb = new StringBuffer();
//        for (String s : strings) {
//            if (!sb.toString().contains(s)) { //从字符串缓存区中判断是否已经包含此字符
//
//                for (int i = 0; i < strings.length; i++) { //循环判断是否存在两个或两个以上
//                    if (s.equals(strings[i])) {
//                        index++;
//                        if (index >= 2) { //存在两个或两个以上返回,跳出循环
//                            return;
//                        }
//                    }
//                }
//                //判断是否存在两个或两个以上
//                if (index >= 2) {
//                    //存在两个或两个以上添加到字符串缓存区
//                    sb.append(s);
//                }
//                index = 0;
//            }
//        }
//
//        System.out.println(sb.toString());

        List list = Arrays.asList(strings);
        Set set = new HashSet(list);
        String[] rid = (String[]) set.toArray(new String[0]);
        for (int i = 0; i < rid.length; i++) {
            System.out.println(rid[i]);
        }
    }

}