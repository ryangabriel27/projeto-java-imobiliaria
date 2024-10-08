import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import TelaInicial from './components/TelaInicial';
import TelaImoveis from './components/TelaImoveis';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<TelaInicial />} />
        <Route path="/imoveis" element={<TelaImoveis />} />
      </Routes>
    </Router>
  );
}

export default App;
