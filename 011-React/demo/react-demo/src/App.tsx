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
import Profile from './components/nested/Profile';
import Preferences from './components/nested/Preferences';
import Settings from './components/nested/Settings';
import RequireAuth from './components/RequireAuth';

function App() {
  return (
    <div>
      
      <BrowserRouter> 
      <Navbar /> 
        <Routes>
          <Route path = "/" element={<HelloWorldComponent message='Welcome to React!'/>}></Route>
          <Route path = "/hooks" element={<Hooks/>}/>
          <Route path =  "/events" element={<EventExample/>}/>
         <Route path = "/routing/:id" element={<RoutingExample />}/>
          <Route path = "/axios" element={<AxiosExample/>}/>
          <Route path = "/formhook" element={<Login/>}/>
          <Route path = "/profile" element={<Profile/>}>
            <Route path ="preferences" element={<Preferences/>}/>
            <Route path = "settings" element={<Settings/>}/>
          </Route>
          <Route element = {<RequireAuth isAuthed={false}/>}>
            <Route path = "/controlled" element={<ControlledComponent/>}/>
            <Route path = "/uncontrolled" element={<UncontrolledComponent/>}/>
          </Route>
        </Routes>
      
      </BrowserRouter>

      
    </div>
  );
}

export default App;
