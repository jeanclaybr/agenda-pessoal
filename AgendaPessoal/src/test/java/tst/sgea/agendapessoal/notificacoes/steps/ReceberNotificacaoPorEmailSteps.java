/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package tst.sgea.agendapessoal.notificacoes.steps;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import tst.sgea.agendapessoal.agendamento.entidade.Compromisso;
import tst.sgea.agendapessoal.notificacao.entidade.Lembrete;
import tst.sgea.agendapessoal.notificacao.entidade.Lembretes;

/**
 *
 * @author Jean Clay Souza da Silva (jean.clay@tst.jus.br)
 */
public class ReceberNotificacaoPorEmailSteps {

    private Compromisso compromisso;
    private String destinatario;
    private String nome;

    @Given("possuo o seguinte compromisso: $exemplo")
    public void dadoQuePossuoCompromisso(ExamplesTable exemplo) {
        Map<String, String> map = exemplo.getRows().get(0);
        String descricao = map.get("descricao");
        LocalDateTime inicio = asLocalDateTime(map.get("inicio"));
        LocalDateTime fim = asLocalDateTime(map.get("fim"));
        Lembretes lembretes = asLembretes(map.get("notificacoes"));

        this.compromisso = new Compromisso(descricao, inicio, fim, lembretes);
    }

    @Given("o meu email é $email")
    public void dadoQueMeuEmailE(String email) {
        this.destinatario = email;
    }

    @Given("meu nome é $nome")
    public void dadoQueMeuNomeE(String nome) {
        this.nome = nome;
    }

    @When("chegar a hora de enviar as notificações pendentes")
    public void quandoEnviarNotificacoesPendentes() {

    }

    @Then("receberei o seguinte email: $mensagem")
    public void entaoRecebereiEmail(String mensagem) {

    }

    private LocalDateTime asLocalDateTime(String str) {
        final String pattern = "dd/MM/yyyy hh:mm";
        final SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            Date date = sdf.parse(str);
            return LocalDateTime.ofInstant(
                Instant.ofEpochMilli(date.getTime()),
                ZoneId.systemDefault()
            );
        } catch (ParseException ex) {
            throw new RuntimeException(
                String.format(
                    "Erro ao converter a string '%s', usando o padrão '%s'",
                    str,
                    pattern
                ),
                ex
            );
        }
    }

    private Lembretes asLembretes(String str) {
        return new Lembretes(
            Arrays.asList(str.split(",")).stream().
            map(String::trim).map((String str1) -> {
                String[] arr = str1.split(" ");
                int antes = Integer.parseInt(arr[0]);
                TimeUnit unidade = arr[1].contains("hora")
                    ? TimeUnit.HOURS
                    : TimeUnit.DAYS;
                return new Lembrete(antes, unidade);
            }).collect(Collectors.toList())
        );
    }

}
