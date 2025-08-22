package geradorDeDieta.servico.estrategia;
import org.springframework.stereotype.Component;
//Essa arquivo é necessario pra seguir o padrão Strategy, que é um dos requisitos do nosso trabalho
@Component("PERDERPESO")
public class CuttingStrategy implements DietStrategy {
    private static final int DEFICT_CALORICO = 500;

    @Override
    public int calcularObjetivoCalorico(double tdee){
        return Math.max(1200,(int) (tdee - DEFICT_CALORICO)); //Isso aqui é pra garantir que o resultado não seja menor que 1200
                                                                // ou seja perigoso pra um possivel usuario muito doido com vontade de emagraecer
    }
}
