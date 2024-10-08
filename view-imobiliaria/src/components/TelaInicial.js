import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const TelaInicial = () => {
  const [cpf, setCpf] = useState('');
  const [erro, setErro] = useState('');
  const navigate = useNavigate();

  const handleCpfSubmit = (e) => {
    e.preventDefault();

    // Faz requisição a API para verificar se o usuário EXISTE
    fetch(`http://localhost:5000/usuarios/verificar-cpf/${cpf}`) 
      .then((response) => {
        if (!response.ok) {
          throw new Error("CPF não encontrado");
        }
        return response.json();
      })
      .then(() => {
        navigate(`/imoveis?cpf=${cpf}`);
      })
      .catch((error) => {
        setErro(error.message);
      });
  };

  return (
    <div>
      <h2>Bem-vindo ao Sistema de Aluguel de Imóveis</h2>
      <form onSubmit={handleCpfSubmit}>
        <label htmlFor="cpf">Digite seu CPF:</label>
        <input
          type="text"
          id="cpf"
          value={cpf}
          onChange={(e) => setCpf(e.target.value)}
          required
        />
        <button type="submit">Entrar</button>
      </form>
      {erro && <p style={{ color: 'red' }}>{erro}</p>}
    </div>
  );
};

export default TelaInicial;
