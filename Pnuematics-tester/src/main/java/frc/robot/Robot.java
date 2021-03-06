package frc.robot;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

public class Robot extends TimedRobot {

  //XboxController 
  private final XboxController xbox = new XboxController(1); 
  //Pneumatics
  private final Compressor comp = new Compressor(null);
  private final DoubleSolenoid solenoid = new DoubleSolenoid(null, 0, 1); 
  
  //JoyStick
  private Joystick operatorJoystick = new Joystick(2);

  @Override
  public void robotInit() {

    //Pneumatics
     comp.start(); 
    
  }

  @Override
  public void teleopPeriodic() {

    if (xbox.getLeftBumper()) {

      solenoid.set(DoubleSolenoid.Value.kForward); 

     } else if (xbox.getRightBumper()) {

      solenoid.set(DoubleSolenoid.Value.kReverse);
     }

     if (xbox.getYButton()) {

       comp.start(); 

     } else if (xbox.getXButton()) {
      
      comp.stop();

     }

    
     }
  }





