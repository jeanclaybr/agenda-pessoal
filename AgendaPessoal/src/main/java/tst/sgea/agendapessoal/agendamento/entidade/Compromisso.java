/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package tst.sgea.agendapessoal.agendamento.entidade;

import java.time.LocalDateTime;
import tst.sgea.agendapessoal.notificacao.entidade.Lembretes;

/**
 *
 * @author Jean Clay Souza da Silva (jean.clay@tst.jus.br)
 */
public class Compromisso {

    private final String descricao;
    private final LocalDateTime inicio;
    private final LocalDateTime fim;
    private final Lembretes lembretes;

    public Compromisso(String descricao, LocalDateTime inicio, LocalDateTime fim, Lembretes lembretes) {
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
        this.lembretes = lembretes;
    }

}
