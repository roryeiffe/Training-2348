import React from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Pets from './components/Pets';
import PetItem from './components/PetItem';
import AddPet from './components/AddPet';
import Navbar from './components/Navbar';

function App() {
  return (
    <BrowserRouter>
    <Navbar/>
    <Routes>
      <Route path="/" element={<Pets/>}/>
      <Route path="/pets/:id" element={<PetItem/>}/>
      <Route path = "/add" element={<AddPet/>}/>
    </Routes>
    
    </BrowserRouter>
  );
}

export default App;
