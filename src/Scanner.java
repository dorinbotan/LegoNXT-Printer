import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class Scanner
{
   private LightSensor lightSensor;
   private TouchSensor touchSensor;

   public Scanner()
   {
      lightSensor = new LightSensor(SensorPort.S3);
      lightSensor.setFloodlight(false);

      touchSensor = new TouchSensor(SensorPort.S1);
   }

   public boolean PaperIn()
   {
      return lightSensor.getLightValue() < 20;
   }

   public boolean CarriageHome()
   {
      return touchSensor.isPressed();
   }
}