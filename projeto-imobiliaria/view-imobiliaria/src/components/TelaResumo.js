import React, { useState, useEffect } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

const TelaResumo = () => {
  const [imovel, setImovel] = useState(null);
  const location = useLocation();
  const navigate = useNavigate();
  const cpf = new URLSearchParams(location.search).get('cpf');
  const codigoImovel = new URLSearchParams(location.search).get('imovel');

  useEffect(() => {
    fetch(`/api/imoveis/${codigoImovel}`)
      .then((response) => response.json())
      .then((data) => setImovel(data))
      .catch((error) => console.error('Erro ao buscar o imóvel:', error));
  }, [codigoImovel]);

  const handleVoltarInicio = () => {
    navigate('/');
  };

  return (
    <div>
      <h2>Resumo do Aluguel</h2>
      {imovel && (
        <div>
          <h3>Imóvel: {imovel.endereco}</h3>
          <p>Descrição: {imovel.descricao}</p>
          <p>Valor do Aluguel: R${imovel.valor_aluguel}</p>
        </div>
      )}
      <button onClick={handleVoltarInicio}>Voltar ao Início</button>
    </div>
  );
};

export default TelaResumo;
