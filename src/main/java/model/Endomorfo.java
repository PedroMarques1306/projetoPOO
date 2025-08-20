package model;

public class Endomorfo implements Biotipo{

    //aquio seria uma pessoa com facilidade de ganhar gordura
    //assim vou dar uma taxa masi alta de proteina, uma menor de carboidratos e tentar diminuir a gordura
    public double getProteina(){
      return 1.1;//+10%
    }
    public double getCarbo(){
        return 0.85;//-15%
    }
    public double getGordura(){
        return 1.1;//+10%
    }

    //olhar melhor esses valores
}
