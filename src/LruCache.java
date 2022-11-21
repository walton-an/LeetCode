package com.duowan.cs.live.dispatch;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于hashMap + 双向链表实现lru
 *
 * @author Yangweitong
 * @date 2022/11/3
 */
public class LruCache {
    private final int cap;

    Map<Integer, Node> lruCache;

    Node head;
    Node tail;

    /**
     * 双向链表，头结点是最久未访问数据，尾结点是最新数据
     */
    public static class Node {
        int k;
        int v;
        Node pre;
        Node next;
        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    public LruCache(int cap) {
        this.cap = cap;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        lruCache = new HashMap<>(cap);
        tail.pre = head;
        head.next = tail;
    }

    public void put(int k, int v) {
        // 执行get操作，存在时帮我们移到队尾。此时直接返回就行
        if (get(k) != -1) {
            Node node = lruCache.get(k);
            node.v = v;
            return;
        }
        Node node = new Node(k, v);
        lruCache.put(k, node);
        // move
        modeToTail(node);

        if (lruCache.size() > cap) {
            lruCache.remove(head.next.k);
            head.next = head.next.next;
            head.next.pre = head;
        }

    }

    public int get(int k) {
        if (!lruCache.containsKey(k)) {
            return -1;
        }
        Node node = lruCache.get(k);
        // 先删除该节点，再移到队尾
        node.next.pre = node.pre;
        node.pre.next = node.next;

        modeToTail(node);
        return node.v;

    }

    public void modeToTail(Node node) {
        node.pre = tail.pre;
        tail.pre.next = node;
        node.next = tail;
        tail.pre = node;
    }


    public static void main(String[] args) {
        LruCache lruCache = new LruCache(2);
        lruCache.put(1,10);
        lruCache.put(2,20);
        int i = lruCache.get(1);
        lruCache.put(3, 30);
        int i1 = lruCache.get(1);
        int i2 = lruCache.get(2);
        int i3 = lruCache.get(3);
        lruCache.put(4, 40);
        int i11 = lruCache.get(1);
        int i21 = lruCache.get(3);
        int i31 = lruCache.get(4);
        System.out.println();
    }
}
