package net.seocoo.ggys.core.util;

import java.io.Serializable;

/**
 * 引入一个简简单单的Pair, 用于返回值返回两个元素.
 * @author ZengXiaoLiang
 * @date 2018/6/15 14:53
 **/
public class Pair<L, R> implements Serializable{
  
  private  L left;
  
  private  R right;

  /**
   * Creates a new pair.
   */
  public Pair( L left,  R right) {
    this.left = left;
    this.right = right;
  }

  public Pair() {
  }

  public L getLeft() {
    return left;
  }

  public void setLeft(L left) {
    this.left = left;
  }

  public R getRight() {
    return right;
  }

  public void setRight(R right) {
    this.right = right;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((left == null) ? 0 : left.hashCode());
    return prime * result + ((right == null) ? 0 : right.hashCode());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Pair other = (Pair) obj;
    if (left == null) {
      if (other.left != null) {
        return false;
      }
    } else if (!left.equals(other.left)) {
      return false;
    }
    if (right == null) {
      if (other.right != null) {
        return false;
      }
    } else if (!right.equals(other.right)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Pair [left=" + left + ", right=" + right + ']';
  }

  /**
   * 根据等号左边的泛型，自动构造合适的Pair
   */
  public static <L, R> Pair<L, R> of( L left,  R right) {
    return new Pair<L, R>(left, right);
  }
}
