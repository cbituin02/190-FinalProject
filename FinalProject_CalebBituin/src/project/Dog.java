package project;

import java.util.Scanner;
import java.util.Random;

public class Dog {
	
	/*
	 * THIS IS A TEST
	 */
	
	// --------------- FIELDS --------------- //
	private Scanner keyboard;
	private String name;
	private int age;
	
	private int maxTotal = 100;
	private int minTotal = 0;
	
	private static int hunger = 50;
	private int updateHunger;
	private int newHunger;
	private int previousHunger;
	private int resultPlayHunger;
	
	private static int energy = 25;
	private int updateEnergy;
	private int energyIndex;
	private int newEnergy;
	private int previousEnergy;
	private int resultPlayEnergy;
	
	// --------------- CONSTRUCTOR --------------- //
	public Dog(Scanner keyboard) {
		// ask the name of new pet
		System.out.println("What is the name of your new pet?");
		
		// use scanner method to read input
		name = keyboard.nextLine();
		
		// random age in  months
		int[] dogAge = {1, 2, 3, 4};
		
		// random number
		Random random = new Random();
		
		// get random number from the age array
		int randomAgeIndex = random.nextInt(dogAge.length);
		
		// get the random age and set it
		int randomAge = dogAge[randomAgeIndex];
		age = randomAge;
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
		this.updateHunger = hunger;
		
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
		this.updateEnergy = energy;
		
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
			System.out.println("Hunger Level: " + this.updateHunger + ". Energy Level: " + energy);
		}
				
	}
	
	public void feed() {
		// when user clicks feed, hunger will decrease by 15 each click
		// energy will increase by 12
		
		// set updateValues to previous values
		this.updateHunger = hunger;
		this.updateEnergy = energy;
		
		// when feed gets called, decrease hunger by 15 and increase energy by 12
		newHunger = hunger - 15;
		newEnergy = energy + 12;
		
		// set updateValue to new value
		int feedHunger = newHunger;
		this.updateHunger = feedHunger;
		
		int feedEnergy = newEnergy;
		this.updateEnergy = feedEnergy;
		
		System.out.println("you successfully fed " + name + "!");
		
		//setting result variable
		int resultFeedHunger = Math.min(newHunger, maxTotal);
		int resultFeedEnergy = Math.max(newEnergy, minTotal);
		
		if ( feedHunger  >= maxTotal) {
			System.out.println(name + " is too full! YOU NEED TO PLAY WITH IT");
			this.updateHunger = resultFeedHunger;
			this.updateEnergy = energy;
			System.out.println("Hunger Level: " + resultFeedHunger + ". Energy Level: " + this.updateEnergy);
		} else if (feedEnergy <= minTotal) {
			System.out.println(name + " has too much energy! YOU NEED TO PLAY WITH IT");
			this.updateHunger = hunger;
			this.updateEnergy = resultFeedEnergy;
			System.out.println("Hunger Level: " + this.updateHunger + ". Energy Level: " + resultFeedEnergy);
		} else {
			System.out.println("Hunger Level: " + this.updateHunger + ". Energy Level: " + this.updateEnergy);
		}
		
	}
	
	public void sleep() {
		// create random number array or something between 1 and 4
		// when user clicks sleep, it will draw random number
		// random number 1: sleeps for 30 minutes, 2: sleeps for 1 hour, 3: sleeps for 1 hour 30 minutes, 4: sleeps for 2 hours.
		// if 1 is selected: hunger will increase by 10, energy will increase by 10
		// if 2 is selected: hunger will increase by 15, energy will increase by 15
		// if 3 is selected: hunger will increase by 20, energy will increase by 20
		// if 4 is selected: hunger will increase by 25, energy will increase by 25
	}
	
	
	public static void main(String[] args) {
		// Test scanner
		Scanner consoleScanner = new Scanner(System.in);
		Dog test = new Dog(consoleScanner);
		test.dogInfo();
		test.play();
		test.play();
		test.play();
		test.play();
		test.play();
		test.play();
	}

}
