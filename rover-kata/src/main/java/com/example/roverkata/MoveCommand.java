package com.example.roverkata;

import static com.example.roverkata.CompasDirection.EAST;
import static com.example.roverkata.CompasDirection.NORTH;
import static com.example.roverkata.CompasDirection.SOUTH;
import static com.example.roverkata.CompasDirection.WEST;

import java.util.Map;
import java.util.function.Consumer;

public class MoveCommand extends RoverCommand {

  private Map<CompasDirection, Consumer<RoverLocation>> roverMovements =
      Map.of(
          NORTH, this::moveToNorth,
          EAST, this::moveToEast,
          SOUTH, this::moveToSouth,
          WEST, this::moveToWest
      );


  @Override
  public RoverLocation execute(RoverLocation roverLocation) {

    final Consumer<RoverLocation> roverMovement = roverMovements
        .getOrDefault(roverLocation.getRoverDirection(), this::noMovement);

    // execute the movement command
    roverMovement.accept(roverLocation);

    return roverLocation;
  }

  private void noMovement(RoverLocation roverLocation) {
  }

  private void moveToEast(RoverLocation roverLocation) {
    roverLocation.advanceOnEast();
  }

  private void moveToNorth(RoverLocation roverLocation) {
    roverLocation.advanceOnNorth();
  }

  private void moveToSouth(RoverLocation roverLocation) {
    roverLocation.advanceOnSouth();
  }

  private void moveToWest(RoverLocation roverLocation) {
    roverLocation.advanceOnWest();
  }
}
