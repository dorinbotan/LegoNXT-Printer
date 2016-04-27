public class Printer
{
   private final int CARRIAGE_SPEED; 
   private final int PAPER_SPEED;
   private static Move move;
   private static Scanner scanner;
   
   public Printer(int carriageSpeed, int paperSpeed)
   {
      CARRIAGE_SPEED = carriageSpeed;
      PAPER_SPEED = paperSpeed;
      move = new Move();
      scanner = new Scanner();
   }
   
   public void Test() throws InterruptedException
   {
//      move.CarriageLeft(CARRIAGE_SPEED, 1300);
//      move.CarriageRight(CARRIAGE_SPEED, 1300);
      
      move.PaperIn(PAPER_SPEED, 100);
      move.PaperIn(PAPER_SPEED, 1000);
      
      move.PenDown();
      move.PenUp();
      
      move.PaperOut(PAPER_SPEED, 1000);
      
      move.PaperIn(PAPER_SPEED, 1000);
      
      move.CarriageLeft(CARRIAGE_SPEED, 1300);
      move.CarriageRight(CARRIAGE_SPEED, 1300);
      
      move.PenDown();
      
      move.PenUp();
      
      move.PaperOut(PAPER_SPEED, 1000);
   }

   public void DrawLine() throws InterruptedException
   {
      move.PenDown();

      move.CarriageRight(CARRIAGE_SPEED, 4500);

      move.PenUp();
   }

   public void LoadPaper() throws InterruptedException
   {
      move.PaperIn(PAPER_SPEED);

      while (!scanner.PaperIn())
         Thread.sleep(1);

      move.PaperStop();
   }

   public void UnloadPaper() throws InterruptedException
   {
      move.PaperOut(PAPER_SPEED);

      while (scanner.PaperIn())
         Thread.sleep(1);

      Thread.sleep(1000);

      move.PaperStop();
   }

   public void ReturnCarriage() throws InterruptedException
   {
      move.PenUp();

      move.CarriageLeft(CARRIAGE_SPEED);

      while (!scanner.CarriageHome())
         Thread.sleep(1);

      move.CarrigeStop();
   }
}