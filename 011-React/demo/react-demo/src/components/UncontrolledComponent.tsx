import React, { FormEvent, useRef } from 'react'

export default function UncontrolledComponent() {
  // refs are used to store references to things like DOM elements
  const inputRef = useRef<HTMLInputElement>(null);


  const handleSubmit = (event:FormEvent) => {
    event.preventDefault();
    // take the value from the reference
    if(inputRef.current) console.log(inputRef.current.value)
    // handle other submit logic below:

  }

  return (
    <form onSubmit={handleSubmit}>

      <label>Username:</label>
      <input type='text' ref={inputRef} ></input>
      <button type = 'submit'>Submit</button>
    </form>
  )
}
