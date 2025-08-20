package model;

public class ObjetivoPerderPeso implements Objetivo{
    //aqui vai ser um multiplicador de queda para a quantidade de carboidratos e gorduras
    public double getObjetivo() {
        return 0.9; //diminuo 10% da quantidade de carboidratos e gorduras
    }
    //deve ser adequado a partir do IMC
}
