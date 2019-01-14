package com.zhl.collection;


/**
 * Created by zhl on 18/6/27 上午10:50.
 * 定义一个接口，对外暴露快速存取的方法。
 * 注意MyMap接口内部定义了一个内部接口Entry
 */
public interface MyMap<K,V>{
        public V put(K k, V v);

        public V get(K k);

        interface Entry<K, V>{
            public K getKey();

            public V getValue();
        }
}
