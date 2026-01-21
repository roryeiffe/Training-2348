import React from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Pets from './components/Pets';
import PetItem from './components/PetItem';
import AddPet from './components/AddPet';
import Navbar from './components/Navbar';
import AuthProvider from './util/AuthProvider';
import Login from './components/Login';
import ViewAdoptedPets from './components/ViewAdoptedPets';

function App() {
  return (
    <BrowserRouter>
    {/* Everything rendered inside will have access to the context: */}
    <AuthProvider>
      <Navbar/>
      <Routes>
        <Route path="/" element={<Pets/>}/>
        <Route path="/pets/:id" element={<PetItem/>}/>
        <Route path = "/add" element={<AddPet/>}/>
        <Route path = "/login" element={<Login/>}/>
        <Route path = "/adopted" element ={<ViewAdoptedPets/>}/>
      </Routes>
    </AuthProvider>

    
    </BrowserRouter>
  );
}

export default App;
