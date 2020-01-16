package com.example.roverkata;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Rover {

  private StringBuilder lastOutPutOfRover = new StringBuilder("");

  private RoverLocation roverLocation;

  private Optional<List<String>> obstacles;

  private Consumer<String> executeCommandAndChangeRoverLocation = command ->
      roverLocation = RoverCommandFactory.createRoverCommand(command).execute(roverLocation);

  public Rover(List<String> obstacleList, RoverLocation roverLocation) {
    this.obstacles = Optional.of(obstacleList);
    this.roverLocation = roverLocation;
  }

  public String execute(String commands) {
    lastOutPutOfRover.delete(0, lastOutPutOfRover.length());

    Stream<String> roverCommands = commands.codePoints()
        .mapToObj(c -> String.valueOf((char) c));

    roverCommands.
        takeWhile(this::hasNoObstacleForNextMove).
        forEach(executeCommandAndChangeRoverLocation);

    lastOutPutOfRover.append(roverLocation.getLocation());

    return lastOutPutOfRover.toString();
  }

  private boolean hasNoObstacleForNextMove(String command) {
    RoverLocation clonedRoverLocation = new RoverLocation(roverLocation);

    MoveCommand moveCommand = new MoveCommand();
    RoverLocation nextRoverLocation = moveCommand.execute(clonedRoverLocation);

    //TODO: Violation of SRP
    if(obstacles.orElse(Collections.emptyList()).contains(nextRoverLocation.getLocation())) {
      lastOutPutOfRover.append("0:");
    }

    return !obstacles.orElse(Collections.emptyList()).contains(nextRoverLocation.getLocation());
  }
}


