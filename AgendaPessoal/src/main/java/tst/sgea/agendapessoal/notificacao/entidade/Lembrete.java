/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tst.sgea.agendapessoal.notificacao.entidade;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Jean Clay Souza da Silva (jean.clay@tst.jus.br)
 */
public class Lembrete {
    private final int valor;
    private final TimeUnit unidade;

    public Lembrete(int antes, TimeUnit und) {
        this.valor = antes;
        this.unidade = und;
    }
    
    
}
