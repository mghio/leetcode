package cn.mghio.leetcode.heap;

/**
 * Max heap.
 *
 * @author mghio
 * @since 2022-01-18
 */
public class MaxPriorityQueue<K extends Comparable<K>> {

  /**
   * 存储元素的数组
   */
  private final K[] pq;

  /**
   * 当前元素的个数
   */
  private int count;

  public MaxPriorityQueue(int count) {
    // 索引 0 不用，所以多分配一个空间
    this.pq = (K[]) new Comparable[count + 1];
  }

  public K max() {
    return pq[1];
  }

  public void insert(K e) {
    count++;
    pq[count] = e;
    swim(count);
  }

  public K delMax() {
    K max = pq[1];
    // 把这个最大元素换到最后，删除之
    exch(1, count);
    pq[--count] = null;
    // 让 pq[1] 下沉到正确位置
    sink(1);
    return max;
  }

  public boolean isEmpty() {
    return count == 0;
  }

  /**
   * 上浮第 K 个元素，维护堆的性质
   *
   * @param k
   */
  private void swim(int k) {
    // 如果浮到堆顶，就不能再上浮了
    while (k > 1 && less(parent(k), k)) {
      // 如果第 k 个元素比上层大，将 k 换上去
      exch(parent(k), k);
      k = parent(k);
    }
  }

  /**
   * 下沉第 K 个元素，维护堆的性质
   *
   * @param k
   */
  private void sink(int k) {
    // 如果下沉到堆低，就不再下沉了
    while (left(k) < count) {
      // 先假设左子节点比较大
      int older = left(k);

      if (right(k) < count && less(older, right(k))) {
        older = right(k);
      }

      // 节点比俩孩子都大，就不用再下沉了
      if (less(older, k)) {
        break;
      }

      // 否则，不符合堆结构，下沉 k 节点
      exch(k, older);
      k = older;
    }
  }

  private void exch(int i, int j) {
    K tmp = pq[i];
    pq[i] = pq[j];
    pq[j] = tmp;
  }

  /**
   * pq[i] 是否比 pq[j] 小？
   *
   * @param i
   * @param j
   * @return
   */
  private boolean less(int i, int j) {
    return pq[i].compareTo(pq[j]) < 0;
  }

  /**
   * 父节点的索引
   *
   * @param k
   * @return
   */
  private int parent(int k) {
    return k / 2;
  }

  /**
   * 左子节点的索引
   *
   * @param k
   * @return
   */
  private int left(int k) {
    return k * 2;
  }

  /**
   * 右子节点的索引
   *
   * @param k
   * @return
   */
  private int right(int k) {
    return k * 2 + 1;
  }

}
