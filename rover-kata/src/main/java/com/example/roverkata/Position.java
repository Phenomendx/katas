package com.example.roverkata;

public class Position {

  private int x;
  private int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return x + ":" + y + ":";
  }

  public int increaseY() {
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
