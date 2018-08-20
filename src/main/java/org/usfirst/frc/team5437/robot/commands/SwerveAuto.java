/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5437.robot.commands;

import org.usfirst.frc.team5437.robot.Robot;
import edu.wpi.first.wpilibj.Utility;

import edu.wpi.first.wpilibj.command.Command;

public class SwerveAuto extends Command {
    
    private double angle;
    private double speed;
    private double rotMot;
    private boolean fieldOriented;
    private long commandStartedAt;
    private double runTime;
  
  
  public SwerveAuto() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.swerveBase);
    this.angle = angle;
    this.speed = speed;
    this.rotMot = rotMot;
    this.fieldOriented = fieldOriented;
    this.runTime = runTime; //in seconds
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    commandStartedAt = Utility.getFPGATime();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.swerveBase.polarSwerveDrive(angle, speed, rotMot, fieldOriented);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Utility.getFPGATime() > (runTime*1000000 + commandStartedAt);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    commandStartedAt = 0;
    Robot.swerveBase.swerveDrive(0, 0, 0, false);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
