package cn.mghio.leetcode.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache.
 *
 * @author mghio
 * @since 2022-04-11
 */
public class LRUCache {

  private Map<Integer, Node> map;
  private DoubleList doubleList;
  private int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>(capacity);
    this.doubleList = new DoubleList();
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }

    Node curNode = map.get(key);
    doubleList.moveToLast(curNode);
    return curNode.value;
  }

  public void put(int key, int val) {
    Node newNode = new Node(key, val);
    if (map.containsKey(key)) {
      Node curNode = map.get(key);
      doubleList.remove(curNode);
      doubleList.moveToLast(newNode);
      map.put(key, newNode);
    } else {
      if (doubleList.getSize() == capacity) {
        Node firstNode = doubleList.removeFirst();
        if (firstNode != null) {
          map.remove(firstNode.key);
        }
      }
      doubleList.addLast(newNode);
      map.put(key, newNode);
    }
  }

  class DoubleList {

    private Node head;
    private Node tail;
    private int size;

    public DoubleList() {
      head = new Node(-1, -1);
      tail = new Node(-1, -1);
      head.next = tail;
      tail.prev = head;
      size = 0;
    }

    public void moveToLast(Node node) {
      remove(node);
      addLast(node);
    }

    public void addLast(Node node) {
      tail.prev.next = node;
      node.prev = tail.prev;
      node.next = tail;
      tail.prev = node;
      size++;
    }

    public void remove(Node node) {
      Node prev = node.prev;
      prev.next = node.next;
      node.next.prev = prev;
      node.next = null;
      node.prev = null;
      size--;
    }

    public Node removeFirst() {
      if (head.next == tail) {
        return null;
      }

      Node first = head.next;
      head.next = first.next;
      first.next.prev = head;
      first.next = null;
      first.prev = null;
      return first;
    }

    public int getSize() {
      return size;
    }
  }

  class Node {

    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

}
