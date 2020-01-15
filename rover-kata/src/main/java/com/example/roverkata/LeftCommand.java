package com.example.roverkata;

import java.util.Map;

public class LeftCommand extends RoverCommand {

  private Map<CompasDirection, CompasDirection> nextLeftOrientation = Map.of(
      CompasDirection.NORTH, CompasDirection.WEST,
      CompasDirection.EAST, CompasDirection.NORTH,
      CompasDirection.SOUTH, CompasDirection.EAST,
      CompasDirection.WEST, CompasDirection.SOUTH
  );

  @Override
  public RoverLocation execute(RoverLocation roverLocation) {
    roverLocation.setRoverDirection(nextLeftOrientation.get(roverLocation.getRoverDirection()));
    return roverLocation;
  }
}
