package se.prolore;

import static se.prolore.CustomVerification.compareChannels;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class Example2 extends JBehaveConfiguration {
	
	private CustomerHelper customerHelper = new CustomerHelper();
	private WebServiceFacade fasad = new WebServiceFacade();
	private Customer customer;
	private List<Channel> channels;

	@Given("a premium customer")
	public void givenAPremiumCustomer() {
		customer = customerHelper.createPremium();
	}

	@When("the customer accesses available channels")
	public void whenTheCustomerAccessesAvailableChannels() {
		channels = fasad.getAvailableChannels(customer);
	}

	@Then("below channels are listed: $table")
	public void thenBelowChannelsAreListed(ExamplesTable table) {
		List<Channel> expectedChannels = new ArrayList<Channel>();
		for (Map<String, String> row: table.getRows()) {
			String channel = row.get("Channel");
			expectedChannels.add(Channel.parse(channel));
		}
		compareChannels(expectedChannels, channels);
	}

}
