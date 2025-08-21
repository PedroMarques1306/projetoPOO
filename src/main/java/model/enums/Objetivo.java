package model.enums;

public enum Objetivo{


    GANHARMASSA("Ganho de massa", 1.2), //multiplicador para carbo e proteina

    PERDERPESO("Perder peso", 0.9), // para carbo e gordura

    MANTERPESO("Manter peso",1.0); //mantenho


    //atributos para as constantes
    private final String descricao;
    private final double multiplicador;

    //construtor
    Objetivo(String descricao, double multiplicador){
        this.descricao = descricao;
        this.multiplicador = multiplicador;
    }

    //metodos get
    public String getDescricao() {
        return descricao;
    }

    public double getMultiplicador() {
        return multiplicador;
    }







}