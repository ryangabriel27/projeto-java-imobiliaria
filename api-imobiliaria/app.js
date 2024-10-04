const express = require("express");
const cors = require("cors");
const imoveisRoutes = require("./src/routes/imoveisRoutes");
const usuariosRoutes = require("./src/routes/usuariosRoutes");
const aluguelRoutes = require('./src/routes/aluguelRoutes');
require("dotenv").config();
require("./src/config/db"); // Conectando ao banco de dados


const app = express();

// Middlewares
// Configura o middleware CORS
app.use(cors());
app.use(express.json());

// Rotas
app.use("/imoveis", imoveisRoutes);
app.use("/usuarios", usuariosRoutes);
app.use("/alugueis", aluguelRoutes);

// Exportando a aplicação configurada
module.exports = app;