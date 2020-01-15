package com.example.roverkata;

public class RoverLocation {

  private Position roverPosition = new Position(0, 0);
  private CompasDirection roverDirection = CompasDirection.NORTH;

  public CompasDirection getRoverDirection() {
    return roverDirection;
  }

  public void setRoverDirection(CompasDirection roverDirection) {
    this.roverDirection = roverDirection;
  }

  public void advanceOnNorth() {
    roverPosition.increaseY();
  }

  public String getLocation() {
    return roverPosition.toString() + roverDirection.toString();
  }
}
