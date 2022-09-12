package Modelo;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table (name = "resultados")
public class Resultado {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String jogador;
    private int acertos;
    private int erros;
    private Date datadapartida = Date.valueOf(LocalDate.now());

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }

    public String getJogador() {
        return jogador;
    }

    public int getAcertos() {
        return acertos;
    }

    public int getErros() {
        return erros;
    }

    @Override
    public String toString() {
        return " Jogador: " + this.jogador + "  Acertos: " + this.acertos + "  Data da partida: " +this.datadapartida;
    }

}


