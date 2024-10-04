const Aluguel = require('../models/aluguel');
require('dotenv').config();


class AluguelController {
    static async registrar(req, res) {
        const { data_inicio, data_fim, usuario_id, imovel_id } = req.body;
        const url = "http://" + process.env.DB_HOST + ":" + process.env.PORT + "/imoveis/" + imovel_id;
        try {
            fetch(url, {
                method: 'POST', // Define que o método será POST
                headers: {
                    'Content-Type': 'application/json' // Especifica o tipo de conteúdo enviado
                },
            })
            const novoAluguel = await Aluguel.registrarAluguel(data_inicio, data_fim, usuario_id, imovel_id);
            res.status(201).json({
                message: "Aluguel registrado com sucesso!",
                aluguel: novoAluguel,
            });
        } catch (error) {
            res.status(500).json({
                message: "Erro ao registrar aluguel",
                error: error.message,
            });
        }
    }
}

module.exports = AluguelController;