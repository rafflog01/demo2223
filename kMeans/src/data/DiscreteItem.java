package data;
class DiscreteItem extends Item {
	public String value;
	//Metodi
	
	//Invoca costruttore superclasse
	DiscreteItem(DiscreteAttribute attribute, String value) {
		super(attribute, value);
	}
	@Override
	double distance(Object a) {
		if (getValue().equals(a)) {
			return 0;
		}
	return 1;
	}
	}
