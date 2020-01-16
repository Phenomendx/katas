package com.example.roverkata;

import static com.example.roverkata.CompasDirection.NORTH;

import java.util.Collections;
import java.util.List;

public class TestUtility {

  public static Rover givenRoverHasObstacles(List<String> obstacles) {
    return new Rover(obstacles, new RoverLocation(new Position(0, 0), NORTH));
  }

  public static Rover givenInitialRoverLocation(Position position, CompasDirection initialDirection) {
    return new Rover(Collections.emptyList(), new RoverLocation(new Position(0, 0), initialDirection));
  }

}
