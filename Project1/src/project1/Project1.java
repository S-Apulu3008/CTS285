package project1;
import java.util.Scanner;
import java.util.Random;

public class Project1 {
    
    public static void showHand(int[] hand) {
        for(int i = 0; i < hand.length; ++i) {
            System.out.print(hand[i] + " ");
        }
        System.out.println();
    }
    
    public static void sleeveCard(int[] sleeve, Scanner scnr) {
        int card = 0;
        for(int i = 0; i < sleeve.length; ++i) {
            while(card < 1 || card > 10){            
                System.out.print("Pick a card(1-10) to sleeve? ");
                card = scnr.nextInt();
            }
            sleeve[i] = card;
            showSleeve(sleeve);
        }
    }
    
    public static void showSleeve(int[] sleeve) {
        System.out.print("Sleeved card: ");
        for(int i = 0; i < sleeve.length; ++i) {
            System.out.print(sleeve[i] + " ");
        }
    }

    public static void deal(int[] deck, int[] dealer, int[] player, int handSize) {
        Random rnd = new Random();
        int card;
        for(int i = 0; i < handSize; ++i) {
            for(int j = 0; j < handSize; ++j) {
                card = rnd.nextInt(40);
                player[j] = deck[card];
                ++i;
                card = rnd.nextInt(40);
                dealer[j] = deck[card];
                ++i;
            }
        }
        System.out.print("Player: ");
        showHand(player);
        System.out.print("Dealer: ");
        showHand(dealer);
    }
    public static void main(String[] args) {
        final int sleeveSize = 1;
        final int handSize = 2;
        Scanner scnr = new Scanner(System.in);
        
        int[] deck = {1,1,1,1,
                      2,2,2,2,
                      3,3,3,3,
                      4,4,4,4,
                      5,5,5,5,
                      6,6,6,6,
                      7,7,7,7,
                      8,8,8,8,
                      9,9,9,9,
                      10,10,10,10}; //custom deck.
        
        int[] sleeve = new int[sleeveSize];
        int[] playerHand =  new int[handSize];
        int[] cpuHand =  new int[handSize];
        sleeveCard(sleeve, scnr);
        //deal(deck, cpuHand, playerHand, handSize);
        
        
        
        
    }    
}
