import React, { useState, useEffect } from 'react'

export default function Hooks() {

  // set up the state
  const [counter, setCounter] = useState<number>(0);

  const onClickHandler1 = () => {
    // increment the counter value
    setCounter(counter + 1);
  }

   const onClickHandler2 = () => {
    // increment the counter value
    setCounter(counter - 1);
  }

  useEffect(() => {
    console.log("Use Effect Running");
    // Here is where we could put an API call, for example
  }, [counter])

  return (
    <div>
      <p>The count is {counter} </p>
      <button onClick={onClickHandler1}>Increment</button>
      <button onClick={onClickHandler2}>Decrement</button>
    </div>

  )
}
