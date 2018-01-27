// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import robot.RobotMap;
import commands.teleop.*;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;


/**
 *
 */
public class DriveSystem extends Subsystem {
    private SpeedController leftTalon1;
    private SpeedControllerGroup leftTalons;
    private SpeedController rightTalon1;
    private SpeedControllerGroup rightTalons;
    private DifferentialDrive robotDrive;
    
    private DriveType driveType;
    
    private AutoController autoController;
    
    public DriveSystem() {
    	leftTalon1 = new Talon(RobotMap.leftTalon1Port);
        leftTalon1.setInverted(false);
    	((Sendable)leftTalon1).setName("DriveSystem", "Left Talon 1");
        leftTalons = new SpeedControllerGroup(leftTalon1);
        
        rightTalon1 = new Talon(RobotMap.rightTalon1Port);
        rightTalon1.setInverted(false);
    	((Sendable)rightTalon1).setName("DriveSystem", "Right Talon 1");
        rightTalons = new SpeedControllerGroup(rightTalon1);
        
        robotDrive = new DifferentialDrive(leftTalons, rightTalons);
        
        robotDrive.setSafetyEnabled(false);
        robotDrive.setExpiration(0.1);
        robotDrive.setMaxOutput(1.0);
        
        driveType = DriveType.TANK;
        
        autoController = new AutoController(this);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TeleopDriveCommand());
    }
  
    @Override
    public void periodic() {
    	autoController.update();
    }
    
    public DifferentialDrive getDrive() {
    	return robotDrive;
    }
    
    public DriveType getDriveType() {
    	return driveType;
    }
    
    public void setDriveType(DriveType newType) {
    	driveType = newType;
    }
    
    public AutoController getAutoController() {
    	return autoController;
    }
    
}
