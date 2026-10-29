import java.util.Random;

class Pokemon{
	static Random rand = new Random();
	int[] moves = {3, 2};
	String name, type;
	int hp;
	int maxhp = 12;
	int attack;
    int wildDamage;
	boolean bol;

	String[] moveName = new String[2];
	int[] movePower = new int[2];

	Pokemon(String name, String type ,int hp){
		this.type = type;
		this.name = name;
		this.hp = hp;
	}

    Pokemon(String name, String type, int hp, int wildDamage){
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.wildDamage = wildDamage;
    }

	void playerTurn(Pokemon wild){
            for (int q = 0; q < moveName.length; q++){
                System.out.printf("[%d] %s: %d Power\n", q, moveName[q], movePower[q]);
            }

            System.out.print(": ");
            int attackIndex = Integer.parseInt(Main.sml.nextLine());

            if (attackIndex < moveName.length){
                System.out.println(name + " used " + moveName[attackIndex]);
                attack = movePower[attackIndex];
                checkType(wild, attack);
            }

            System.out.println(wild.name + ": " + wild.hp + " HP");
	}
    
    void wildTurn(Trainer trainer){
            
            String question = "";
            int answer = 0;

            int ano1 = rand.nextInt(0, 100);
            int ano2 = rand.nextInt(0, 100);

            int ano3 = rand.nextInt(0, 10);
            int ano4 = rand.nextInt(0, 10);
            
            if (this.type.equals("Fire")){
                question = ano1 + " + " + ano2 + "? ";
                answer = ano1 + ano2;
            }
            else if (this.type.equals("Water")){
                question = ano1 + " - " + ano2 + "? "; 
                answer = ano1 - ano2;
            }
            
            else if (this.type.equals("Grass")){
                question = ano3 + " * " + ano4 + "? "; 
                answer = ano3 * ano4;
            }

            System.out.printf("\n--- %s's Turn---\n", name);
            System.out.printf("%s asks: what is %s\n", name, question);
            
            System.out.print(": ");
            int answerMo = Integer.parseInt(Main.sml.nextLine());
            
            if (answerMo != answer){
                System.out.println("Wrong! The answer is " + answer);
                System.out.printf("%s attacks %s for %d Damage\n", name, trainer.starter.name, wildDamage);
                
                trainer.starter.hp -= wildDamage;
                System.out.printf("%s has %d HP left\n", trainer.starter.name, trainer.starter.hp);
            }
            else{
                System.out.println("\nCorrect!");
            }

    }

	void checkType(Pokemon wild, int movePower){

		if (type.equals("Fire")){
			if (wild.type.equals("Water")){
				bol = false;
				wild.hp -= 1;

			}

			else if (wild.type.equals("Grass")){
				bol = true;
				wild.hp -= movePower;
			}

			else{
				wild.hp -= movePower;
			}
		}

		else if (type.equals("Water")){
			if (wild.type.equals("Grass")){
				bol = false;
				wild.hp -= 1;

			}

			else if (wild.type.equals("Fire")){
				bol = true;
				wild.hp -= movePower;
			}

			else{
				wild.hp -= movePower;
			}
		}
		
        else if (type.equals("Grass")){
			if (wild.type.equals("Fire")){
				bol = false;
				wild.hp -= 1;

			}

			else if (wild.type.equals("Water")){
				bol = true;
				wild.hp -= movePower;
			}

			else{
				wild.hp -= movePower;
			}
		}
		String message = (bol == true) ? "Very Effective" : "Not Very Effective";
		System.out.println(message);
	}

	static Pokemon randomWild(String[] wildNames, String[] wildTypes){
		
		int index = rand.nextInt(0, wildNames.length);
		
		Pokemon wild = new Pokemon(wildNames[index], wildTypes[index], 6, 2);
		
		return wild;
	}

	@Override
	public String toString(){
		return name + ": " + hp + "/" + maxhp + " HP"; 
	}
}
