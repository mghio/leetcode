package cn.mghio.leetcode.list;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity. int get(int key)
 * Return the value of the key if the key exists, otherwise return -1. void put(int key, int
 * value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the
 * cache. If the number of keys exceeds the capacity from this operation, evict the least recently
 * used key. The functions get and put must each run in O(1) average time complexity.
 *
 * @author mghio
 * @since 2021-11-21
 */
public class LRUCache {

  private final Map<Integer, Node> map;
  private final DoubleList cache;
  private final int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>();
    cache = new DoubleList();
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    makeRecently(key);
    return map.get(key).val;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      deleteKey(key);
      addRecently(key, value);
      return;
    }

    if (capacity == cache.getSize()) {
      removeLastRecently();
    }
    addRecently(key, value);
  }

  private void makeRecently(int key) {
    Node node = map.get(key);
    cache.remove(node);
    cache.addLast(node);
  }

  private void addRecently(int key, int value) {
    Node node = new Node(key, value);
    cache.addLast(node);
    map.put(key, node);
  }

  private void deleteKey(int key) {
    Node node = map.get(key);
    cache.remove(node);
    map.remove(key);
  }

  private void removeLastRecently() {
    Node toDeleteNode = cache.removeFirst();
    map.remove(toDeleteNode.key);
  }

  public static class DoubleList {
    private final Node head;
    private final Node tail;
    private int size;

    public DoubleList() {
      head = new Node(0, 0);
      tail = new Node(0, 0);
      head.next = tail;
      tail.prev = head;
      size = 0;
    }

    public void addLast(Node node) {
      node.prev = tail.prev;
      node.next = tail;
      tail.prev.next = node;
      tail.prev = node;
      size++;
    }

    public void remove(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      size--;
    }

    public Node removeFirst() {
      if (head.next == null) {
        return null;
      }
      Node first = head.next;
      remove(first);
      return first;
    }

    public int getSize() {
      return size;
    }
  }

  public static class Node {
    public int key;
    public int val;

    private Node prev;
    private Node next;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
    }

  }

}
