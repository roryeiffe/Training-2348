import React, { useEffect, useState } from 'react'
import axios from 'axios'

// We set up a type to represent the data we're getting from the API
// We only need to specify the fields we need
// as long as the incoming data as at least these fields (could have more)
// then the type-checking should work
type Pokemon = {
  name: string,
  sprites: {
    front_default:string
  },
  height: number,
  weig: number
}

export default function AxiosExample() {
  // used to track our pokemon object
  const [pokemon, setPokemon] = useState<Pokemon | null>(null);
  // error-checkers, used to provide some insight based on the state of the request
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null> (null);

  // to use axios, we usually want to be in a useEffect, especially
  // if that data is going to be rendered on the page:
  useEffect(() => {
  
    setLoading(true); // assume we are still loading until the request finishes
    setError(null); // assume no errors for now

    axios.get<Pokemon>("https://pokeapi.co/api/v2/pokemon/pikachu")
    .then(response => {
      console.log(response.data)
      // update the view:
      setPokemon(response.data);

      // now it should be done loading:
      setLoading(false);
  })
    .catch(error => {
      console.error(error)
      setError("Something went wrong when fetching the pokemon!");
    })
  }, [])

  // Return different tsx based on our states:
  if(loading) return <p>Loading...</p>

  if(error) return <p style={{color: 'red'}}>{error}</p>

  if(!pokemon) return <p style={{color: 'red'}}>Pokemon is null</p>


  return (
    <div>
      <h2>{pokemon.name}</h2>
      <img src = {pokemon.sprites.front_default} alt={pokemon.name}/>
      <p>Weight: {pokemon.weig}</p>
      <p>Height: {pokemon.height}</p>
      {/* Optional Exercise: Include an input form that takes in a name and returns that specific pokemon */}
    </div>
  )
}
