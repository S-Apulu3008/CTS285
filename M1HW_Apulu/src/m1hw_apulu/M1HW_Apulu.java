package m1hw_apulu;
import java.util.Scanner;

/*
SA
CTS 285
8.25.2020
Calculator Program

*/
public class M1HW_Apulu {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);//variables
        int op1 = 0,
            op2 = 0,
            sum = 0,
            menuItem;
        boolean replay = true;
        
        do{  
            displayMenu();            //display the menu
            menuItem = getNumber(kb); //get a choice from user
            gotoChoice(menuItem, op1, op2, sum, replay, kb); //switch to user's choice.
            System.out.println(); // newline
        }while(menuItem != 5); //exit loop when user chooses 5.
        
        bye(); //goodbye msg.
    }//end main
    
    public static void displayMenu(){ //Display calculator menu
        System.out.print(""
                + "Welcome to the calculator program.\n"
                + "1. Add\n"
                + "2. Subtract\n"
                + "3. Divide\n"
                + "4. Multiply\n"
                + "5. Exit\n");
    }    
    
    public static void gotoChoice(int menuChoice, int op1, int op2, int sum,
                                  boolean replay, Scanner kb) {
        
        do{
            switch(menuChoice) {
                case 1:
                    add(op1, op2, sum, kb); //user chooses 1
                    replay = replayMenu(replay, kb); //can break loop or repeat
                    break;                           //every case except 5.
                case 2:
                    sub(op1,op2, sum,kb); //2
                    replay = replayMenu(replay, kb);
                    break;
                case 3:
                    div(op1,op2, sum,kb); //3
                    replay = replayMenu(replay, kb);
                    break;
                case 4:
                    mul(op1,op2, sum,kb); //4
                    replay = replayMenu(replay, kb);
                    break;
                case 5:                   //5 to exit.
                    replay = false;       //breaks loop
                    break;
                default:
                    break;
            }//End switch
        }while(replay==true); //end do-while
    }
    
    public static boolean replayMenu(boolean replay, Scanner kb) {
        System.out.println("1. Repeat\n"
                         + "2. Main Menu\n");
        if(getNumber(kb) == 1) {
            replay = true;
        }
        else {
            replay = false;
        }
        return replay;
    }
    
    public static void add(int num1, int num2, int sum, Scanner kb){ //ADD
        System.out.println("Add");
        num1 = getNumber(kb);
        num2 = getNumber(kb);
        sum = num1 + num2;        
        System.out.println(num1 + " + " + num2 + " = " + sum);  
    }
    
    public static void sub(int num1, int num2, int sum, Scanner kb){ //SUBTRACT
        System.out.println("Subtract");
        num1 = getNumber(kb);
        num2 = getNumber(kb);        
        sum = num1 - num2;        
        System.out.println("" + num1 + " - " + num2 + " = " + sum + "");  
    }
    
    public static void div(int num1, int num2, int sum, Scanner kb){ //DIVIDE
        System.out.println("Divide");
        num1 = getNonZero(kb);
        num2 = getNonZero(kb);        
        sum = num1 / num2;        
        System.out.println("" + num1 + " / " + num2 + " = " + sum + "");  
    }
    
    public static void mul(int num1, int num2, int sum, Scanner kb){ //Multiply
        System.out.println("Multiply");
        num1 = getNumber(kb);
        num2 = getNumber(kb);        
        sum = num1 * num2;        
        System.out.println(num1 + " x " + num2 + " = " + sum + "");  
    }
    
    public static int getNumber(Scanner kb) {
        System.out.print("Enter a number: ");
        int num = kb.nextInt();
        return num;        
    }
    
    public static int getNonZero(Scanner kb) {
        System.out.print("Enter a number: ");
        int num = kb.nextInt();
        while(num == 0) {
            System.out.println("Cannot be zero.");
            System.out.print("Enter a number: ");
            num = kb.nextInt();
        }
        return num;        
    }
    
    public static void bye(){
        System.out.println("Goodbye!");
    }
}