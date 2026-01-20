import React from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Pets from './components/Pets';
import PetItem from './components/PetItem';

function App() {
  return (
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<Pets/>}/>
      <Route path="/pets/:id" element={<PetItem/>}/>
    </Routes>
    
    </BrowserRouter>
  );
}

export default App;
