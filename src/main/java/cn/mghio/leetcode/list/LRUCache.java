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

  private Map<Integer, Node> map;
  private DoubleList cache;
  private int capacity;

  public LRUCache(int capacity) {
    this.cache = new DoubleList();
    this.map = new HashMap<>();
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }

    makeRecently(key);
    return map.get(key).value;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      deleteKey(key);
      addRecently(key, value);
      return;
    }

    if (cache.size == this.capacity) {
      removeLeastRecently();
    }
    addRecently(key, value);
  }

  private void makeRecently(int key) {
    Node node = map.get(key);
    cache.removeNode(node);
    cache.addHead(node);
  }

  private void addRecently(int key, int value) {
    Node node = new Node(key, value);
    cache.addHead(node);
    map.put(key, node);
  }

  private void deleteKey(int key) {
    Node node = map.get(key);
    cache.removeNode(node);
    map.remove(key);
  }

  private void removeLeastRecently() {
    Node deleteNode = cache.removeLast();
    map.remove(deleteNode.key);
  }

  public class DoubleList {

    private Node head;
    private Node tail;
    private int size;

    public DoubleList() {
      this.head = new Node(0, 0);
      this.tail = new Node(0, 0);
      head.next = tail;
      tail.prev = head;
      this.size = 0;
    }

    public void addHead(Node node) {
      node.prev = head;
      node.next = head.next;
      head.next = node;
      head.next.prev = node;
      size++;
    }

    public void removeNode(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      size--;
    }

    public Node removeLast() {
      if (head.next == tail) {
        return null;
      }
      Node least = tail.prev;
      removeNode(least);
      return least;
    }
  }

  public class Node {

    private int key;
    private int value;
    private Node prev;
    private Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

}
