import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.ryan.Model.Imovel;
import br.ryan.Repository.ImovelRepository;
import br.ryan.Service.ImovelService;

public class TestImovelService {

    private ImovelRepository repositoryMock;
    private ImovelService imovelService;

    @BeforeEach
    public void setUp() {
        // Criar mock do repositório
        repositoryMock = mock(ImovelRepository.class);

        // Criar instância do serviço com o mock injetado
        imovelService = new ImovelService(repositoryMock);
    }

    @Test
    public void testCadastrarImovelComSucesso() throws Exception {
        // Dados válidos para o imóvel
        String codigo_id = "001";
        String cidade = "São Paulo";
        String estado = "SP";
        String endereco = "Rua A, 123";
        double valor_aluguel = 1500.0;
        String descricao = "Imóvel amplo e arejado";
        String status = "Disponível";

        // Executar o método de cadastro
        imovelService.cadastrarImovel(codigo_id, cidade, estado, endereco, valor_aluguel, descricao, status);

        // Verificar se o método de cadastrar foi chamado no repositório
        verify(repositoryMock).cadatrarImovel(any(Imovel.class));
    }

    @Test
    public void testCadastrarImovelComDadosInvalidos() {
        // Dados inválidos para o imóvel
        String codigo_id = "001";
        String cidade = ""; // Cidade vazia
        String estado = "SP";
        String endereco = "Rua A, 123";
        double valor_aluguel = 1500.0;
        String descricao = "Imóvel amplo e arejado";
        String status = "Disponível";

        // Verificar se a exceção é lançada ao tentar cadastrar imóvel com dados inválidos
        assertThrows(Exception.class, () -> {
            imovelService.cadastrarImovel(codigo_id, cidade, estado, endereco, valor_aluguel, descricao, status);
        });
    }

    @Test
    public void testAtualizarImovelComSucesso() throws Exception {
        // Criar um imóvel para atualizar
        Imovel imovel = new Imovel("001", "São Paulo", "SP", "Rua A, 123", 1500.0, "Imóvel amplo e arejado", "Disponível");
        String id = "001";

        // Executar o método de atualização
        imovelService.atualizarImovel(imovel, id);

        // Verificar se o método de editar foi chamado no repositório
        verify(repositoryMock).editarImovel(imovel, id);
    }

    @Test
    public void testAtualizarImovelComIdVazio() {
        // Criar um imóvel para atualizar
        Imovel imovel = new Imovel("001", "São Paulo", "SP", "Rua A, 123", 1500.0, "Imóvel amplo e arejado", "Disponível");
        String id = ""; // ID vazio

        // Verificar se a exceção é lançada ao tentar atualizar imóvel com ID vazio
        assertThrows(Exception.class, () -> {
            imovelService.atualizarImovel(imovel, id);
        });
    }

    @Test
    public void testAtualizarImovelComImovelInvalido() {
        String id = "001";

        // Verificar se a exceção é lançada ao tentar atualizar com um imóvel nulo
        assertThrows(Exception.class, () -> {
            imovelService.atualizarImovel(null, id);
        });
    }

    @Test
    public void testApagarImovelComSucesso() throws Exception {
        String id = "001";

        // Executar o método de apagar
        imovelService.apagarImovel(id);

        // Verificar se o método de apagar foi chamado no repositório
        verify(repositoryMock).apagarImovel(id);
    }

    @Test
    public void testApagarImovelComIdVazio() {
        String id = ""; // ID vazio

        // Verificar se a exceção é lançada ao tentar apagar imóvel com ID vazio
        assertThrows(Exception.class, () -> {
            imovelService.apagarImovel(id);
        });
    }
}
