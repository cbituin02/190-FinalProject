package project;

import java.util.Scanner;
import java.util.Random;
/*
 * TO DO:
 * ORGANIZE CODE LIKE THE PLAY METHOD
 * (HUNGER WITH HUNGER)
 * (ENERGY WITH ENERGY)
 */
public class Dog {

	// --------------- FIELDS --------------- //
	private Scanner keyboard;
	private String name;
	private int age;
	
	private int maxTotal = 100;
	private int minTotal = 0;
	
	private static int hunger = 50;
	private int updateHunger;
	
	private static int energy = 50;
	private int updateEnergy;
	private int energyIndex;
	
	private int sleepIndex;
	
	// --------------- CONSTRUCTOR --------------- //
	public Dog(Scanner keyboard) {
		// ask the name of new pet
		System.out.println("What is the name of your new pet?");
		
		// use scanner method to read input
		name = keyboard.nextLine();
		
		// random age in  months
		int[] dogAge = {1, 2, 3, 4};
		
		// random number
		Random randomAge = new Random();
		
		// get random number from the age array
		int randomAgeIndex = randomAge.nextInt(dogAge.length);
		
		// get the random age and set it
		int randomAgeValue = dogAge[randomAgeIndex];
		age = randomAgeValue;
	}
	
	// --------------- METHODS --------------- //
	public void dogInfo() {
		System.out.println("Welcome " + name + " at the young age of " + age + " months, to your new home!");
	}

	public void play() {
		
		// --------------- HUNGER --------------- //
		// create random hunger array
		int[] dogHunger = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		
		// make new random variable
		Random randomPlay = new Random();
		
		// get random number from the hunger array
		int randomHungerIndex = randomPlay.nextInt(dogHunger.length);
		
		//get the random hunger and set it
		int randomHunger = dogHunger[randomHungerIndex];
		
		// set update value to default
		if (hunger >= maxTotal) {
			hunger = maxTotal;
			this.updateHunger = hunger;
		} else if (hunger <= minTotal) {
			hunger = minTotal;
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
		
		// --------------- ENERGY --------------- //
		
		// create energy array
		int[] dogEnergy = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		
		// let
		if (randomHunger == dogHunger[0]) {
			energyIndex = dogEnergy[0];
		} else if ( randomHunger == dogHunger[1]) {
			energyIndex = dogEnergy[1];
		} else if ( randomHunger == dogHunger[2]) {
			energyIndex = dogEnergy[2];
		} else if ( randomHunger == dogHunger[3]) {
			energyIndex = dogEnergy[3];
		} else if ( randomHunger == dogHunger[4]) {
			energyIndex = dogEnergy[4];
		} else if ( randomHunger == dogHunger[5]) {
			energyIndex = dogEnergy[5];
		} else if ( randomHunger == dogHunger[6]) {
			energyIndex = dogEnergy[6];
		} else if ( randomHunger == dogHunger[7]) {
			energyIndex = dogEnergy[7];
		} else if ( randomHunger == dogHunger[8]) {
			energyIndex = dogEnergy[8];
		} else if ( randomHunger == dogHunger[9]) {
			energyIndex = dogEnergy[9];
		} else if ( randomHunger == dogHunger[10]) {
			energyIndex = dogEnergy[10];
		} else if ( randomHunger == dogHunger[11]) {
			energyIndex = dogEnergy[11];
		}
			
		// set the updateValue to default
		if (energy <= minTotal) {
			energy = minTotal;
			this.updateEnergy = energy;
		} else if (energy >= maxTotal) {
			energy = maxTotal;
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
		
		// output that states "play" has been called
		System.out.println("You successfully played with " + name + "!");
		
		//setting result variable
		int resultPlayHunger = Math.min(newHunger, maxTotal);
		int resultPlayEnergy = Math.max(newEnergy, minTotal);
		
		// if hunger levels reach 100 or energy reaches 0, stop updating hunger and energy, tell the user to feed their pet
		if ( newHunger  >= maxTotal) {
			System.out.println(name + " is starving! YOU NEED TO FEED IT");
			// set updateHunger to maxTotal
			this.updateHunger = resultPlayHunger;
			// set energy to previous value so it doesn't update
			energy = previousEnergy;
			System.out.println("Hunger Level: " + this.updateHunger + ". Energy Level: " + previousEnergy);
		} else if (newEnergy <= minTotal) {
			System.out.println(name + " is out of energy! YOU NEED TO FEED IT");
			// set hunger to previous value to it doesn't update
			hunger = previousHunger;
			// set energy to minTotal
			this.updateEnergy = resultPlayEnergy;
			System.out.println("Hunger Level: " + previousHunger + ". Energy Level: " + this.updateEnergy);
		} else {
			System.out.println("Hunger Level: " + hunger + ". Energy Level: " + energy);
		}
	}
	
	public void feed() {
		
		// --------------- HUNGER --------------- //

		// create random hunger array
		int[] feedHunger = {12, 9, 5, 20, 7, 18, 14};
		
		// create random object
		Random randomFeedHunger = new Random();
		
		// create variable that grabs a random # from the feed array
		int randomFeedHungerIndex = randomFeedHunger.nextInt(feedHunger.length);
		
		// create variable to equal the value of random #
		int randomFeedHungerValue = feedHunger[randomFeedHungerIndex];
		
		// if previous values = maxTotal, set previous values to maxTotal, otherwise set previous values
		if (hunger >= maxTotal) {
			hunger = maxTotal;
			this.updateHunger = hunger;
		} else if (hunger <= minTotal) {
			hunger = minTotal;
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

		// create random energy array
		int[] feedEnergy = {10, 18, 13, 8, 9, 15, 25};
		
		// create random object
		Random randomFeedEnergy = new Random();
		
		// create variable that grabs a random # from the feedEnergy array
		int randomFeedEnergyIndex = randomFeedEnergy.nextInt(feedEnergy.length);
		
		// set variable to equal the value of the random #
		int randomFeedEnergyValue = feedEnergy[randomFeedEnergyIndex];
		
		// if previous values = minTotal, set previous values to minTotal, otherwise set previous values
		if (energy <= minTotal) {
			energy = minTotal;
			this.updateEnergy = energy;
		} else if (energy >= maxTotal) {
			energy = maxTotal;
			this.updateEnergy = energy;
		} else {
			this.updateEnergy = energy;
		}
		
		// create a variable that holds the previous value
		int previousEnergy = this.updateEnergy;
		
		// when feed gets called, decrease hunger by 15 and increase energy by 12
		int newEnergyCalc = energy + randomFeedEnergyValue;
		
		// set updateValues to new values
		int newEnergy = newEnergyCalc;
		this.updateEnergy = newEnergy;
		
		// update default values to new values
		energy = newEnergy;
		
		System.out.println("you successfully fed " + name + "!");
		
		//setting result variable
		int resultFeedEnergy = Math.min(newEnergy, maxTotal);
		
		
		// if values hit maxTotal or minTotal, don't update any values, otherwise update values
		if ( newHunger <= minTotal) {
			System.out.println(name + " is too full! YOU NEED TO PLAY WITH IT");
			// set hunger to minTotal
			this.updateHunger = resultFeedHunger;
			// set energy to previous value so it won't update
			energy = previousEnergy;
			System.out.println("Hunger Level: " + this.updateHunger + ". Energy Level: " + previousEnergy);
		} else if (newEnergy >= maxTotal) {
			System.out.println(name + " has too much energy! YOU NEED TO PLAY WITH IT");
			// set hunger to previous value so it won't update
			hunger = previousHunger;
			// set energy to maxTotal
			this.updateEnergy = resultFeedEnergy;
			System.out.println("Hunger Level: " + previousHunger + ". Energy Level: " + this.updateEnergy);
		} else {
			System.out.println("Hunger Level: " + hunger + ". Energy Level: " + energy);
		}
	}
	
	public void sleep() {
		
		// create sleep array and call a random # from the array
		// value is sleep in minutes
		int[] sleep = {30, 45, 60, 75};
		
		// create random object
		Random randomSleep = new Random();
		
		// create variable that grabs random # from the array
		int randomSleepIndex = randomSleep.nextInt(sleep.length);

		// set a variable to equal the random # that was called
		int randomSleepTime = sleep[randomSleepIndex];
		
		// create sleepValues array
		int[] sleepValue = {10, 15, 20, 25};
		


		// if 30 is selected: hunger will increase by 10, energy will increase by 10
		// if 45 is selected: hunger will increase by 15, energy will increase by 15
		// if 60 is selected: hunger will increase by 20, energy will increase by 20
		// if 75 is selected: hunger will increase by 25, energy will increase by 25
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
		// if hunger is less than minTotal, set to minTotal
		// if hunger is more than maxTotal, set to maxTotal
		// otherwise set updateValue to previous values
		if (hunger >= maxTotal) {
			hunger = maxTotal;
			this.updateHunger = hunger;
		} else if (hunger <= minTotal) {
			hunger = minTotal;
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
		// if energy is less than minTotal, set to minTotal
		// if energy is more than maxTotal, set to maxTotal
		// otherwise set updateValue to previous values
		if (energy <= minTotal) {
			energy = minTotal;
			this.updateEnergy = energy;
		} else if (energy >= maxTotal) {
			energy = maxTotal;
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
		
		// output that states "play" has been called
		System.out.println("You successfully put " + name + " to sleep for " + sleepIndex + " minutes");
				
		//setting result variable
		int resultSleepEnergy = Math.min(newEnergy, maxTotal);
		
		// if hunger levels reach 100 or energy reaches 100, stop updating hunger and energy,
		// tell the user to feed or play with their pet
		if ( newHunger  >= maxTotal) {
			System.out.println(name + " is starving! YOU NEED TO FEED IT");
			// set updateHunger to maxTotal
			this.updateHunger = resultSleepHunger;
			// set energy to previous value so it doesn't update
			energy = previousEnergy;
			System.out.println("Hunger Level: " + this.updateHunger + ". Energy Level: " + previousEnergy);
		} else if (newEnergy >= maxTotal) {
			System.out.println(name + " is has too much energy! YOU NEED TO PLAY WITH IT");
			// set hunger to previous value to it doesn't update
			hunger = previousHunger;
			// set energy to maxTotal
			this.updateEnergy = resultSleepEnergy;
			System.out.println("Hunger Level: " + previousHunger + ". Energy Level: " + this.updateEnergy);
		} else {
			System.out.println("Hunger Level: " + hunger + ". Energy Level: " + energy);
		}
	}
	
	/*
	 * FIX:
	 * !! IF HUNGER OR ENERGY ARE AT MAX, AND YOU CALL A DIFFERENT METHOD THAN THE METHOD THAT WAS JUST !!
	 * !!           USED, IT STILL UPDATES THE VALUE (HUNGER OR ENERGY) THAT ISN'T AT MAX               !!
	 * 
	 * 						!! METHODS SHOULD NOT BE ALLOWED TO UPDATE VALUES IF !!
	 * 						!! EITHER HUNGER OR ENERGY ARE AT MAX OR MIN VALUES  !!
	 * 
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
		Dog test = new Dog(consoleScanner);
		test.dogInfo();
		test.play();
		test.sleep();
		test.sleep();
		test.sleep();
		test.sleep();
		test.sleep();
		test.feed();
		test.feed();
		test.play();
	}

}
