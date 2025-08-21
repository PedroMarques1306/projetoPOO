//vai servir para receber os dados do usuario quando ele solicitar um plano de dieta
//faz a comunicacao

package dto; //serve para a comunicao com a API/usuario

//importo de todos os models
import model.enums.Biotipo;
import model.enums.EstadoAtual;
import model.enums.Genero;
import model.enums.NivelAtividade;
import model.enums.Objetivo;

public class DietRequestDTO {

    private double peso;
    private double altura;
    private int idade;
    private Genero genero;
    private NivelAtividade nivelAtividade;
    private Objetivo objetivo;
    private Biotipo biotipo;
    private EstadoAtual estadoAtual;

    //getters e setters

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }


    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }


    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }


    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }


    public NivelAtividade getNivelAtividade() {
        return nivelAtividade;
    }
    public void setNivelAtividade(NivelAtividade nivelAtividade) {
        this.nivelAtividade = nivelAtividade;
    }


    public Objetivo getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }


    public Biotipo getBiotipo() {
        return biotipo;
    }
    public void setBiotipo(Biotipo biotipo) {
        this.biotipo = biotipo;
    }


    public EstadoAtual getEstadoAtual() {
        return estadoAtual;
    }
    public void setEstadoAtual(EstadoAtual estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

















}