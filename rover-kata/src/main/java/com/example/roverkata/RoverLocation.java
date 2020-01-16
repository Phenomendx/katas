package com.example.roverkata;

import static com.example.roverkata.CompasDirection.*;

public class RoverLocation implements Cloneable {

  private Position roverPosition;
  private CompasDirection roverDirection = NORTH;

  public RoverLocation(Position position, CompasDirection direction) {
    roverPosition = position;
    roverDirection = direction;
  }

  public RoverLocation(RoverLocation that) {
    this.roverPosition = new Position(that.roverPosition);
    this.roverDirection = that.roverDirection;
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
