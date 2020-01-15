package com.example.roverkata;

import java.util.Map;

public class RightCommand extends RoverCommand {

  private Map<CompasDirection, CompasDirection> nextRightOrientation = Map.of(
      CompasDirection.NORTH, CompasDirection.EAST,
      CompasDirection.EAST, CompasDirection.SOUTH,
      CompasDirection.SOUTH, CompasDirection.WEST,
      CompasDirection.WEST, CompasDirection.NORTH
  );

  @Override
  public RoverLocation execute(RoverLocation roverLocation) {
    roverLocation.setRoverDirection(nextRightOrientation.get(roverLocation.getRoverDirection()));
    return roverLocation;
  }
}
