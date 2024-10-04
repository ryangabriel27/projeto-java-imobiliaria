import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import TelaInicial from './components/TelaInicial';
import TelaImoveis from './components/TelaImoveis';
import TelaResumo from './components/TelaResumo';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<TelaInicial />} />
        <Route path="/imoveis" element={<TelaImoveis />} />
        <Route path="/resumo" element={<TelaResumo />} />
      </Routes>
    </Router>
  );
}

export default App;
