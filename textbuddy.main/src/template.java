import java.io.*;
 
class template { // in Mooshak online judge, make sure that Java file name = class name that contains Main method
  
   public static void main(String[] args) {
    IntegerScanner sc = new IntegerScanner(System.in);
    PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out))); // use this (a much faster output routine) instead of Java System.out.println (slow)
    
    int T,N,X,Y;
    T = sc.nextInt();  
    for (int i = 1; i <= T; ++i) {
      N = sc.nextInt();
      X = sc.nextInt();
      Y = sc.nextInt();
      pr.printf("%1.0f\n",subroutine1(N, X, Y));
    }
 
    pr.close(); // do not forget to use this
  }

private static double subroutine1(int n, int x, int y) {
    
    if(n == 1){
        return x;
    }
    return  subroutine2(n, x, y) + subroutine1(n-1, x, y);
    
}

private static double subroutine2(int n, double x, double y) {
    if(n == 1){
        return x;
    }
    return subroutine2(n-1, x, y)+y;
}
}
 
class IntegerScanner { // use this (a much faster input routine) instead of standard Java Scanner class (slow)
  BufferedInputStream bis;
  IntegerScanner(InputStream is) {
    bis = new BufferedInputStream(is, 1000000);
  }
 
  public int nextInt() {   
    int result = 0;
    try {
      int cur = bis.read();
      if(cur == -1)
        return -1;
     
      while(cur < 48 || cur > 57) {
        cur = bis.read();
      }
      while(cur >= 48 && cur <= 57) {
        result = result * 10 + (cur - 48);
        cur = bis.read();
      }
      return result;
    }
    catch(IOException ioe) {
      return -1;
    }
  }
}