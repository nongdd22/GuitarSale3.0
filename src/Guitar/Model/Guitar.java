package Guitar.Model;

import Guitar.Model.GuitarSpec;

public class Guitar extends GuitarSpec {
	
	private String ID;
	private String price;
	GuitarSpec spec;
	
	public Guitar(String ID, String price, GuitarSpec spec){
		this.ID = ID;
		this.price = price;
		this.spec = spec;
	}

	public Guitar() {
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public GuitarSpec getSpec() {
		return spec;
	}

	public void setSpec(GuitarSpec spec) {
		this.spec = spec;
	}
	
	
	
}
