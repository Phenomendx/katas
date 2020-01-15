package com.example.roverkata;

public class MoveCommand extends RoverCommand {

  @Override
  public RoverLocation execute(RoverLocation roverLocation) {

    if (roverLocation.getRoverDirection() == CompasDirection.NORTH) {
      moveToNorth(roverLocation);
    }

    return roverLocation;
  }

  private void moveToNorth(RoverLocation roverLocation) {
    roverLocation.advanceOnNorth();
  }
}
