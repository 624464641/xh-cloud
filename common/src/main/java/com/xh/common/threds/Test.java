package com.xh.common.threds;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.*;

/**
 * @author xt
 * @date 2020/9/15
 */
public class Test
{


    public static void main(String[] args) {

        // // 获取 Java 线程管理 MXBean
        // ThreadMXBean  threadMXBean = ManagementFactory.getThreadMXBean() ;
        // // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
        // ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // // 遍历线程信息，仅打印线程 ID 和线程名称信息
        // for (ThreadInfo threadInfo : threadInfos) {
        //     System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        // }

        Map<String , Object> map = new TreeMap<>();
        map.put("123" , "小华");
        map.put("23" , "大话");
        map.put("32" , "西游");
        map.put("56" , "西游");
        map.put("45" , 45);
        map.put(null , null);

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            if(iterator.next() == null ){
                continue;
            }
            Map.Entry<String, Object>   ma = iterator.next();
            System.out.println(ma.getKey());
        }




    }


}
