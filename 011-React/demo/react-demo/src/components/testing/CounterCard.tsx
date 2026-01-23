import React, {useEffect, useState} from 'react'

export type CounterCardProps= {
  title: string,
  initialCount?: number
}

export default function CounterCard({title, initialCount = 0}:CounterCardProps) {
  const [count, setCount] = useState<number>(0);

  useEffect(() => { 
    // update the count state variable with the initialCount value whenever initialCount changes
    setCount(initialCount);
  }, [initialCount])

  const increment = () => {
    setCount(count + 1);
  }

  const reset = () => {
    setCount(0);
  }

  return (
    <div aria-label="counter card">
      <h2>{title}</h2>

      <p>
        Count: <span aria-label="count-value">{count}</span>
      </p>

      <button type = "button" onClick = {increment}>Increment</button>
      <button type = "button" onClick = {reset}>Reset</button>

    </div>
  )
}
