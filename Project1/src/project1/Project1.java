package project1;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

/*
S A
CTS 285
Project 1
Card Dealer

*/

public class Project1 {
    
    public static void showHand(ArrayList<String> hand) {
        for(int i = 0; i < hand.size(); ++i) {
            System.out.print(hand.get(i) + " ");
        }
        System.out.println();
    }
    
    public static void showTable(ArrayList<String> hand) {
        System.out.print("Table: ");
        for(int i = 0; i < hand.size(); ++i) {
            System.out.print(hand.get(i) + " ");
        }
        System.out.println();
    }
    
    public static void showSleeve(ArrayList<String> sleeve) {
        System.out.print("Sleeved card: ");
        for(int i = 0; i < sleeve.size(); ++i) {
            System.out.print(sleeve.get(i) + " ");
        }
        System.out.println();
    }
    
    public static void dealTableCards(ArrayList<String> deck) {
        ArrayList<String> table = new ArrayList<>(); //table cards
        String card;
        deck.remove(0);
        for(int i = 0; i < 3; ++i) { //Flop
            card = deck.get(0);
            deck.remove(0);
            table.add(card);
        }
        for(int i = 0; i < 2; ++i) { //Turn and River.
            deck.remove(0);
            card = deck.get(0);
            table.add(card);
            deck.remove(0);
        }
        
        showTable(table);
    }

    public static void deal(ArrayList<String> deck,
                            ArrayList<String> player,
                            ArrayList<String> dealer,
                            int handSize) {
        
        String plucked, card2;
        
        for(int i = 0; i < handSize; ++i) {
            plucked = deck.get(0); //take from top of the deck
            deck.remove(0); //remove card from top of deck
            player.add(plucked); //place in player's hand
             
            plucked = deck.get(0); //tale card from top of the deck
            deck.remove(0); //remove card from top of the deck
            dealer.add(plucked); //place in dealer's hand.          
        }               
    }
    
    public static void createDeck(ArrayList<String> deck) {
            //diamonds
            deck.add("K♦");
            deck.add("Q♦");
            deck.add("J♦");
            deck.add("10♦");
            deck.add("9♦");
            deck.add("8♦");
            deck.add("7♦");
            deck.add("6♦");
            deck.add("5♦");
            deck.add("4♦");
            deck.add("3♦");
            deck.add("2♦");
            deck.add("A♦");
            //hearts
            deck.add("K♥");
            deck.add("Q♥");
            deck.add("J♥");
            deck.add("10♥");
            deck.add("9♥");
            deck.add("8♥");
            deck.add("7♥");
            deck.add("6♥");
            deck.add("5♥");
            deck.add("4♥");
            deck.add("3♥");
            deck.add("2♥");
            deck.add("A♥");
            //clubs
            deck.add("K♣");
            deck.add("Q♣");
            deck.add("J♣");
            deck.add("10♣");
            deck.add("9♣");
            deck.add("8♣");
            deck.add("7♣");
            deck.add("6♣");
            deck.add("5♣");
            deck.add("4♣");
            deck.add("3♣");
            deck.add("2♣");
            deck.add("A♣");
            //spades
            deck.add("K♠");
            deck.add("Q♠");
            deck.add("J♠");
            deck.add("10♠");
            deck.add("9♠");
            deck.add("8♠");
            deck.add("7♠");
            deck.add("6♠");
            deck.add("5♠");
            deck.add("4♠");
            deck.add("3♠");
            deck.add("2♠");
            deck.add("A♠");        
    }
    
    public static void showBothHands(ArrayList<String> player, 
                                     ArrayList<String> cpu) {
        System.out.print("Player's hand: ");
        showHand(player);
        System.out.print("Dealer's hand: ");
        showHand(cpu);
    }
    
    public static void main(String[] args) {
        final int SLEEVE_SIZE = 1,//how many cards player can sleeve.
                  HAND_SIZE = 2; //how many cards to deal to each player  
        
        Scanner scnr = new Scanner(System.in);             
        
        ArrayList<String> deck = new ArrayList<>(); //for deck of cards.
        createDeck(deck); //create a deck of playing cards.
        
        ArrayList<String> player = new ArrayList<>(); //the player's hand
        ArrayList<String> sleeve = new ArrayList<>(); //the player's sleeve.
        
        ArrayList<String> cpu = new ArrayList<>(); //the cpu's hand.

        deal(deck,player,cpu,HAND_SIZE); //deal the cards        
        showBothHands(player,cpu); //show hands
        
        dealTableCards(deck); //deal flop, turn and river cards.
    }    
}
