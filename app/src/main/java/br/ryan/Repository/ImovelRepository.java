package br.ryan.Repository;

import br.ryan.Model.Imovel;

public interface ImovelRepository {

    void cadatrarImovel(Imovel imovel);
    void editarImovel(Imovel imovel, String id);
    void apagarImovel(String id);
} 
