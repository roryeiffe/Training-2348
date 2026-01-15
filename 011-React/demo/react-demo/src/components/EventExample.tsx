import { useState } from "react"
import React from 'react'


export default function Events() {
  // come back to this later:
  // const [names, setNames] = useState(["john", "joe", "matt"])

  function handleClick(event: React.MouseEvent<HTMLButtonElement>) {
    
    console.log(event);
    alert("Hello");
  }

  function handleChange(event: React.ChangeEvent<HTMLInputElement>) {
    console.log(event.target.value);
  }

  function handleSubmit(event: React.FormEvent<HTMLFormElement>) {
    event.preventDefault();
    alert("Form was submitted");
  }

  return (
    <form onSubmit={handleSubmit}>
      <button onClick={handleClick}>Click Me</button>
      <input onChange = {handleChange}/>
      <button type = 'submit'>Submit</button>
      
    </form>
  )
}
