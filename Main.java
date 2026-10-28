import java.util.Scanner;

class Main{
	
	static Scanner sml = new Scanner(System.in);

	static String[] starterNames = {"Charmander", "Squirtle", "Bulbasaur"};
	static String[] starterTypes = {"Fire", "Water", "Grass"};
	static String[] wildNames = {"Vulpix", "Growlithe", "Psyduck", "Poliwag", "Oddish", "Bellsprout"};
	static String[] wildTypes = {"Fire", "Fire", "Water", "Water", "Grass", "Grass"};

	public static void main(String[] args){
		System.out.println(""" 
				Pokemon Arena
				-------------
				[1] Play
				[2] Quit""");
		System.out.print(": ");
		int ano = Integer.parseInt(sml.nextLine());

		switch (ano){
			case 1: 
				playGame();
				break;
			case 2: 
				System.out.println("\nBoom");
				return;
			default:
				System.out.println("\nWhat the helly bananini");
				return;
		}

	}

	static void playGame(){
		Trainer trainer = new Trainer("Ash");
		trainer.chooseStarter(starterNames, starterTypes);
		
		while (trainer.starter.hp > 0){
			Pokemon wild = Pokemon.randomWild(wildNames, wildTypes);
			battle(trainer, wild);
		}
	}

	static void battle(Trainer trainer, Pokemon wild){
		trainer.seeWild(wild);

		while (wild.hp > 0 && trainer.starter.hp > 0){
			trainer.playerTurn(wild);
			return;
			/*
			if (trainer.start.hp > 0){
				trainer.winBattle(wild);
			}
			*/
		}

	}
}
