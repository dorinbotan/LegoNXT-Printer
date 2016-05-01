import lejos.nxt.MotorPort;

public class Motor
{
   private final int CARRIAGE_SPEED;
   private final int PAPER_SPEED;
   private Scanner scanner;

   public Motor(int carriageSpeed, int paperSpeed)
   {
      CARRIAGE_SPEED = carriageSpeed;
      PAPER_SPEED = paperSpeed;
      scanner = new Scanner();
   }

   public void Up(int distance)
   {
      MotorPort.B.resetTachoCount();
      PaperOut(PAPER_SPEED);
      while (MotorPort.B.getTachoCount() > -distance)
         Sleep(1);
      PaperStop();
   }

   public void Down(int distance)
   {
      MotorPort.B.resetTachoCount();
      PaperIn(PAPER_SPEED);
      while (MotorPort.B.getTachoCount() < distance)
         Sleep(1);
      PaperStop();
   }

   public void Left(int distance)
   {
      MotorPort.A.resetTachoCount();
      CarriageLeft(CARRIAGE_SPEED);
      while (MotorPort.A.getTachoCount() > -distance)
         Sleep(1);
      CarrigeStop();
   }

   public void Right(int distance)
   {
      MotorPort.A.resetTachoCount();
      CarriageRight(CARRIAGE_SPEED);
      while (MotorPort.A.getTachoCount() < distance)
         Sleep(1);
      CarrigeStop();
   }

   public void UpRight(int distance)
   {
      Stop();
      MotorPort.B.resetTachoCount();
      PaperOut(PAPER_SPEED);
      CarriageRight(PAPER_SPEED - 10);
      while (MotorPort.B.getTachoCount() > -distance)
         Sleep(1);
      Stop();
   }

   public void UpLeft(int distance)
   {
      MotorPort.B.resetTachoCount();
      PaperOut(PAPER_SPEED);
      CarriageLeft(PAPER_SPEED - 10);
      while (MotorPort.B.getTachoCount() > -distance)
         Sleep(1);
      Stop();
   }

   public void DownRight(int distance)
   {
      MotorPort.B.resetTachoCount();
      PaperIn(PAPER_SPEED);
      CarriageRight(PAPER_SPEED - 10);
      while (MotorPort.B.getTachoCount() < distance)
         Sleep(1);
      Stop();
   }

   public void DownLeft(int distance)
   {
      MotorPort.B.resetTachoCount();
      PaperIn(PAPER_SPEED);
      CarriageLeft(PAPER_SPEED - 10);
      while (MotorPort.B.getTachoCount() < distance)
         Sleep(1);
      Stop();
   }

   public void LoadPaper()
   {
      PaperIn(PAPER_SPEED);

      while (!scanner.PaperIn())
         Sleep(1);

      PaperStop();
   }

   public void UnloadPaper()
   {
      PaperOut(PAPER_SPEED);

      while (scanner.PaperIn())
         Sleep(1);

      Sleep(2000);

      PaperStop();
   }

   public void ReturnCarriage()
   {
      PenUp();

      CarriageLeft(CARRIAGE_SPEED);

      while (!scanner.CarriageHome())
         Sleep(1);

      CarrigeStop();
   }

   public void PenDown()
   {
      Stop();
      
      MotorPort.C.controlMotor(70, 2);
      Sleep(300);
      Stop();

      MotorPort.C.controlMotor(70, 1);
      Sleep(40);
      Stop();
   }

   public void PenUp()
   {
      MotorPort.C.controlMotor(80, 1);
      Sleep(100);

      PenStop();
   }

   public void PenStop()
   {
      MotorPort.C.controlMotor(100, 3);
      Sleep(100);
   }

   public void CarriageLeft(int speed)
   {
      MotorPort.A.controlMotor(speed, 2);
   }

   public void CarriageRight(int speed)
   {
      MotorPort.A.controlMotor(speed, 1);
   }

   public void CarrigeStop()
   {
      MotorPort.A.controlMotor(100, 3);
      Sleep(100);
   }

   public void PaperIn(int speed)
   {
      MotorPort.B.controlMotor(speed, 1);
   }

   public void PaperOut(int speed)
   {
      MotorPort.B.controlMotor(speed, 2);
   }

   public void PaperStop()
   {
      MotorPort.B.controlMotor(100, 3);
      Sleep(100);
   }

   public void Stop()
   {
      MotorPort.A.controlMotor(100, 3);
      MotorPort.B.controlMotor(100, 3);
      MotorPort.C.controlMotor(100, 3);
      Sleep(100);
   }

   private void Sleep(int millisec)
   {
      try
      {
         Thread.sleep(millisec);
      }
      catch (InterruptedException e)
      {
      }
   }
}