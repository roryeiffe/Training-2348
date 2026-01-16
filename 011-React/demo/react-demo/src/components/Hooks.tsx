import React, { useState, useEffect, useRef, useMemo, useCallback } from 'react'
import HookChild from './HookChild';

const fibonacci = (num: number): number => {
  return 0;
  // base cases:
  // if(num === 0) return 0;
  // if(num === 1) return 1;
  // return fibonacci(num - 1) + fibonacci(num - 2);
}

export default function Hooks() {

  // set up the state
  const [counter, setCounter] = useState<number>(0);
  // useRef to store mutable values, won't trigger re-renders
  const counterRef = useRef<number>(0);
  // create an inputRef to reference the input element
  // we pass the ref attribute to the element and have it point to the inputRef
  const inputRef = useRef<HTMLInputElement>(null);

  //useMemo, calculate the nth fibonacci number, based on counter:
  // callback function is what to run (in this case, just call our fibonacci function)
  // dependency array includes the values that should trigger this function to recalculate
  const fib = useMemo(() => {
    return fibonacci(counter);
  }, [counter])

  const onClickHandler1 = () => {
    // increment the counter value
    setCounter(counter + 1);
  }

   const onClickHandler2 = () => {
    // increment the counter value
    setCounter(counter - 1);
  }

  const updateCounterRef = () => {
    counterRef.current += 1;
    console.log("Ref value: " + counterRef.current);
  }

  // create a callback function:
  const doubleCount = useCallback(() => {
    // make a copy of the counter state, double it and assign it back
    let currentCount = counter;
    currentCount *= 2;
    setCounter(currentCount);
    // setCounter(counter * 2); // shorter syntax
  }, [counter])


  useEffect(() => {
    console.log("Use Effect Running");
    // Here is where we could put an API call, for example
    // We can target the inputRef and "focus" on it, place the cursor inside
    if(inputRef.current) inputRef.current.focus();
  }, [counter])

  return (
    <div>
      <p>The count is {counter} </p>
      <p>The value of the counter with useRef is {counterRef.current}</p>
      <p>Fibonacci Value (based on counter): {fib}</p>
      <button onClick={onClickHandler1}>Increment (useState)</button>
      <button onClick={onClickHandler2}>Decrement (useState)</button>
      <button onClick={updateCounterRef}>Increment (useRef)</button>
    
      <HookChild onClickCB={doubleCount}/>


      {/* Rendering an input item,  */}
      <input placeholder='rory123' ref={inputRef}/>
    </div>

  )
}
