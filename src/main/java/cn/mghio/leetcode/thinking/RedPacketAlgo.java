package cn.mghio.leetcode.thinking;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Red Packet Algorithm
 *
 * @author mghio
 * @since 2022-01-18
 */
public class RedPacketAlgo {

  public static void main(String[] args) {
    List<Integer> amountList = divideRedPacket(5000, 30);
    for (Integer amount : amountList) {
      System.out.println("抢到金额：" + new BigDecimal(amount).divide(new BigDecimal(100)));
    }
  }

  /**
   * Divide red packet.
   *
   * @param totalAmount the total amount
   * @param totalPeopleNum the total people number
   * @return the red packets
   */
  public static List<Integer> divideRedPacket(Integer totalAmount, Integer totalPeopleNum) {
    List<Integer> amountList = new ArrayList<>();
    Integer restAmount = totalAmount;
    Integer restPeopleNum = totalPeopleNum;
    Random random = new Random();

    for (int i = 0; i < totalPeopleNum - 1; i++) {
      // 随机范围：[1，剩余人均金额的两倍)，左闭右开
      int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
      restAmount -= amount;
      restPeopleNum--;
      amountList.add(amount);
    }
    amountList.add(restAmount);
    return amountList;
  }

}
