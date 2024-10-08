package br.ryan.Service;

import br.ryan.Connection.UsuariosDAO;
import br.ryan.Model.Usuario;
import br.ryan.Repository.UsuarioRepository;

public class UsuarioService {

    UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    // Método para cadastrar um novo usuário
    public void cadastrarUsuario(String cpf, String nomeCompleto, String telefone, String email) throws Exception {
        if (cpf.isEmpty() || nomeCompleto.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
            throw new Exception("Campos vazios não são permitidos");
        }
        if (!validaCpf(cpf)) { // Valida CPF antes de cadastrar
            throw new Exception("Digite o cpf corretamente");
        }

        Usuario usuario = new Usuario(cpf.trim().toUpperCase(), nomeCompleto.trim().toUpperCase(),
                telefone.trim(), email.trim());
        repository.cadastrar(usuario);
    }

    // Método para apagar um usuário do banco de dados
    public void apagar(String cpf) throws Exception {
        if (cpf.isEmpty()) {
            throw new Exception("Cpf vazio!");
        }
        repository.apagar(cpf);
    }

    // Método para atualizar os dados de um usuário
    public void atualizar(String cpf, String nomeCompleto, String telefone, String email) throws Exception {
        if (cpf.isEmpty()) {
            throw new Exception("Cpf vazio");
        }
        if (!validaCpf(cpf)) { // Valida CPF antes de cadastrar
            throw new Exception("Digite o cpf corretamente");
        }
        try {
            Usuario usuario = new Usuario(cpf, nomeCompleto, telefone, email);
            repository.editar(usuario, cpf);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    // Método para validar CPF
    public boolean validaCpf(String cpf) {
        return cpf.matches("[0-9]+") && cpf.length() == 11; // Verifica se o CPF tem apenas dígitos e 11 caracteres
    }
}
