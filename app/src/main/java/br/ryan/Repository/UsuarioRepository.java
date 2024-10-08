package br.ryan.Repository;

import br.ryan.Model.Usuario;

public interface UsuarioRepository {
    void cadastrar(Usuario usuario);
    void editar(Usuario usuario, String cpf);
    void apagar(String cpf);
}
