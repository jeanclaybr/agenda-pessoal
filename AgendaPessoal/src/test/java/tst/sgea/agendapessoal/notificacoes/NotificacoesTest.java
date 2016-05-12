/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tst.sgea.agendapessoal.notificacoes;

import java.util.Arrays;
import java.util.List;
import org.jbehave.core.embedder.Embedder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tst.sgea.agendapessoal.jb.DefaultEmbedder;
import tst.sgea.agendapessoal.notificacoes.steps.ReceberNotificacaoPorEmailSteps;

/**
 *
 * @author Jean Clay Souza da Silva (jean.clay@tst.jus.br)
 */
public class NotificacoesTest {
    
    public NotificacoesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void run() {
        Embedder embedder = new DefaultEmbedder(
            new Object[]{
                new ReceberNotificacaoPorEmailSteps()
            }
        );
        embedder.runStoriesAsPaths(storyPaths());
    }

    private List<String> storyPaths() {
        return Arrays.asList("historias/ser_notificado/receber_notificacoes_por_email/ReceberNotificacaoPorEmail.story");
    }
}
