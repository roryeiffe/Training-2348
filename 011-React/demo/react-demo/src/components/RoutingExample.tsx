import React from 'react'
import { useNavigate, useParams } from 'react-router-dom'

export default function RoutingExample() {
  // useNavigate() returns the function we want, so we will actually
  // be calling navigate(path) to redirect:
  const navigate = useNavigate();

  // should extract the value from the url
  const {id}= useParams<{id: string}>();
  console.log(id);

  const handleClick = () => {
    // handle logic we need before redirecting (ex: validation)
    navigate('/hooks');

  }

  return (
    <>
    <div>RoutingExample</div>
    <h1>Taken from the path: {id}</h1>
    <button onClick={handleClick}>Go to Hooks</button>
    </>
  )
}
