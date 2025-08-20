package model;

public class EstadoAtualMagro implements EstadoAtual {
    /*se o estado atual e magro, devo alinhar com ganhar peso
    assim eu aumento a quantidade de calorias, aumento a quantidade de carboidratos e mantenho o resto
    */
    //vai ser um multiplicador para o carbo!!!
    public double getEstadoAtual() {
        return 1.15; //aumento em 15% a quantidade de carboidrato
    }

}
