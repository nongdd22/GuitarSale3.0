package Guitar.Model;

public class GuitarSpec {
	
	private String builder;
	private String type;
	private String Wood;
	
	public GuitarSpec(){
	}
	
	public GuitarSpec(String builder, String type, String Wood){
		this.builder = builder;
		this.type = type;
		this.Wood = Wood;
	}
	
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWood() {
		return Wood;
	}
	public void setWood(String wood) {
		Wood = wood;
	}

	
}
