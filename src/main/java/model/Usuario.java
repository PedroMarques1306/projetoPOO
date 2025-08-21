package model;

import jakarta.persistence.*;
import lombok.Data;             //esse lombok é usado pra fazer os metodos get e sets
import model.enums.*;

@Entity //tranforma a classe numa entidade JPA
@Table(name = "usuarios")
@Data // lombok pra criar os metodos e contrutores

public class Usuario {
    //aqui vai ser uma classe concreta com os atributos identidade, altura e peso
    @Id //marca o campo como a chave principal
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Gera o ID automaticamente

    private Long id;       //usando long por convenção e que por que será gerada automaticamnete
    private int anos;
    private double altura;
    private double peso;
    @Enumerated(EnumType.STRING)//Já salava o nome do enum no banco de dados
    private Genero genero;

    @Enumerated(EnumType.STRING)    //Faz isso pra cada metodo que o usuario deve ter na aplicação
    private NivelAtividade nivelAtividade;

    @Enumerated(EnumType.STRING)
    private Objetivo objetivo;
    @Enumerated(EnumType.STRING)
    private Biotipo biotipo;
    @Enumerated(EnumType.STRING)
    private EstadoAtual estadoAtual;
    /*Pro motivos de não ter certeza se vai funcionar como a gente quer  
    //criando o construtor
    public Usuario(String id, double altura, double peso){
        this.id = id;
        this.altura = altura;
        this.peso = peso;
    }

    //metodos get e set
    public String getId(){
        return this.id;
    }
    public double getAltura(){
        return this.altura;
    }
    public double getPeso(){
        return this.peso;
    }

    public void setId(String id){
        this.id = id;
    }
    public void setAltura(double altura){
        this.altura = altura;
    }
    public void setPeso(double peso){
        this.peso = peso;
    }
*/
    //Calcular IMC foi removido daqui pra ir pra DietService
    //calcular IMC


}
