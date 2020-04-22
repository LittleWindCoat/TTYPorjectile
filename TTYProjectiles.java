import java.util.Scanner;
import java.util.Random;

/*Name: LWC
 *Project 1: TTY Projectiles
 *I did not collaborate with anyone on this project.
 */

public class TTYProjectiles {
	public static void main(String[] args) {

		//Introduction 
		Scanner scanner = new Scanner(System.in );
		System.out.println("Hello buddy :) , welcome to the TTY Projectile Game!");
		System.out.println("Do you know the meaning of projectile? Enter 1 for yes or 2 for no.");
		double yesOrNo = scanner.nextInt();
		if (yesOrNo == 1) {
			System.out.println("Perfect!");
		}
		else if (yesOrNo == 2) {
			System.out.println("Please look it up online!");
		}
		System.out.println("Enter your name if this is the first time you play TTY Projectile.");
		//Asking for the user's name
		String name = scanner.next();

		//More directions and description
		System.out.println("");
		System.out.println("In this game, you have a catapult that can launch projectile towards a target.");
		System.out.println("");
		System.out.println("I will set a target and the target will not change until you hit the target.");
		System.out.println("");
		System.out.println("In oder to hit the target, you need to guess for the launch angle and speed.");
		System.out.println("");

		//tracking of the user’s score
		int points = 0;
		System.out.println("You will start the game with 0 point! You will get 10 point for hitting the target and lose 1 or 2 or 3 point for missing. Readey? Go!");
		System.out.println("");

		//create random target and set the limits of the target
		Random random = new Random ();
		int targetDistance = random.nextInt(124) + 1;

		//Create loop for the game
		while (true) {
			System.out.println("Now please set the launch angle!");
			//Way to quiet the game.
			System.out.println("Enter 0 for launch angle if you want to quit the game.");
			double launchAngle = scanner.nextInt();
			if (launchAngle == 0) {
				//The game continues through successive rounds until the user quits.
				System.out.println("Thanks for playing! " + name + ", Your score is " + points + " Hope you enjoyed the game!");
				break;
			}
			System.out.println("Please set the speed!");
			double v = scanner.nextInt();
			double gravity = 9.8;
			double g = gravity;
			double d = (Math.pow (v,2)*(Math.sin (2*launchAngle)))/(g);
			System.out.println("According to the launch angle and speed you set, the distance traveled is " + d + ".");

			double distanceTotheTarget = (d - targetDistance);

			//Within 1m of the target
			if (distanceTotheTarget <= 1 && distanceTotheTarget >= -1) {
				System.out.println("You get a direct hit! You are awesome! You get 10 points");
				points = points + 10;
				System.out.println("Great! You have " + points + " points now! ");
				targetDistance = random.nextInt(124) + 1;
				System.out.println("Next round! Target has changed!");
			}
			//Within 3m of the target
			else if (distanceTotheTarget <= 3 && distanceTotheTarget >= -3 ) {
				System.out.println("Near miss! You get 1 point. Try again! ");
				points = points + 1;
				System.out.println("You have " + points + " points now! ");
			}
			//More than 3m short of the target
			else if (distanceTotheTarget < -3 && distanceTotheTarget > -6) {
				System.out.println("Fell short! You lose 1 point. Try again!");
				points = points - 1;
				System.out.println("You have " + points + " points now! ");
			}
			//More then 3m beyond the target
			else if (distanceTotheTarget > 3 && distanceTotheTarget < 6) {	
				System.out.println("Went long! You lose 2 point. Try again!");
				points = points - 2;
				System.out.println("You have " + points + " points now! ");
			}	
			//Adding conditions
			else if (distanceTotheTarget < -6) {
				System.out.println("Fell too short! You lose 3 points! Try hard!");
				points = points - 3;
				System.out.println("You have " + points + " points now! ");
			}
			//Adding conditions
			else if (distanceTotheTarget > 6) {
				System.out.println("Went too long! You lose 3 points!");
				points = points - 3;
				System.out.println("You have " + points + " points now! ");
			}
		}	
	}
}
