package com.xh.common.map;

import java.util.*;

/**
 * Face up to failure
 *
 * @Author xh
 * @Date 2020/9/16- 0:14
 */
public class Pair <K,V> {

    public  final K key;

    public  final V value;

    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

}
class MapData<K,V> extends LinkedHashMap<K,V>{

    public MapData(Generator<Pair<K , V>> gen , int quantity ){
        for (int i = 0; i <quantity ; i++) {
            Pair<K, V> p = gen.next();
            put(p.key , p.value);
        }
    }
}

