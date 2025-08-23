package geradorDeDieta.service;
//mostra como funciona o projeto

import geradorDeDieta.dto.DietPlanDTO;
import geradorDeDieta.dto.DietRequestDTO;
import geradorDeDieta.model.Usuario;
import geradorDeDieta.model.enums.*;
import geradorDeDieta.repository.UsuarioRepository;
import geradorDeDieta.servico.DietService;
import geradorDeDieta.servico.estrategia.BulkingStrategy;
import geradorDeDieta.servico.estrategia.CuttingStrategy;
import geradorDeDieta.servico.estrategia.DietStrategy;
import geradorDeDieta.servico.estrategia.ManuntencaoStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks; //mockito ja vem com o teste do spring boot
import org.mockito.Mock; //mockito vai funcionar para isolarmos a classe que queremos testar, a partir do mocks
import org.mockito.junit.jupiter.MockitoExtension;

//crio um mock, que e um objeto falso, para nao precisar conectar ao banco de dados
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat; //biblioteca que ajuda a verificar os resultados dos testes de uma forma mais clara
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) //permite adicionar extensoes ao junit, como o mockito
public class ServicoDietaTest {

    @Mock
    private UsuarioRepository usuarioRepository; //o mock

    @Mock
    private Map<String, DietStrategy> dietStrategies;

    @InjectMocks
    private DietService dietService;//cria um ainstancia da classe que queremos utilizar, ja tenta injetar automaticamente os mocks na instancia

    @BeforeEach //prepara o ambiente, marca um metodo que dev ser executado antes de cada teste na classe
    void setUp() {
        // Configuração manual das strategies para o teste
        Map<String, DietStrategy> strategies = new HashMap<>();
        strategies.put("GANHARMASSA", new BulkingStrategy());
        strategies.put("PERDERPESO", new CuttingStrategy());
        strategies.put("MANTERPESO", new ManuntencaoStrategy());
        dietService = new DietService(usuarioRepository, strategies);
    }

    @Test //marca um metodo como um caso de teste que dev ser executado
    void deveGerarPlanoDeDietaParaGanhoDeMassa() {
        // 1. Cenário (Given)
        DietRequestDTO request = new DietRequestDTO();
        request.setIdade(25);
        request.setPeso(70);
        request.setAltura(175);
        request.setGenero(Genero.MASCULINO);
        request.setNivelAtividade(NivelAtividade.MODERADAMENTE_ATIVO);
        request.setObjetivo(Objetivo.GANHARMASSA);
        request.setBiotipo(Biotipo.MESOMORFO);
        request.setEstadoAtual(EstadoAtual.MAGRO);

        Usuario usuarioSalvo = new Usuario();
        usuarioSalvo.setId(1L);
        usuarioSalvo.setAnos(request.getIdade());
        usuarioSalvo.setPeso(request.getPeso());
        usuarioSalvo.setAltura(request.getAltura());
        usuarioSalvo.setGenero(request.getGenero());
        usuarioSalvo.setNivelAtividade(request.getNivelAtividade());
        usuarioSalvo.setObjetivo(request.getObjetivo());
        usuarioSalvo.setBiotipo(request.getBiotipo());
        usuarioSalvo.setEstadoAtual(request.getEstadoAtual());

        // Simula o comportamento do repositório
        //permite definir o comportamento de um mock
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuarioSalvo);
        //quando o metodo save do repositorio falso for chamado, finja que funcionou e retorno o objeto

        // 2. Ação (When)
        DietPlanDTO plano = dietService.generateDietPlan(request);

        // 3. Verificação (Then)
        assertThat(plano).isNotNull();
        // TMB = (10 * 70) + (6.25 * 175) - (5 * 25) + 5 = 700 + 1093.75 - 125 + 5 = 1673.75
        // TDEE = 1673.75 * 1.55 = 2594.31
        // Calorias Alvo = 2594.31 + 300 (Bulking) = 2894.31
        assertThat(plano.getCaloriasTotais()).isEqualTo(2894);

        // Proteínas = 70 * 2 * 1.05 (meso) * 1.0 (magro) = 147g
        //assert that vem do org.assertj.core.api.Assertions
        assertThat(plano.getProteinasGramas()).isCloseTo(147.0, org.assertj.core.data.Offset.offset(0.1));

        // Gorduras = (2894 * 0.25) / 9 * 1.05 (meso) * 1.0 (magro) = 84.4g
        assertThat(plano.getGordurasGramas()).isCloseTo(84.4, org.assertj.core.data.Offset.offset(0.1));

        // Carboidratos = (2894 - (147*4) - (84.4*9)) / 4 * 1.05 (meso) * 1.15 (magro) = 384.3g
        assertThat(plano.getCarboidratoGramas()).isCloseTo(384.3, org.assertj.core.data.Offset.offset(0.1));
    }
}