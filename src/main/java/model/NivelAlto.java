package model;

public class NivelAlto implements NivelDeAtividade{

    public double nivelDeAtividade(){
        /*coloco um valor multiplicador, se o nivel de Atividade for maior entao, mais calorias ele deve gastar, assim
        dependendo da dieta o valor calorico deve ser aumentado*/
        return 1.2; //nesse caso, o valor calorico da dieta sera aumentado em 20%
    }
}
