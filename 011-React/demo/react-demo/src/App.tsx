import React from 'react';
import logo from './logo.svg';
import './App.css';
import HelloWorldComponent from './components/HelloWorld';
import Hooks from './components/Hooks';
import EventExample from './components/EventExample';
import ControlledComponent from './components/ControlledComponent';
import UncontrolledComponent from './components/UncontrolledComponent';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import RoutingExample from './components/RoutingExample';
import AxiosExample from './components/AxiosExample';
import Login from './components/Login';

function App() {
  return (
    <div>
      
      <BrowserRouter> 
      <Navbar /> 
        <Routes>
          <Route path = "/" element={<HelloWorldComponent message='Welcome to React!'/>}></Route>
          <Route path = "/hooks" element={<Hooks/>}/>
          <Route path =  "/events" element={<EventExample/>}/>
          <Route path = "/controlled" element={<ControlledComponent/>}/>
          <Route path = "/uncontrolled" element={<UncontrolledComponent/>}/>
          <Route path = "/routing/:id" element={<RoutingExample />}/>
          <Route path = "/axios" element={<AxiosExample/>}/>
          <Route path = "/formhook" element={<Login/>}/>
        </Routes>
      
      </BrowserRouter>

      
    </div>
  );
}

export default App;
