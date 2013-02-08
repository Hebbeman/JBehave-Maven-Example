package se.prolore;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.junit.JUnitStoryMaps;
import org.jbehave.core.reporters.StoryReporterBuilder;

public class TraderStoryMaps extends JUnitStoryMaps {
    
    public TraderStoryMaps() {
        configuredEmbedder().useMetaFilters(metaFilters());
    }
 
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
            .useStoryReporterBuilder(new StoryReporterBuilder()
                .withCodeLocation(CodeLocations.codeLocationFromClass(this.getClass())));
    }
 
    @Override
    protected List<String> metaFilters() {
        return Arrays.asList("+AF101 A3");
    }
 
    @Override
    protected List<String> storyPaths() {
        return Arrays.asList("example/demo.story", "example/demo2.story");
                 
    }
         
}
