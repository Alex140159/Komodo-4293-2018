// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package commands.teleop;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import robot.Robot;
import subsystems.DriveSystem;

/**
 *
 */
public class TeleopDriveCommand extends Command {
	private DriveSystem driveSystem;
	private DifferentialDrive robotDrive;
	private Joystick leftJoystick;
	private Joystick rightJoystick;
	
    public TeleopDriveCommand() {
        requires(Robot.driveSystem);
        
        driveSystem = Robot.driveSystem;
        robotDrive = Robot.driveSystem.getDrive();
        
        leftJoystick = Robot.oi.getLeftJoystick();
        rightJoystick = Robot.oi.getRightJoystick();
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	switch (driveSystem.getDriveType()) {
    	case TANK:
			robotDrive.tankDrive(leftJoystick.getY(), rightJoystick.getY());
    	case ARCADE_1:
			robotDrive.arcadeDrive(leftJoystick.getY(), leftJoystick.getX());
    	case ARCADE_2:
			robotDrive.arcadeDrive(leftJoystick.getY(), rightJoystick.getX());
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}