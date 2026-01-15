import React from 'react';
import logo from './logo.svg';
import './App.css';
import HelloWorldComponent from './components/HelloWorld';
import Hooks from './components/Hooks';

function App() {
  return (
    <div>
      <HelloWorldComponent message ="hello world" author = "Dr. Suess" />
      <HelloWorldComponent message ="hello world" />
      <Hooks />

      
    </div>
  );
}

export default App;
