package model;

public class Ectomorfo implements Biotipo{
    //nesse caso e uma pessoa magra
    //entao uma maior taxa de carboidrato alinhado com uma taxa equilibrada de proteina e gordura
   public double getCarbo(){
       return 1.2; //+20%
   }

   public double getGordura(){
       return  0.9;//-10%
   }

   public double getProteina(){
       return 1.05;//+5%
   }

}
