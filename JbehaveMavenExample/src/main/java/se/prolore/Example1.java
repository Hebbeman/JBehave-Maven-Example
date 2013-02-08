package se.prolore;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class Example1 extends JBehaveConfiguration {
	
	private List<Integer> tal; 
	private int sum;
	
	@BeforeScenario
	public void beforeScenario() {
		System.out.println("Setup...");
		tal = new ArrayList<Integer>();
		sum = 0;
	}
	
	@Given("en uppsättning tal: $table")
	public void givenEnUppsattningTal(ExamplesTable table) {
		System.out.println("Listar tal...");
		for (Map<String, String> row: table.getRows()) {
			String entry = row.get("Tal");
			tal.add(Integer.parseInt(entry));
		}
	}

	@When("talen adderas")
	public void whenTalenAdderas() {
		System.out.println("Adderar...");
		for (Integer delTal: tal) {
			sum += delTal;
		}
	}

	@Then("summan blir: $summa")
	public void thenSummanBlir(int summa) {
		System.out.println("Verifierar...");
		assertEquals(summa, sum);
	}

}
