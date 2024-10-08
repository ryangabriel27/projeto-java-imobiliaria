import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.ryan.Model.Usuario;
import br.ryan.Repository.UsuarioRepository;
import br.ryan.Service.UsuarioService;

public class TestUsuarioService {
    private UsuarioRepository repositoryMock;
    private UsuarioService usuarioService;

    @BeforeEach
    public void setUp() {
        // Criar mock do repositório
        repositoryMock = Mockito.mock(UsuarioRepository.class);

        // Criar instância do serviço com o mock injetado
        usuarioService = new UsuarioService(repositoryMock);
    }

    @Test
    public void testCadastrarUsuarioComSucesso() throws Exception {
        // Executar o método de cadastro
        usuarioService.cadastrarUsuario("12345678901", "João da Silva", "999999999", "joao@example.com");

        // Verificar se o método de cadastrar foi chamado no repositório
        verify(repositoryMock).cadastrar(any(Usuario.class));
    }

    @Test
    public void testCadastrarUsuarioComCamposVazios() {
        // Verificar se a exceção é lançada ao tentar cadastrar com campos vazios
        Exception exception = assertThrows(Exception.class, () -> {
            usuarioService.cadastrarUsuario("", "João da Silva", "999999999", "joao@example.com");
        });
        assertEquals("Campos vazios não são permitidos", exception.getMessage());
    }

    @Test
    public void testCadastrarUsuarioComCpfInvalido() {
        // Tentar cadastrar um usuário com CPF inválido
        Exception exception = assertThrows(Exception.class, () -> {
            usuarioService.cadastrarUsuario("123", "João da Silva", "999999999", "joao@example.com");
        });
        assertEquals("Digite o cpf corretamente", exception.getMessage());
    }

    @Test
    public void testApagarUsuarioComSucesso() throws Exception {
        // Executar o método de apagar
        usuarioService.apagar("12345678901");

        // Verificar se o método de apagar foi chamado no repositório
        verify(repositoryMock).apagar("12345678901");
    }

    @Test
    public void testApagarUsuarioComCpfVazio() {
        // Verificar se a exceção é lançada ao tentar apagar com CPF vazio
        Exception exception = assertThrows(Exception.class, () -> {
            usuarioService.apagar("");
        });
        assertEquals("Cpf vazio!", exception.getMessage());
    }

    @Test
    public void testAtualizarUsuarioComSucesso() throws Exception {
        // Executar o método de atualização
        usuarioService.atualizar("12345678901", "João da Silva", "999999999", "joao@example.com");

        // Verificar se o método de editar foi chamado no repositório
        verify(repositoryMock).editar(any(Usuario.class), eq("12345678901"));
    }

    @Test
    public void testAtualizarUsuarioComCpfVazio() {
        // Verificar se a exceção é lançada ao tentar atualizar com CPF vazio
        Exception exception = assertThrows(Exception.class, () -> {
            usuarioService.atualizar("", "João da Silva", "999999999", "joao@example.com");
        });
        assertEquals("Cpf vazio", exception.getMessage());
    }

    @Test
    public void testAtualizarUsuarioComCpfInvalido() {
        // Verificar se a exceção é lançada ao tentar atualizar com CPF inválido
        Exception exception = assertThrows(Exception.class, () -> {
            usuarioService.atualizar("123", "João da Silva", "999999999", "joao@example.com");
        });
        assertEquals("Digite o cpf corretamente", exception.getMessage());
    }
}
