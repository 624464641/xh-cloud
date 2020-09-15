package com.xh.common.map;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Face up to failure
 *
 * @Author xh
 * @Date 2020/8/15- 17:44
 */
public class MyMap {

    public static void main(String[] args) {
        // Map<String,String > map= new HashMap<>(2,0.75f);
        // map.put("123","2");
        // String result =  map.put("123","3"); // 返回被替换为原来的值
        // System.out.println(map.containsValue("2"));
        // System.out.println(String.format("返回的值是%s" , result));
        // Set<Map.Entry<String, String>> entries = map.entrySet();
        // for (Map.Entry<String, String> obj : entries){
        //     System.out.println(obj.getValue());
        //     System.out.println(obj.getKey());
        // }
        // System.out.println(map.get("123"));
        // System.out.println(map.entrySet());
        ArrayList list=new ArrayList<>();
        // list.add(123);
        // System.out.println("2".hashCode());
        // System.out.println(50 / 8);//48690
        /**
         * 1. weblist去重
         *  list.stream().filter(name :: User).distinct().collect(Collectors.toList())
         * 2. 获取数据中唯一的属性 ，去查找数据库 如name  weblist
         *  Set set = new HashSet();
         *  set.add(name)
         * 3. 用set 去查数据库  dblist
         * 4. 然后从weblist中去除dblist
         */
        System.out.println(1 << 30);
    }
}
