/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5437.robot.commands;

import org.usfirst.frc.team5437.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForTime extends Command {

  private double speed;
  private double angle;
  private double rotMot;
  private boolean fieldOriented;

  public DriveForTime(double speed, double angle, double rotMot, double time) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.swerveBase);
    this.speed = speed;
    this.angle = angle;
    this.rotMot = rotMot;
    this.fieldOriented = fieldOriented;
    setTimeout(time);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.swerveBase.polarSwerveDrive(speed, angle, rotMot, fieldOriented);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.swerveBase.polarSwerveDrive(0, 0, 0, false);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
