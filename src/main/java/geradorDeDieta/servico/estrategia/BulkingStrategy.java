package geradorDeDieta.servico.estrategia;
import org.springframework.stereotype.Component;

@Component("GANHARMASSA")
public class BulkingStrategy implements DietStrategy {
    private static final int SUPERAVIT_CALORICO = 300; //superávit de 300kcal

    @Override
    public int calcularObjetivoCalorico(double tdee){
        return (int)(tdee + SUPERAVIT_CALORICO);
    }
}
