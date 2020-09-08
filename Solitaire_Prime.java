import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Solitaire_Prime {
	public static class Card{
		private char rank;
		private char suit;
		
		public Card(char r, char s) {
			suit = s;
			rank = r;
		}
		public void display() {
			
			System.out.printf("%c%c", rank, suit);
		}
		public int getValue() {
			if (rank == 'A') {
				return 1;
			}else if (rank == 'J'|| rank == 'Q'|| rank == 'K'|| rank == 'T') {
				return 10;
			}else {
				return Integer.parseInt(String.valueOf(rank));
			}
		}
	}
	
	public static class Deck{
		private ArrayList<Card> storage;
		
		
		public Deck() {
			char [] suits = {'H', 'D', 'S', 'C'};
			char [] ranks = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
			storage = new ArrayList<Card>();
			
			Card C1;
			for(int s = 0; s<suits.length;s++)
			for(int r = 0; r<ranks.length; r++) {
				C1 = new Card(ranks[r], suits[s]);
				storage.add(C1);
			}
		
		}
		public void display() {
			int i = 0;
			for(int row = 0; row<4; row++) {
				for(int col = 0; col<13; col++) {
					storage.get(i).display();
					System.out.print(" ");
					i++;
				}
				System.out.println();
			}
		}
		public void shuffle() {
			Random rand = new Random();
			
			for(int i = 0; i < 10000; i++) {
				int x = rand.nextInt(52);
				int y = rand.nextInt(52);
				Card temp = storage.get(x);
				storage.set(x, storage.get(y));
				storage.set(y, temp);
			}
		}
		public Card deal() {
			ArrayList<Card> pile = new ArrayList<Card>();
			Card dealtCard = storage.get(0);
			pile.add(dealtCard);
			storage.remove(0);
			return dealtCard;
		}
		/*public int cardsLeft() {
			
		}*/
	}

	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		Deck myDeck = new Deck();
		int option = menu();
		Card C;
		while (option !=5) {
			if(option == 1) {
				System.out.println("New Deck is created!");
				myDeck = new Deck();
			}else if (option == 2) {
				myDeck.display();
			}else if (option == 3) {
				myDeck.shuffle();
			}else if (option == 4) {
				System.out.println("Play Solitaire");
				int sum = 0;
				int pile = 0;
				for (int x=0; x<52; x++) {
					C = myDeck.deal();
					C.display();
					System.out.print("  ");
					sum = sum + C.getValue();
					if (isPrime(sum)) {
						System.out.println("PRIME:" + sum);
						sum = 0;
						pile++;
					}
				}if (sum==0) {
					System.out.println("\n!!!!!!!!!WINNER!!!!!!!!!");
					System.out.println("You have won in " + pile + " piles!");
				}else {
					System.out.println("\nWhat A LOSER");
				}
			}else {
				System.out.println("Invalid input, try again");
			}
			System.out.println();
			option = menu();
		}
		if(option ==5) {
			System.out.println("Bye! Play again next time!");
		}

	}
	
	public static int menu() {
		System.out.println("Welcome to Solitaire Prime!");
		System.out.println("1. New Deck");
		System.out.println("2. Display Deck");
		System.out.println("3. Shuffle Deck");
		System.out.println("4. Play Solitaire Prime");
		System.out.println("5. Exit");
		int option = in.nextInt();
		return option;
	}
	public static boolean isPrime(int x) {
		boolean prime = true;
		if (x%2 == 0 ||x%3 ==0||x%5==0||x%7==0||x==1) {
			prime = false;
			
		}
		else if (x==2||x==3||x==5||x==7) {
			prime = true;
			
		}
		return prime;
	}

}
