package com.example.roverkata;

public class RoverLocation {

  private Position roverPosition;
  private CompasDirection roverDirection;

  public RoverLocation(Position position, CompasDirection direction) {
    roverPosition = position;
    roverDirection = direction;
  }

  public CompasDirection getRoverDirection() {
    return roverDirection;
  }

  public String getLocation() {
    return roverPosition.toString() + roverDirection.toString();
  }

  public void setRoverDirection(CompasDirection roverDirection) {
    this.roverDirection = roverDirection;
  }

  public void advanceOnNorth() {
    roverPosition.increaseY();
  }

  public void advanceOnEast() {
    roverPosition.increaseX();
  }


  public void advanceOnSouth() {
    roverPosition.decreaseY();
  }

  public void advanceOnWest() {
    roverPosition.decreaseX();
  }
}
