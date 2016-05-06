/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tst.sgea.agendapessoal.jb;

import java.text.SimpleDateFormat;
import java.util.Locale;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.CrossReference;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.jbehave.core.steps.SilentStepMonitor;

/**
 * 
 * @author Jean Clay Souza da Silva (jean.clay@tst.jus.br)
 */
public class DefaultEmbedder extends Embedder {
    
    private final Object[] steps;

    public DefaultEmbedder(Object[] steps) {
        super();
        this.steps = steps;
    }
    
    @Override
    public EmbedderControls embedderControls() {
        return new EmbedderControls().doIgnoreFailureInStories(true).doIgnoreFailureInView(true);
    }
    
    @Override
    public Configuration configuration() {
        
        Class<? extends DefaultEmbedder> embedderClass = this.getClass();
//        LocalizedKeywords localizedKeywords = new LocalizedKeywords(new Locale("pt"));
        return new MostUsefulConfiguration()
//                .useKeywords(localizedKeywords)
                .useStoryLoader(new LoadFromClasspath(embedderClass.getClassLoader()))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(CodeLocations.codeLocationFromClass(embedderClass))
                        .withDefaultFormats()
                        .withFormats(CONSOLE, TXT, HTML, XML)
                        .withCrossReference(new CrossReference()))
                .useParameterConverters(new ParameterConverters()
                        .addConverters(
                                new DateConverter(new SimpleDateFormat("dd/MM/yyyy"))))
                .useStepMonitor(new SilentStepMonitor())
//                .useStoryParser(new RegexStoryParser(localizedKeywords))
            ;
    }
    

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), steps);
    }

}
