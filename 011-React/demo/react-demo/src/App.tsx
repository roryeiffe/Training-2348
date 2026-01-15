import React from 'react';
import logo from './logo.svg';
import './App.css';
import HelloWorldComponent from './components/HelloWorld';
import Hooks from './components/Hooks';
import EventExample from './components/EventExample';
import ControlledComponent from './components/ControlledComponent';
import UncontrolledComponent from './components/UncontrolledComponent';

function App() {
  return (
    <div>
      {/* <HelloWorldComponent message ="hello world" author = "Dr. Suess" /> */}
      {/* <HelloWorldComponent message ="hello world" /> */}
      {/* <Hooks /> */}
      {/* <EventExample /> */}
      {/* <ControlledComponent /> */}
      <UncontrolledComponent />

      
    </div>
  );
}

export default App;
