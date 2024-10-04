import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';

const TelaImoveis = () => {
    const [imoveis, setImoveis] = useState([]);
    const [imovelSelecionado, setImovelSelecionado] = useState(null);
    const [dataInicio, setDataInicio] = useState('');
    const [dataFim, setDataFim] = useState('');
    const navigate = useNavigate();
    const location = useLocation();
    const cpf = new URLSearchParams(location.search).get('cpf');


    useEffect(() => {
        fetch('http://localhost:3000/imoveis')
            .then((response) => response.json())
            .then((data) => setImoveis(data))
            .catch((error) => console.error('Erro ao buscar imóveis:', error));
    }, []);

    const handleAluguel = (e) => {
        e.preventDefault(); // Previne o comportamento padrão do form
        fetch('http://localhost:3000/alugueis/aluguel', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                cpf,
                codigo_id: imovelSelecionado,
                data_inicio: dataInicio,
                data_fim: dataFim
            }),
        })
            .then((response) => response.json())
            .then(() => {
                // Incluindo as datas na URL de redirecionamento
                navigate(`/resumo?cpf=${cpf}&imovel=${imovelSelecionado}&data_inicio=${dataInicio}&data_fim=${dataFim}`);
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

            {imovelSelecionado && (
                <form onSubmit={handleAluguel}>
                    <h3>Selecionado: {imovelSelecionado}</h3>
                    <div>
                        <label>Data de Início:</label>
                        <input
                            type="date"
                            value={dataInicio}
                            onChange={(e) => setDataInicio(e.target.value)}
                            required
                        />
                    </div>
                    <div>
                        <label>Data de Fim:</label>
                        <input
                            type="date"
                            value={dataFim}
                            onChange={(e) => setDataFim(e.target.value)}
                            required
                        />
                    </div>
                    <button type="submit">Solicitar Aluguel</button>
                </form>
            )}
        </div>
    );
};


export default TelaImoveis;
