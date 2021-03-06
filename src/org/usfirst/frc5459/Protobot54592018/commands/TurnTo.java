// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5459.Protobot54592018.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.usfirst.frc5459.Protobot54592018.Robot;
import org.usfirst.frc5459.Protobot54592018.RobotMap;

/**
 *
 */
public class TurnTo  extends PIDCommand {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 double targetTurn;
 double output;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
 public TurnTo(){
     super("TurnTo", 1.0, 0.0, 0.0, 0.02);
     

	 
 }
 public TurnTo(double targetTurn) {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("TurnTo", 1.0, 0.0, 0.0, 0.02);
        getPIDController().setContinuous(true);
        //is this true or false?
        getPIDController().setAbsoluteTolerance(0.2);
        
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        this.targetTurn = targetTurn;
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        requires(Robot.drive);
        requires(Robot.sensors);
        
        //add requires for gyro
        
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    @Override
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
        //return RobotMap
    	//gyro things
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
    	return 0.0 ;//Robot.sensors.getYaw();
    }

    @Override
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	
    	if (targetTurn <= 180 ){
    		RobotMap.driveLeftGroup.set(output);
    		RobotMap.driveRightGroup.set(output*-1);
    	}else{
    		RobotMap.driveLeftGroup.set(output*-1);
    		RobotMap.driveRightGroup.set(output);
    	}
    	
    	//does this go there or in execute?
    		this.output = output;
    	
    	

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
       

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	System.out.println("turnTo initalizing");
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	/*
    	if (targetTurn <= 180 ){
    		RobotMap.driveLeftGroup.set(output);
    		RobotMap.driveRightGroup.set(output*-1);
    	}else{
    		RobotMap.driveLeftGroup.set(output*-1);
    		RobotMap.driveRightGroup.set(output);
    	}*/
    	usePIDOutput(output);
    	System.out.println("turn to executeing");
    	System.out.println("turnTo targetTurn" + targetTurn);
    	System.out.println("turnTo output" + output);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	RobotMap.driveLeftGroup.set(0);
		RobotMap.driveRightGroup.set(0);
		//Robot.sensors.SetYaw(0);
		
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	//Robot.sensors.SetYaw(0);
    }
}
