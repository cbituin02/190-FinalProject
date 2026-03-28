package project;

import java.util.Scanner;
import java.util.Random;
/*
 * TO DO:
 * ORGANIZE CODE LIKE THE PLAY METHOD
 * (HUNGER WITH HUNGER)
 * (ENERGY WITH ENERGY)
 */
public class Bird extends Dog{

	// --------------- FIELDS --------------- //
	private Scanner keyboard;
	private String name;
	private int age;
	
	private int maxTotal = 50;
	private int minTotal = 0;
	
	private int[] birdHunger = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	private int[] feedHunger = {12, 9, 5, 20, 7, 18, 14};
	private static int hunger = 25;
	private int updateHunger;
	
	private int[] birdEnergy = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	private int[] feedEnergy = {10, 18, 13, 8, 9, 15, 25};
	private static int energy = 25;
	private int updateEnergy;
	private int energyIndex;
	
	private int[] sleep = {30, 45, 60, 75};
	private int[] sleepValue = {0, 5, 10, 15};
	private int sleepIndex;
	
	// --------------- CONSTRUCTOR --------------- //
	public Bird(Scanner keyboard) {
		// ask the name of new pet
		System.out.println("What is the name of your new bird?");
		
		// use scanner method to read input
		name = keyboard.nextLine();
		
		// random age in  months
		int[] birdAge = {1, 2, 3, 4};
		
		// random number
		Random randomAge = new Random();
		
		// get random number from the age array
		int randomAgeIndex = randomAge.nextInt(birdAge.length);
		
		// get the random age and set it
		int randomAgeValue = birdAge[randomAgeIndex];
		age = randomAgeValue;
		
		System.out.println("Welcome " + name + " at the young age of " + age + " months, to your new home!");
		
	}
	
	// --------------- METHODS --------------- //
	public void play() {
		
		// --------------- HUNGER --------------- //
		//setting result variable
		int previousHungerResultMax = Math.min(hunger, maxTotal);
		int previousHungerResultMin = Math.max(hunger, minTotal);
		
		// create random hunger array
		//int[] birdHunger = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		
		// make new random variable
		Random randomPlay = new Random();
		
		// get random number from the hunger array
		int randomHungerIndex = randomPlay.nextInt(birdHunger.length);
		
		//get the random hunger and set it
		int randomHunger = birdHunger[randomHungerIndex];
		
		// set update value to default
		if (hunger >= maxTotal) {
			hunger = previousHungerResultMax;
			this.updateHunger = hunger;
		} else if (hunger <= minTotal) {
			hunger = previousHungerResultMin;
			this.updateHunger = hunger;
		} else {
			this.updateHunger = hunger;
		}
		
		// set previous to old value
		int previousHunger = this.updateHunger;
		
		// set updateValue to a new value
		int newHunger = randomHunger + hunger;
		this.updateHunger = newHunger; 
		
		// set default hunger value to the new value
		hunger = newHunger;
		
		//setting result variable
		int resultPlayHunger = Math.min(newHunger, maxTotal);
		
		// --------------- ENERGY --------------- //
		//setting result variable
		int previousEnergyResultMax = Math.min(energy, maxTotal);
		int previousEnergyResultMin = Math.max(energy, minTotal);
		
		// create energy array
		//int[] birdEnergy = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		
		// let
		if (randomHunger == birdHunger[0]) {
			energyIndex = birdEnergy[0];
		} else if ( randomHunger == birdHunger[1]) {
			energyIndex = birdEnergy[1];
		} else if ( randomHunger == birdHunger[2]) {
			energyIndex = birdEnergy[2];
		} else if ( randomHunger == birdHunger[3]) {
			energyIndex = birdEnergy[3];
		} else if ( randomHunger == birdHunger[4]) {
			energyIndex = birdEnergy[4];
		} else if ( randomHunger == birdHunger[5]) {
			energyIndex = birdEnergy[5];
		} else if ( randomHunger == birdHunger[6]) {
			energyIndex = birdEnergy[6];
		} else if ( randomHunger == birdHunger[7]) {
			energyIndex = birdEnergy[7];
		} else if ( randomHunger == birdHunger[8]) {
			energyIndex = birdEnergy[8];
		} else if ( randomHunger == birdHunger[9]) {
			energyIndex = birdEnergy[9];
		} else if ( randomHunger == birdHunger[10]) {
			energyIndex = birdEnergy[10];
		} else if ( randomHunger == birdHunger[11]) {
			energyIndex = birdEnergy[11];
		}
			
		// set the updateValue to default
		if (energy <= minTotal) {
			energy = previousEnergyResultMin;
			this.updateEnergy = energy;
		} else if (energy >= maxTotal) {
			energy = previousEnergyResultMax;
			this.updateEnergy = energy;
		} else {
			this.updateEnergy = energy;
		}
		
		// previous value
		int previousEnergy = this.updateEnergy;
		
		// set the updateValue to a new value
		int newEnergy = energy - energyIndex;
		this.updateEnergy = newEnergy;
		
		// set default hunger value to the new value
		energy = newEnergy;
		
		//setting result variable
		int resultPlayEnergy = Math.max(newEnergy, minTotal);
		
		// if hunger levels reach 100 or energy reaches 0, stop updating hunger and energy, tell the user to feed their pet
		if ( hunger  >= maxTotal) {
			System.out.println(name + " is starving! YOU NEED TO FEED IT");
			// set updateHunger to maxTotal
			this.updateHunger = resultPlayHunger;
			// set energy to previous value so it doesn't update
			energy = previousEnergy;
			System.out.println("Hunger Level: " + this.updateHunger + ". Energy Level: " + previousEnergy);
		} else if (energy <= minTotal) {
			System.out.println(name + " is out of energy! YOU NEED TO FEED IT");
			// set hunger to previous value to it doesn't update
			hunger = previousHunger;
			// set energy to minTotal
			this.updateEnergy = resultPlayEnergy;
			System.out.println("Hunger Level: " + previousHunger + ". Energy Level: " + this.updateEnergy);
		} else {
			// output that states "play" has been called
			System.out.println("You successfully played with " + name + "!");
			System.out.println("Hunger Level: " + hunger + ". Energy Level: " + energy);
		}
	}
	
	public void feed() {
		
		// --------------- HUNGER --------------- //
		//setting result variable
		int previousHungerResultMax = Math.min(hunger, maxTotal);
		int previousHungerResultMin = Math.max(hunger, minTotal);
		
		// create random hunger array
		//int[] feedHunger = {12, 9, 5, 20, 7, 18, 14};
		
		// create random object
		Random randomFeedHunger = new Random();
		
		// create variable that grabs a random # from the feed array
		int randomFeedHungerIndex = randomFeedHunger.nextInt(feedHunger.length);
		
		// create variable to equal the value of random #
		int randomFeedHungerValue = feedHunger[randomFeedHungerIndex];
		
		// if previous values = maxTotal, set previous values to maxTotal, otherwise set previous values
		if (hunger >= maxTotal) {
			hunger = previousHungerResultMax;
			this.updateHunger = hunger;
		} else if (hunger <= minTotal) {
			hunger = previousHungerResultMin;
			this.updateHunger = hunger;
		} else {
			this.updateHunger = hunger;
		}
		
		// create a variable that holds the previous value
		int previousHunger = this.updateHunger;
		
		// when feed gets called, decrease hunger by random #
		int feedHungerCalc = hunger - randomFeedHungerValue;
		
		// set updateValues to new values
		int newHunger = feedHungerCalc;
		this.updateHunger = newHunger;
				
		//setting result variable
		int resultFeedHunger = Math.max(newHunger, minTotal);
		
		// update default values to new values
		hunger = newHunger;
		
		// --------------- ENERGY --------------- //
		//setting result variable
		int previousEnergyResultMax = Math.min(energy, maxTotal);
		int previousEnergyResultMin = Math.max(energy, minTotal);
		
		// create random energy array
		//int[] feedEnergy = {10, 18, 13, 8, 9, 15, 25};
		
		// create random object
		Random randomFeedEnergy = new Random();
		
		// create variable that grabs a random # from the feedEnergy array
		int randomFeedEnergyIndex = randomFeedEnergy.nextInt(feedEnergy.length);
		
		// set variable to equal the value of the random #
		int randomFeedEnergyValue = feedEnergy[randomFeedEnergyIndex];
		
		// if previous values = minTotal, set previous values to minTotal, otherwise set previous values
		if (energy <= minTotal) {
			energy = previousEnergyResultMin;
			this.updateEnergy = energy;
		} else if (energy >= maxTotal) {
			energy = previousEnergyResultMax;
			this.updateEnergy = energy;
		} else {
			this.updateEnergy = energy;
		}
		
		// create a variable that holds the previous value
		int previousEnergy = this.updateEnergy;
		
		// when feed gets called, decrease hunger and increase energy
		int newEnergyCalc = energy + randomFeedEnergyValue;
		
		// set updateValues to new values
		int newEnergy = newEnergyCalc;
		this.updateEnergy = newEnergy;
		
		// update default values to new values
		energy = newEnergy;
		
		//setting result variable
		int resultFeedEnergy = Math.min(newEnergy, maxTotal);
		
		
		// if values hit maxTotal or minTotal, don't update any values, otherwise update values
		if ( hunger <= minTotal) {
			System.out.println(name + " is too full! YOU NEED TO PLAY WITH IT");
			// set hunger to minTotal
			this.updateHunger = resultFeedHunger;
			// set energy to previous value so it won't update
			energy = previousEnergy;
			System.out.println("Hunger Level: " + this.updateHunger + ". Energy Level: " + previousEnergy);
		} else if (energy >= maxTotal) {
			System.out.println(name + " has too much energy! YOU NEED TO PLAY WITH IT");
			// set hunger to previous value so it won't update
			hunger = previousHunger;
			// set energy to maxTotal
			this.updateEnergy = resultFeedEnergy;
			System.out.println("Hunger Level: " + previousHunger + ". Energy Level: " + this.updateEnergy);
		} else {
			System.out.println("you successfully fed " + name + "!");
			System.out.println("Hunger Level: " + hunger + ". Energy Level: " + energy);
		}
	}
	
	public void sleep() {
		
		// create sleep array and call a random # from the array
		// value is sleep in minutes
		//int[] sleep = {30, 45, 60, 75};
		
		// create random object
		Random randomSleep = new Random();
		
		// create variable that grabs random # from the array
		int randomSleepIndex = randomSleep.nextInt(sleep.length);

		// set a variable to equal the random # that was called
		int randomSleepTime = sleep[randomSleepIndex];
		
		// create sleepValues array
		//int[] sleepValue = {0, 5, 10, 15};
		
		// set values so both array equal and call the same position
		if (randomSleepTime == sleep[0]) {
			sleepIndex = sleepValue[0];
		} else if (randomSleepTime == sleep[1]) {
			sleepIndex = sleepValue[1];
		} else if (randomSleepTime == sleep[2]) {
			sleepIndex = sleepValue[2];
		} else if (randomSleepTime == sleep[3]) {
			sleepIndex = sleepValue[3];
		}
		
		// --------------- HUNGER --------------- //
		//setting result variable
		int previousHungerResultMax = Math.min(hunger, maxTotal);
		int previousHungerResultMin = Math.max(hunger, minTotal);
		
		if (hunger >= maxTotal) {
			hunger = previousHungerResultMax;
			this.updateHunger = hunger;
		} else if (hunger <= minTotal) {
			hunger = previousHungerResultMin;
			this.updateHunger = hunger;
		} else {
			this.updateHunger = hunger;
		}
		
		// set previous to old value
		int previousHunger = this.updateHunger;
				
		// set updateValue to a new value
		int newHunger = sleepIndex + hunger;
		this.updateHunger = newHunger; 
				
		// set default hunger value to the new value
		hunger = newHunger;
		
		//setting result variable
		int resultSleepHunger = Math.min(newHunger, maxTotal);
		
		// --------------- ENERGY --------------- //
		//setting result variable
		int previousEnergyResultMax = Math.min(energy, maxTotal);
		int previousEnergyResultMin = Math.max(energy, minTotal);
		if (energy <= minTotal) {
			energy = previousEnergyResultMin;
			this.updateEnergy = energy;
		} else if (energy >= maxTotal) {
			energy = previousEnergyResultMax;
			this.updateEnergy = energy;
		} else {
			this.updateEnergy = energy;
		}
		
		// previous value
		int previousEnergy = this.updateEnergy;
				
		// set the updateValue to a new value
		int newEnergy = sleepIndex + energy;
		this.updateEnergy = newEnergy;
		
		// set default hunger value to the new value
		energy = newEnergy;
				
		//setting result variable
		int resultSleepEnergy = Math.min(newEnergy, maxTotal);
		
		// if hunger levels reach 100 or energy reaches 100, stop updating hunger and energy,
		// tell the user to feed or play with their pet
		if ( hunger  >= maxTotal) {
			System.out.println(name + " is starving! YOU NEED TO FEED IT");
			// set updateHunger to maxTotal
			this.updateHunger = resultSleepHunger;
			// set energy to previous value so it doesn't update
			energy = previousEnergy;
			System.out.println("Hunger Level: " + this.updateHunger + ". Energy Level: " + previousEnergy);
		} else if (energy >= maxTotal) {
			System.out.println(name + " is has too much energy! YOU NEED TO PLAY WITH IT");
			// set hunger to previous value to it doesn't update
			hunger = previousHunger;
			// set energy to maxTotal
			this.updateEnergy = resultSleepEnergy;
			System.out.println("Hunger Level: " + previousHunger + ". Energy Level: " + this.updateEnergy);
		} else {
			// output that states "sleep" has been called
			System.out.println("You successfully put " + name + " to sleep for " + randomSleepTime + " minutes");
			System.out.println("Hunger Level: " + hunger + ". Energy Level: " + energy);
		}
	}
	
	/*
	 * MAYBE:
	 * LET USER TYPE NAME OF NEW DOG
	 * CREATE NEW OBJECT OF DOG WITH THE NAME THE USER TYPED
	 * LET THE USER TYPE PLAY, FEED, OR SLEEP TO CALL THE RESPECTIVE METHODS.
	 * IF USER WANTS TO QUIT THEY CAN TYPE ABANDON.
	 * 
	 * FIX COMMENTS OF CODE
	 * 
	 * COPY PASTE CODE FOR CAT AND BIRD CLASS
	 * CHANGE VALUES
	 */
	public static void main(String[] args) {
		// Test scanner
		Scanner consoleScanner = new Scanner(System.in);
		Bird test = new Bird(consoleScanner);
		test.play();
		test.feed();
		test.sleep();
	}

}