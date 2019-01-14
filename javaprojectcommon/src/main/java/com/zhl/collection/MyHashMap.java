package com.zhl.collection;

import java.util.ArrayList;
import java.util.List;
import com.zhl.collection.Entry;

/**
 * Created by zhl on 18/6/27 上午10:57.
 */
public class MyHashMap<K, V> implements MyMap<K, V> {

    //数组的默认初始化长度 16
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    //阀值比例
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int defaultInitSize;

    private float defaultLoadFactor;

    //Map当中entry的数量
    private int entryUseSize;

    //数组
    private com.zhl.collection.Entry<K, V>[] table = null;


    public MyHashMap(){
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int defaultInitialCapacity, float defaultLoadFactor) {
        if(defaultInitialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + defaultInitialCapacity);
        }
        if(defaultLoadFactor <=0 || Float.isNaN(defaultLoadFactor)) {
            throw new IllegalArgumentException("Illegal load factor: " + defaultLoadFactor);
        }
        this.defaultInitSize = defaultInitialCapacity;
        this.defaultLoadFactor = defaultLoadFactor;

        table = new com.zhl.collection.Entry[this.defaultInitSize];
    }







    @Override
    public V put(K k, V v) {
        V oldValue = null;
        //是否需要扩容
        //扩容完毕，肯定需要重新散列
        if (entryUseSize >= defaultInitSize * defaultLoadFactor) {
            resize(2 * defaultInitSize);
        }
        //得到HASH值，计算出数组中的位置
        int index = hash(k) & (defaultInitSize - 1);
        if(table[index] == null){
            table[index] = new com.zhl.collection.Entry<K,V>(k, v, null);
            ++entryUseSize;
        } else { //需要遍历单链表
            com.zhl.collection.Entry<K,V> entry = table[index];
            com.zhl.collection.Entry<K, V> e = entry;
            while(e != null){
                if(k == e.getKey() || k.equals(e.getKey())) {
                    oldValue = e.value;
                    e.value = v;
                    return oldValue;
                }
                e = e.next;
            }
            table[index]  = new com.zhl.collection.Entry<K, V>(k, v, entry);
            ++ entryUseSize;
        }

        return oldValue;
    }

    @Override
    public V get(K k) {
        int index = hash(k) & (defaultInitSize - 1);
        if(table[index] == null){
            return null;
        } else {
            com.zhl.collection.Entry<K, V> entry = table[index];
            do {
                if(k == entry.getKey() || k.equals(entry.getKey())) {
                    return entry.value;
                }
                entry = entry.next;
            } while (entry != null);
        }
        return null;
    }

    static final int hash(Object k){
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    private void resize(int i){
        com.zhl.collection.Entry[] newTable = new com.zhl.collection.Entry[i];
        //改变数组的大小
        defaultInitSize = i;
        entryUseSize = 0;
        rehash(newTable);

    }

    private void rehash(com.zhl.collection.Entry<K, V>[] newTable) {
        //得到原来的老的Entry集合，注意遍历单链表
        List<Entry<K, V>> entryList = new ArrayList<Entry<K, V>>();
        for (com.zhl.collection.Entry<K, V> entry : table){
            if(entry != null) {
                do {
                    entryList.add(entry);
                    entry = entry.next;
                } while (entry != null);
            }
        }

        //覆盖旧的引用
        if(newTable.length > 0){
            table = newTable;
        }

        //所谓重新HASH，就是重新PUT, ENTRY到HASHMAP
        for(Entry<K, V> entry : entryList) {
            put(entry.getKey(), entry.getValue());
        }
    }


}

class Entry<K, V> implements MyMap.Entry<K, V> {

    public K key;

    public V value;

    public Entry<K, V> next;

    public Entry(){

    }
    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }


    @Override
    public K getKey() {
        return null;
    }

    @Override
    public V getValue() {
        return null;
    }
}
