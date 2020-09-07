package com.xh.common.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Face up to failure
 *
 * @Author xh
 * @Date 2020/8/15- 17:44
 */
public class MyMap {

    public static void main(String[] args) {
        HashMap<String,String > map= new HashMap<>(10,0.75f);

        map.put("123","2");
        String result =  map.put("123","3"); // 返回被替换为原来的值

        System.out.println(map.get("123"));

        System.out.println(result);
        System.out.println(map.entrySet());


        //ArrayList list=new ArrayList<>();
        //list.add(123);
        //System.out.println("2".hashCode());
        //System.out.println(50 / 8);//48690

    }
}
