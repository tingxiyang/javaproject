/*
package com.zhl.collection;

*/
/**
 * Created by zhl on 18/6/27 上午11:17.
 * 构造方法有什么好呢？
 * 其实这里使用到了"门面模式"，这里的2个构造方法其实指向的是同一个，但是对外切暴露了2个"门面"
 *//*

public class Entry<K, V> implements MyMap.Entry<K, V> {

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
*/
