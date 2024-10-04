const pool = require('../config/db'); // Importar a configuração do banco de dados

// Função para listar imóveis
exports.verificaUsuario = async (req, res) => {
  try {
    const result = await pool.query('SELECT * FROM usuarios_imobiliaria WHERE cpf = $1', [req.body.cpf]);
    res.status(200).json(result.rows);
  } catch (error) {
    console.error('Erro ao listar imóveis', error);
    res.status(500).json({ message: 'Erro ao listar imóveis', error });
  }
};

