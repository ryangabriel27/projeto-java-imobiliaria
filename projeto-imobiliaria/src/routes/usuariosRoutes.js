const express = require("express");
const router = express.Router();
const { verificaUsuario } = require("../controllers/usuariosController");

// Definindo as rotas e associando aos métodos do controller
router.post("/", verificaUsuario); // Listar todos os livros

module.exports = router;