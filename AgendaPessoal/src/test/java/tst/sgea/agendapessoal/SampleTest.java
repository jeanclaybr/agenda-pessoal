/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package tst.sgea.agendapessoal;

import java.util.Arrays;
import java.util.List;
import org.jbehave.core.embedder.Embedder;
import org.junit.Test;
import tst.sgea.agendapessoal.jb.DefaultEmbedder;

/**
 *
 * @author Jean Clay Souza da Silva (jean.clay@tst.jus.br)
 */
public class SampleTest {

    @Test
    public void sbruble() {
        Embedder embedder = new DefaultEmbedder(new Object[]{});
        embedder.runStoriesAsPaths(storyPaths());
    }

    private List<String> storyPaths() {
        return Arrays.asList("tst/sgea/agendapessoal/Sample.story");
    }
}
