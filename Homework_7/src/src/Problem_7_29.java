
/* Problem 7.29
 * Introduction to Java Programming, 10th Ed. 
 * by Y Daniel Liang
 * 
 * (Game: pick four cards) Write a program that picks four cards from a 
 * deck of 52 cards and computes their sum. An Ace, King, Queen, and Jack 
 * represent 1, 13, 12, and 11, respectively. Your program should display 
 * the number of picks that yields the sum of 24.
 */

package src;

import java.util.Scanner;

public class Problem_7_29 {
	// The key to the battleship
	public static void main(String[] args) {
		int tracker = 0;
		String again = null;
		Scanner input = new Scanner(System.in);
		// Ask if user wants to play
		System.out.println("The game is to draw four random cards, " + 
				"which total 24.\nDo you want to play? ");
		String toPlay = input.next();
		// Verify user provides valid input
		while (!(toPlay.equalsIgnoreCase("yes") || 
				toPlay.equalsIgnoreCase("no"))) {
			// prompt user to make a valid selection
			 System.out.println("Error, please enter a valid " +
				"selection...");
			 toPlay = input.next(); // this line advances the scanner
		}
		if (toPlay.equalsIgnoreCase("yes")) {
			if (pickFourCards() == 24) {
				System.out.println("Lucky day! You got 24 on your " +
						"first draw!");
				tracker++; // keep track of sets summing to 24
			} else {
				System.out.println("Better luck next time.");
			}
			// allow user to play multiple times
			do {
				Scanner input2 = new Scanner(System.in);
				System.out.println("\nDo you want to try again? ");
				String toPlayAgain = input2.next();
				// verify user provides valid input
				while (!(toPlayAgain.equalsIgnoreCase("yes") || 
						toPlayAgain.equalsIgnoreCase("no"))) {
					// prompt user to make a valid selection
					 System.out.println("Error, please enter a valid " +
						"selection...");
					 // this line advances the scanner
					 toPlayAgain = input2.next();
				}
				// leave the loop if user is finished
				if (toPlayAgain.equalsIgnoreCase("no")) {
					System.out.println("Thanks for playing.");
					break;
				}
				if (pickFourCards() == 24) {
					tracker++; // advances the set tracker
				} 
				// let user know how many times a set has been drawn
				// that totals 24
				if (tracker == 0) {
					System.out.println("You have yet to get 24.");
				} else if (tracker == 1) {
					System.out.println("You've gotten 24 " + tracker +
							" time.");
				} else {
					System.out.println("You've gotten 24 " + tracker +
							" times.");
				}
				again = toPlayAgain;
			} while (again.equalsIgnoreCase("yes"));
		} else { // let user know that they should not have wasted
			// your time by not even playing
			System.out.println("Thanks for wasting my time.");
		}
	}
	// Custom method for picking four cards at random
	// Got this code from listing 7.2 in the book
	private static int pickFourCards() {
		int[] deck = new int[52];
		String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
		String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "Jack", "Queen", "King"};
		// Initialize the cards
		for (int i = 0; i < deck.length; i++) {
			deck[i] = i;
		}
		// Shuffle the cards
		for (int i = 0; i < deck.length; i++) {
			// Generate an index randomly
			int index = (int) (Math.random() * deck.length);
			int temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}
		// Sum and display first four cards
		System.out.println("You drew the following cards: ");
		int sumOfCards = 0;
		for (int i = 0; i < 4; i++) {
			String suit = suits[deck[i] / 13];
			String rank = ranks[deck[i] % 13];
			sumOfCards += (deck[i] % 13) + 1;
			System.out.println(rank + " of " + suit);
		}
		System.out.println("\nYour total is " + sumOfCards);
		return sumOfCards;
	}
}
