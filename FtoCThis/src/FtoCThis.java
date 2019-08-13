
package ftocthis;

 import java.util.Scanner;

public class FtoCThis {
      Scanner input = new Scanner(System.in);
      double fahrenheit = 0.0;
      double celsius = 0.0;

      FtoCThis(){

      }

      FtoCThis(double fahrenheit, double celsius){
          this.fahrenheit = fahrenheit;
          this.celsius = celsius;
      }

public double getCelsius(){
    System.out.print("Enter in Temperature: ");
    fahrenheit = input.nextDouble();
    return ((5.0/9.0)*(fahrenheit-32));
    }

public static FtoCThis[] createFTCArray(){
    FtoCThis[] ftcArray = new FtoCThis[5];

    for(int i=0; i<ftcArray.length; i++){
        ftcArray[i] = new FtoCThis();
    }
    return ftcArray;
}
public static void printFTCArray(FtoCThis[] ftcArray){
    for(int i=0; i<ftcArray.length; i++)
    System.out.println("Celsius is " + ftcArray[i].getCelsius()+ "\u00B0" + "C.");
}

public static void main(String[] args) {

        FtoCThis FtoCOnly1 = new FtoCThis();
        System.out.println("Celsius is " + FtoCOnly1.getCelsius() + "*C");
        System.out.println("\n\n");
        System.out.println("Now in an Array...\n");
        System.out.println("As you enter in a Temperature the array will automatically convert to ");
        System.out.println("Celsius and immediately display it.\n\n");

        FtoCThis[] ftcArray;

        ftcArray = createFTCArray();

        printFTCArray(ftcArray);

    }

}
