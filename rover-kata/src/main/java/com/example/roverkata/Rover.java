package com.example.roverkata;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class Rover {

  private RoverLocation roverLocation = new RoverLocation();

  private Consumer<String> executeCommandAndChangeRoverLocation = command ->
      roverLocation = RoverCommandFactory.createRoverCommand(command).execute(roverLocation);

  public String execute(String commands) {

    Stream<String> roverCommands = commands.codePoints()
        .mapToObj(c -> String.valueOf((char) c));

    roverCommands.forEach(executeCommandAndChangeRoverLocation);

    return roverLocation.getLocation();
  }

}


