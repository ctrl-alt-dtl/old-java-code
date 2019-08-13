import java.util.Scanner;


/**
 * @author D. Tyler Long
 * CMIS 242
 * Dec 2, 2011
 *
 */
public class MultiRecurseIt {

static int multiIt;
static int result;
static int numA;
static int numB;

public static void multiIterative(int numA, int numB){
    while(multiIt < numB){
        result += numA;
        multiIt++;
        }
        System.out.println("Iterative: " + result);
}

public static int multiRecursive(int numA, int numB){
        if(numB == 0){ //Return if basecase is 0
            return 0;
        }else{
            //Recursive functions
            return multiRecursive(numA, numB-1) + numA; 
        }
}
public static void main(String[] args) {
    System.out.println("ITERATIVE & RECURSIVE CALCULATOR:\n" +
        "By: Ty Long \nCMIS 242\nDec 2, 2011\n\n" +
        "***************************************************\n" +
        "**  This program will calculate the iterative    **\n" +
        "**  and recursive multiplication of two numbers. **\n" +
        "**  The results will be displayed below.         **\n" +
        "**  See FINAL NOTES in the program comments.     **\n" +   
        "***************************************************\n");
    boolean mainCheck = true;
    while(mainCheck == true){
        
    Scanner input = new Scanner(System.in);
    boolean valid = false;
    while(!valid){ //Loop till user inputs correct integer value
            try{
                System.out.print("Enter in the first integer: ");
                int a = Integer.parseInt(input.nextLine()); //verify int input
                if (a >= 0){
                valid = true; //continue to next loop
                numA = a;
                }else{
                    System.out.println("Negative number. Please enter again.");
                }
            }catch (Exception e){
                System.out.print("Incorrect integer entry, try again: ");
                System.out.println();
            }
        }
    valid = false;
    System.out.println();
    while(!valid){ //Loop till user inputs correct integer value
    try{
        System.out.print("Enter in the second integer: ");
        
        int b = Integer.parseInt(input.nextLine());
        if (b >= 0){
        valid = true; //continue to method calculations
        numB = b;
        }else{
            System.out.println("Negative number. Please enter again.");
        }
    }catch (Exception e){
        System.out.print("Incorrect integer entry, try again: ");
        System.out.println();
    }
}
            System.out.println("\nResults: ");
            multiIterative(numA, numB);
            System.out.println("Recursive: " + multiRecursive(numA, numB));
            
            System.out.println();
            //Display full amount of memory at Runtime
            System.out.println("Max Memory at Runtime: " + 
                    Runtime.getRuntime().maxMemory());
            //Reloop main method till exit
            System.out.print("\n\nDo you want to start again? (Y/N): ");
            char response = input.nextLine().charAt(0);
            
            if(response == 'n' || response == 'N'){ 
                mainCheck = false;
                System.out.println("\nExiting Program...\n");
            }else{
                System.out.println("\nRestarting...\n");
            }

    /*
     * Notes:
     * 
     * Will work:
     * 100 X 100 = 10000
     * 1000 X 1000 = 1000000
     * 10000 X 10000 = 100000000
     * 
     * Won't work:
     * 20000 X 20000 Fail on Recursive
     * 40000 X 40000 Fail on Recursive
     * Reason: The error lies in the recursion function. Since the integers
     * are calculated over and over again in a recursive fashion the amount
     * memory required takes is extensive. So much that it causes a stack 
     * overflow. I've tried running a stack trace on NetBeans & Eclipse and 
     * around the 18,976 run of the recursive function the heap becomes 
     * overflowed and then errors out the remainder 1,024 runs. As you can see 
     * during the normal runtime max memory is 129,957,888 bytes (123 Mb) and 
     * since the size of an integer is 4 bytes the calculation of 20000 X 20000
     * takes over 1525 Mb for the calculations. The stack heap grows up and
     * the integers that are stored in memory fill up that stack till it runs
     * of room and eventually overwrites the memory return jump to the
     * beginning of the program which causes the stack to be corrupted,
     * therefore causing the program to crash.
     * ~Ty
     */
		
    }	
}
}