import React, { useState, useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

const TelaResumo = () => {
    const location = useLocation();
    const cpf = new URLSearchParams(location.search).get('cpf');
    const codigoImovel = new URLSearchParams(location.search).get('imovel');
    const dataInicio = new URLSearchParams(location.search).get('data_inicio');
    const dataFim = new URLSearchParams(location.search).get('data_fim');
  
    return (
      <div>
        <h2>Resumo do Aluguel</h2>
        <div>
          <h3>Informações do Aluguel</h3>
          <p><strong>CPF do Usuário:</strong> {cpf}</p>
          <p><strong>Código do Imóvel:</strong> {codigoImovel}</p>
          <p><strong>Data de Início:</strong> {dataInicio}</p>
          <p><strong>Data de Fim:</strong> {dataFim}</p>
        </div>
        <div>
          <h3>Detalhes do Imóvel</h3>
          {/* Aqui você pode adicionar mais detalhes sobre o imóvel, 
               como endereço e descrição, fazendo uma requisição para buscar essas informações usando o código do imóvel */}
        </div>
      </div>
    );
  };

export default TelaResumo;
