package br.ryan.Service;

import br.ryan.Connection.ImovelDAO;
import br.ryan.Model.Imovel;
import br.ryan.Repository.ImovelRepository;

public class ImovelService {

    ImovelRepository repository;

    public ImovelService(ImovelRepository repository) {
        this.repository = repository;
    }

    public void cadastrarImovel(String codigo_id, String cidade, String estado, String endereco, double valor_aluguel,
            String descricao,
            String status) throws Exception {
        if (cidade.isEmpty() || estado.isEmpty() || endereco.isEmpty() || String.valueOf(valor_aluguel).isEmpty()
                || valor_aluguel <= 0 || descricao.isEmpty() || status.isEmpty()) {
            throw new Exception("Dados inválidos!");
        }

        try {

            Imovel imovel = new Imovel();
            imovel.setCodigo_id(codigo_id);
            imovel.setCidade(cidade);
            imovel.setEstado(estado);
            imovel.setEndereco(endereco);
            imovel.setValor_aluguel(valor_aluguel);
            imovel.setDescricao(descricao);
            imovel.setStatus(status);

            repository.cadatrarImovel(imovel);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void atualizarImovel(Imovel imovel, String id) throws Exception {
        if (id.trim().isEmpty()) {
            throw new Exception("Id vazio");
        }
        if (imovel == null) {
            throw new Exception("Imóvel não validado");
        }
        try {
            repository.editarImovel(imovel, id);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void apagarImovel(String id) throws Exception {
        if (id.trim().isEmpty()) {
            throw new Exception("Id vazio");
        }
        try {
            repository.apagarImovel(id);
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
