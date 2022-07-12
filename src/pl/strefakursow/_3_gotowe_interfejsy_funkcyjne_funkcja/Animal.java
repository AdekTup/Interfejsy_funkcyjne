package pl.strefakursow._3_gotowe_interfejsy_funkcyjne_funkcja;

public class Animal {

	private String name;
	private Species species;

	public Animal(String name, Species species) {
		this.name = name;
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	@Override
	public String toString() {
		return "Animal{" +
			"name='" + name + '\'' +
			", species=" + species +
			'}';
	}
}
