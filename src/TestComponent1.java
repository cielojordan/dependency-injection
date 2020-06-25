import annotations.Component;

@Component
public class TestComponent1 {

	private String name = "comp1";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("TestComponent1 [name=%s]", name);
	}
	
	
}
