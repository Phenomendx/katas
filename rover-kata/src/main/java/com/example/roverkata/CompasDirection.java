package com.example.roverkata;

public enum CompasDirection {
  NORTH("N"),
  EAST("E"),
  SOUTH("S"),
  WEST("W");

  private final String orientationSymbol;

  CompasDirection(String orientationSymbol) {
    this.orientationSymbol = orientationSymbol;
  }

  @Override
  public String toString() {
    return orientationSymbol;
  }
}
