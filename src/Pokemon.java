import java.util.Random;

class Pokemon{
	static Random rand = new Random();
	int[] moves = {3, 2};
	String name, type;
	int hp;
	int maxhp = 12;
	int attack;
	boolean bol;

	String[] moveName = new String[2];
	int[] movePower = new int[2];

	Pokemon(String name, String type ,int hp){
		this.type = type;
		this.name = name;
		this.hp = hp;
	}

	void hurtWild(Pokemon wild){
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

	void checkType(Pokemon wild, int movePower){
		String message = (bol == true) ? "Very Effective" : "Not Very Effective";

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

		System.out.println(message);
	}

	static Pokemon randomWild(String[] wildNames, String[] wildTypes){
		
		int index = rand.nextInt(0, wildNames.length);
		
		Pokemon wild = new Pokemon(wildNames[index], wildTypes[index], 6);
		
		return wild;
	}

	@Override
	public String toString(){
		return name + ": " + hp + "/" + maxhp + " HP"; 
	}
}
