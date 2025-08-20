package model;

public class DadosPessoais {
    //aqui vai ser uma classe concreta com os atributos identidade, altura e peso
    private String id;
    private double altura;
    private double peso;

    //criando o construtor
    public DadosPessoais(String id, double altura, double peso){
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

    //calcular IMC
    public double calcularIMC(){
        return peso/(altura*altura); //aqui eu calculo o IMC
    }

}
