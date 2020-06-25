import annotations.Autowired;
import annotations.Component;

@Component
public class TestComponent3 {

	@Autowired
	private TestComponent1 c1;

	@Autowired
	private TestComponent2 c2;

	public TestComponent1 getC1() {
		return c1;
	}

	public void setC1(TestComponent1 c1) {
		this.c1 = c1;
	}

	public TestComponent2 getC2() {
		return c2;
	}

	public void setC2(TestComponent2 c2) {
		this.c2 = c2;
	}

	@Override
	public String toString() {
		return String.format("TestComponent3 [c1=%s, c2=%s]", c1, c2);
	}

	
	
}
