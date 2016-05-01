PImage img;
PrintWriter output;

void setup() {
  size(140,140);
  img = loadImage( "st1.jpg" );
  output = createWriter("st1.rtf"); 
}

void draw() {
  loadPixels();
  
  for (int y = 0; y < img.height; y++ ) {
    output.println("{");
    for (int x = 0; x < img.width; x++ ) {
      
      // Calculate the 1D pixel location
      int loc = y + x*img.height;
      
      // Get the R,G,B values from image
      float r = red (img.pixels[loc]);
      float g = green (img.pixels[loc]);
      float b = blue (img.pixels[loc]);
      
      if (r > 128 && g > 128 && b > 128) 
        {
          stroke(255, 255, 255);
          output.print("false,");  
        }
      else 
        {
          stroke(0, 0, 0);
          output.print("true,");  
        }
      point(x, y);    
    }
    output.println("},");
  }
  output.flush(); // Writes the remaining data to the file
  output.close(); // Finishes the file
  exit(); // Stops the program
}