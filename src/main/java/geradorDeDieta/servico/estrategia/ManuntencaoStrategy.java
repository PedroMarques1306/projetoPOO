package geradorDeDieta.servico.estrategia;
import org.springframework.stereotype.Component;

@Component("MANTERPESO")
public class ManuntencaoStrategy implements DietStrategy {
    @Override
    public int calcularObjetivoCalorico(double tdee){
        return (int) tdee;
    }
    
}
