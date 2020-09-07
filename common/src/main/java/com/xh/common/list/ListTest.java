package com.xh.common.list;

import sun.management.GarbageCollectionNotifInfoCompositeData;

import java.util.*;

/**
 * Face up to failure
 *
 * @Author xh
 * @Date 2020/8/16- 23:33
 */
public class ListTest {

    static final  String[] [] data={
       {"key" , "value"}

    };
    public static void main(String[] args) {

        ArrayList<StringAddress> list = new ArrayList<StringAddress>(Collections.nCopies(1, new StringAddress("hello")));

        System.out.println(list.get(0));
        Collections.fill(list , new StringAddress("word"));
        System.out.println(list.get(0));


        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("123");



        StringAddress address = new StringAddress();
        Map<Object,Object> map= new HashMap<>();
        map.put (address , "123");
        System.out.println(address.hashCode());

    }
    class test{
        String abc = "123";
    }
}

/**
 * 会重新生成一个class文件
 */
class StringAddress{

    String str;

    public StringAddress(){

    }

    public StringAddress(String str) {
        this.str = str;
    }

    @Override
    public String toString(){
        return super.toString()+""+str;
    }

}
