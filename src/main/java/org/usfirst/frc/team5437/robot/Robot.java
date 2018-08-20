
package org.usfirst.frc.team5437.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team5437.robot.subsystems.SwerveDriveBase;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import com.kauailabs.navx.frc.AHRS;







public class Robot extends IterativeRobot {

    public static OI oi;
   
    
    private static AHRS navSensor;
    
    public static SwerveDriveBase swerveBase = new SwerveDriveBase();
    
    public void robotInit() {
        oi = new OI();
       
        
        try {
	         navSensor = new AHRS(SPI.Port.kMXP);
	     } catch (RuntimeException ex ) {
	         DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
	     }
    }

	
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	
	@Override
	public void autonomousInit() {
		
	}

	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
		
	}

	
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

		@Override
	public void testPeriodic() {
		LiveWindow.run();
	}

	public static AHRS getNavSensor() {
		return navSensor;
	}
}
