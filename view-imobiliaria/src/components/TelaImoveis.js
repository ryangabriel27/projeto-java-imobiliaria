import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import '../styles/StyleImoveis.css';

const TelaImoveis = () => {
    const [imoveis, setImoveis] = useState([]);
    const [imovelSelecionado, setImovelSelecionado] = useState(null);
    const [dataInicio, setDataInicio] = useState('');
    const [dataFim, setDataFim] = useState('');
    const navigate = useNavigate();
    const location = useLocation();
    const cpf = new URLSearchParams(location.search).get('cpf');


    if (!cpf) {
        console.error('CPF não fornecido na URL.');
    }

    useEffect(() => {
        fetch('http://localhost:5000/imoveis')
            .then((response) => response.json())
            .then((data) => setImoveis(data))
            .catch((error) => console.error('Erro ao buscar imóveis:', error));
    }, []);

    const handleAluguel = (e) => {
        e.preventDefault(); // Previne o comportamento padrão do form

        // Verificação antes do envio
        if (!cpf || !imovelSelecionado) {
            alert('CPF ou Imóvel não especificado.');
            return;
        }

        fetch('http://localhost:5000/alugueis/aluguel', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                usuario_id: cpf,
                imovel_id: imovelSelecionado,
                data_inicio: dataInicio,
                data_fim: dataFim
            }),
        }).then((response) => {
            console.log(response.json());
        }).then(() => {
            navigate(`/resumo?cpf=${cpf}&imovel=${imovelSelecionado}&data_inicio=${dataInicio}&data_fim=${dataFim}`);
        }).catch((error) => console.error('Erro ao solicitar aluguel:', error));
    };

    return (
        <div className="container">
            <h2 className="title">Imóveis Disponíveis</h2>

            {imovelSelecionado && (
                <form onSubmit={handleAluguel} className="form">
                    <h3>Alugar Imóvel - Código: {imovelSelecionado}</h3>
                    <label>
                        Data de Início:
                        <input
                            type="date"
                            value={dataInicio}
                            onChange={(e) => setDataInicio(e.target.value)}
                            required
                        />
                    </label>
                    <label>
                        Data de Fim:
                        <input
                            type="date"
                            value={dataFim}
                            onChange={(e) => setDataFim(e.target.value)}
                            required
                        />
                    </label>
                    <button type="submit">Solicitar Aluguel</button>
                </form>
            )}

            <div className="grid">
                {imoveis.map((imovel) => (
                    <div key={imovel.codigo_id} className="card">
                        <h3>Cidade: {imovel.cidade}, {imovel.estado}</h3>
                        <h4>Endereço: {imovel.endereco}</h4>
                        <p>Descrição: {imovel.descricao}</p>
                        <p>Valor Aluguel: R$ {imovel.valor_aluguel}</p>
                        <button onClick={() => setImovelSelecionado(imovel.codigo_id)} className="button">
                            Selecionar
                        </button>
                    </div>
                ))}
            </div>
        </div>
    );
};


export default TelaImoveis;
