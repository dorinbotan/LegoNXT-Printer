import lejos.nxt.MotorPort;

public class Move
{
   public void PenDown()
   {
      MotorPort.C.controlMotor(60, 2);
      try
      {
         Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
      }
      PenStop();
   }

   public void PenUp()
   {
      MotorPort.C.controlMotor(60, 1);
      try
      {
         Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
      }
      PenStop();
   }
   
   public void PenStop()
   {
      MotorPort.C.controlMotor(100, 3);
      try
      {
         Thread.sleep(100);
      }
      catch (InterruptedException e)
      {
      }
   }

   public void CarriageLeft(int speed)
   {
      MotorPort.A.controlMotor(speed, 2);
   }

   // distance 0-1300
   public void CarriageLeft(int speed, int distance)
         throws InterruptedException
   {
      MotorPort.A.resetTachoCount();

      MotorPort.A.controlMotor(speed, 2);
      while (MotorPort.A.getTachoCount() > -distance)
         Thread.sleep(1);

      CarrigeStop();
   }

   public void CarriageRight(int speed, int distance)
         throws InterruptedException
   {
      MotorPort.A.resetTachoCount();

      MotorPort.A.controlMotor(speed, 1);
      while (MotorPort.A.getTachoCount() < distance)
         Thread.sleep(1);

      CarrigeStop();
   }

   public void CarrigeStop()
   {
      MotorPort.A.controlMotor(100, 3);
      try
      {
         Thread.sleep(100);
      }
      catch (InterruptedException e)
      {
      }
   }

   public void PaperIn(int speed)
   {
      MotorPort.B.controlMotor(speed, 1);
   }

   public void PaperIn(int speed, int distance) throws InterruptedException
   {
      MotorPort.B.resetTachoCount();

      PaperIn(speed);
      while (MotorPort.B.getTachoCount() < distance)
         Thread.sleep(1);

      PaperStop();
   }

   public void PaperOut(int speed)
   {
      MotorPort.B.controlMotor(speed, 2);
   }

   public void PaperOut(int speed, int distance) throws InterruptedException
   {
      MotorPort.B.resetTachoCount();

      PaperOut(speed);
      while (MotorPort.B.getTachoCount() > -distance)
         Thread.sleep(1);

      PaperStop();
   }

   public void PaperStop()
   {
      MotorPort.B.controlMotor(100, 3);
      try
      {
         Thread.sleep(100);
      }
      catch (InterruptedException e)
      {
      }
   }
}