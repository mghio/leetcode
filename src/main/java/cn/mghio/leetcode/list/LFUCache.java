package cn.mghio.leetcode.list;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author mghio
 * @since 2021-12-25
 */
public class LFUCache {

  HashMap<Integer, Integer> keyToVal;
  HashMap<Integer, Integer> keyToFreq;
  HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
  int minFreq;
  int capacity;

  public LFUCache(int capacity) {
    keyToVal = new HashMap<>();
    keyToFreq = new HashMap<>();
    freqToKeys = new HashMap<>();
    this.minFreq = 0;
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!keyToVal.containsKey(key)) {
      return -1;
    }

    increaseFreq(key);
    return keyToVal.get(key);
  }

  public void put(int key, int value) {
    if (this.capacity <= 0) {
      return;
    }

    if (keyToVal.containsKey(key)) {
      keyToVal.put(key, value);
      increaseFreq(key);
      return;
    }

    if (this.capacity <= keyToVal.size()) {
      removeMinFreqKey();
    }

    keyToVal.put(key, value);
    keyToFreq.put(key, 1);
    freqToKeys.putIfAbsent(key, new LinkedHashSet<>());
    freqToKeys.get(1).add(key);
    this.minFreq = 1;
  }

  private void removeMinFreqKey() {
    LinkedHashSet<Integer> minFreqKeys = freqToKeys.get(this.minFreq);
    int deleteKey = minFreqKeys.iterator().next();
    minFreqKeys.remove(deleteKey);
    if (minFreqKeys.isEmpty()) {
      freqToKeys.remove(this.minFreq);
    }
    keyToVal.remove(this.minFreq);
    keyToFreq.remove(this.minFreq);
  }

  private void increaseFreq(int key) {
    int freq = keyToFreq.get(key);
    keyToFreq.put(key, freq + 1);
    freqToKeys.get(freq).remove(key);
    freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
    freqToKeys.get(freq + 1).add(key);
    if (freqToKeys.get(freq).isEmpty()) {
      freqToKeys.remove(freq);
      if (freq == this.minFreq) {
        this.minFreq++;
      }
     }
  }

}
