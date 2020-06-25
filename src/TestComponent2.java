import annotations.Component;

@Component
public class TestComponent2 {

	private String name = "comp2";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("TestComponent2 [name=%s]", name);
	}
	
	
}
