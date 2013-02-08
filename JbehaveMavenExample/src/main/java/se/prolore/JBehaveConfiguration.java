package se.prolore;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class JBehaveConfiguration extends JUnitStory {
	
	private Configuration conf;

	public JBehaveConfiguration() {
		super();
		conf = new MostUsefulConfiguration().
				useStoryPathResolver(new UnderscoredCamelCaseResolver()).
				useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.CONSOLE));
	}

	@Override
	public Configuration configuration() {
		return conf;
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(conf, this);
	}

}
