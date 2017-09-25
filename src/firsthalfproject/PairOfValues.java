/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firsthalfproject;

/**
 *
 * @author Bill
 */
public class PairOfValues<L,R> {

  private final L left;
  private final R right;

  public PairOfValues(L leftValue, R rightValue) {
    left = leftValue;
    right = rightValue;
  }

  public L getLeft() { return left; }
  public R getRight() { return right; }

  @Override
  public int hashCode() { return left.hashCode() ^ right.hashCode(); }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof PairOfValues)) return false;
    PairOfValues pairo = (PairOfValues) o;
    return this.left.equals(pairo.getLeft()) &&
           this.right.equals(pairo.getRight());
  }

}