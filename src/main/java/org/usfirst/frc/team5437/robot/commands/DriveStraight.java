/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5437.robot.commands;

import edu.wpi.first.wpilibj.command.WaitCommand;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {
  public DriveStraight() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    
    addSequential(new DriveForTime(1, 0, 0, false, 1));
  
  
  
  
  
  }

  
}
