import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';

const TelaImoveis = () => {
  const [imoveis, setImoveis] = useState([]);
  const [imovelSelecionado, setImovelSelecionado] = useState(null);
  const navigate = useNavigate();
  const location = useLocation();
  const cpf = new URLSearchParams(location.search).get('cpf');

  useEffect(() => {
    fetch('/api/imoveis')
      .then((response) => response.json())
      .then((data) => setImoveis(data))
      .catch((error) => console.error('Erro ao buscar imóveis:', error));
  }, []);

  const handleAluguel = () => {
    fetch('/api/alugueis', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ cpf, codigoImovel: imovelSelecionado }),
    })
      .then((response) => response.json())
      .then(() => {
        navigate(`/resumo?cpf=${cpf}&imovel=${imovelSelecionado}`);
      })
      .catch((error) => console.error('Erro ao solicitar aluguel:', error));
  };

  return (
    <div>
      <h2>Imóveis Disponíveis</h2>
      <div>
        {imoveis.map((imovel) => (
          <div key={imovel.codigo_id}>
            <h3>{imovel.endereco}</h3>
            <p>{imovel.descricao}</p>
            <button onClick={() => setImovelSelecionado(imovel.codigo_id)}>
              Selecionar
            </button>
          </div>
        ))}
      </div>
      <button onClick={handleAluguel} disabled={!imovelSelecionado}>
        Solicitar Aluguel
      </button>
    </div>
  );
};

export default TelaImoveis;
