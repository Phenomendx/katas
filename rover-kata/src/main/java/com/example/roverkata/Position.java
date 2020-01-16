package com.example.roverkata;

public class Position {

  private int x;
  private int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Position(Position that) {
   this.x = that.x;
   this.y = that.y;
  }

  @Override
  public String toString() {
    return x + ":" + y + ":";
  }

  public int increaseY() {
    if (y == 9) {
      return y = 0;
    }
    return ++y;
  }

  public int increaseX() {
    return ++x;
  }

  public int decreaseY() {
    return --y;
  }

  public int decreaseX() {
    return --x;
  }
}
