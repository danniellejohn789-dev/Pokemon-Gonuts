class Trainer{
	int wins, hp;
	String name;
	Pokemon starter;

	Pokemon[] poks = {new Firepokemon(), new Waterpokemon(), new Grasspokemon()};
	
	Trainer(String name){
		this.name = name;
	}
	
	void chooseStarter(String[] names, String[] types){
		System.out.println("Choose a Starter");
		
		for (int q = 0; q < names.length; q++){
			System.out.printf("[%d] %s (%s)\n", q, names[q], types[q]);
		}
		System.out.print("\n: ");
		int ano = Integer.parseInt(Main.sml.nextLine());
		
		starter = poks[ano];
		
		System.out.println("Ash choose " + starter.name);
		System.out.println(starter);
	}

	void seeWild(Pokemon wild){
		System.out.printf("\nA wild %s (%s) appeared!\n%s: %d HP\n", wild.name, wild.type, wild.name, wild.hp);
	}

	void playerTurn(Pokemon wild){
		System.out.printf("\n--- %s's Turn (%s %d HP)---\n", name, starter.name, starter.hp);
		System.out.println("Choose a move:");
		
		/*	
		for (int q = 0; q < starter.moveName.length; q++){
			System.out.printf("[%d] %s: %d Power\n", q, starter.moveName[q], starter.movePower[q]);
		}
		*/

		starter.playerTurn(wild);
	}
    
    void winBattle(Pokemon wild){
        if (wild.hp <= 0){
            wins += 1;
            System.out.println(wild.name + " Faints");
            System.out.println("Game over: " + wins);
        }
    }

}
