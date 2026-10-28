class Firepokemon extends Pokemon{
	
	//pano pag wala sa superclass yung moveName staka movePower
	// Bakit hindi gumana kapag merong ganito
	// String[] moveName = new String[2];
	// int[] movePower = new String[2];
	Firepokemon(){
		super("Charmander", "Fire",12);
		this.moveName[0] = "Ember";
		this.moveName[1] = "Scratch";
		this.movePower[0] = 3;
		this.movePower[1] = 2;
	}

}
