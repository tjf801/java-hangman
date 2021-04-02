import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//the list of words (copy/pasted from original)
		String[] words = {"Bacon", "Pancakes", "nuclear", "eggs", "taco", "burrito", "mustang", "charger", "camaro", "bronco"};
		
		//the word, as a char[]
		char[] wordAsCharArray = words[(int)(Math.random()*words.length)].toCharArray();
		
		// gets the word into a Character List
		List<Character> word = new ArrayList<Character>();
		for (Character c : wordAsCharArray) word.add(Character.toUpperCase(c));
		
		// the amount of failed guesses
		int tries = 0;
		// the list of already guessed letters
		Set<Character> guessedLetters = new HashSet<Character>();
		
		while (tries < 4) {
			// prints out the hang man ascii
			printHangMan(tries);
			
			//prints out the current known parts of the word
			System.out.print("current word guess: ");
			printWord(word, guessedLetters);
			
			// check if the player won by seeing if all letters in the word were guessed already
			boolean won = true;
			for (Character letter : word) {
				if (!guessedLetters.contains(letter)) won = false;
			}
			
			// if the player has won, exit the loop
			if (won) break;
			
			// the next character in the stream
			Character guess = null;
			// repeats until you put in a new letter
			while (true) {
				// gets first letter of entered line
				guess = Character.toUpperCase(scanner.next().charAt(0));
				//if it's not already guessed, then use it, otherwise, get another guess
				if (guessedLetters.contains(guess)) {
					System.out.println("you have already guessed '" + guess + "'!");
				} else {
					break;
				}
			}
			
			// hmm yes clearing the screen
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			
			// adds the letter to the set of guessed letters
			guessedLetters.add(guess);
			
			if (word.contains(guess)) {
				// go back to the top of the loop
				continue;
			} else {
				// increment the amount of failed tries
				tries++;
			}
		}
		
		// checks if you have lost
		if (tries == 4) {
			//prints out final losing info
			printHangMan(4);
			System.out.print("current word guess: ");
			printWord(word, guessedLetters);
			//prints out what the answer was
			System.out.println("the word was: " + new String(wordAsCharArray));
		} else {
			System.out.println("you won!");
		}
		
		scanner.close();
	}
	
	// a function to print out the word with the guessed letters filled in.
	public static void printWord(List<Character> word, Set<Character> guessedLetters) {
		// for each character in the word...
		for (Character c : word) {
			// if the letter was guessed, print it
			if (guessedLetters.contains(Character.toUpperCase(c))) System.out.print(c); 
			
			// otherwise leave it as a blank
			else System.out.print('_');
		}
		// just ends the line
		System.out.println();
	}
	
	// a function to print the given hang man stage
	public static void printHangMan(int count) {
		// (copy/pasted from original)
		if (count == 0) {
            System.out.println("   ____________");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
		} else if (count == 1) {
            System.out.println("Try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |        /   \\ ");
            System.out.println("   |        |     |");
            System.out.println("   |        \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
		} else if (count == 2) {
            System.out.println("Try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |        /   \\ ");
            System.out.println("   |        |     |");
            System.out.println("   |        \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        } else if (count == 3) {
            System.out.println("You have one more try");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |        /   \\ ");
            System.out.println("   |        |     |");
            System.out.println("   |        \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |         / \\ ");
            System.out.println("___|___     /   \\ ");
        } else if (count == 4) {
            System.out.println("GAME OVER!");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\ ");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |          _|_");
            System.out.println("   |        / | \\ ");
            System.out.println("   |         / \\ ");
            System.out.println("___|___     /   \\ ");
        }
	}
}
