package com.example.roverkata;

public class RoverLocation {

  private Position roverPosition = new Position(0, 0);
  private CompasDirection roverDirection = CompasDirection.NORTH;

  public Position getRoverPosition() {
    return roverPosition;
  }

  public void setRoverPosition(Position roverPosition) {
    this.roverPosition = roverPosition;
  }

  public CompasDirection getRoverDirection() {
    return roverDirection;
  }

  public void setRoverDirection(CompasDirection roverDirection) {
    this.roverDirection = roverDirection;
  }

  public String getLocation() {
    return roverPosition.toString() + roverDirection.toString();
  }
}
