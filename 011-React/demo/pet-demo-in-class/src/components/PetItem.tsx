import axios from 'axios';
import React, { useEffect, useState} from 'react'
import { useParams, useNavigate } from 'react-router-dom'
import base_url from '../util/url';
import { Pet, Person} from '../util/types';
import styles from './PetItem.module.css'
import useAuth from '../util/useAuth';

// This component will represent an individual pet entity
// It will display information about the pet, let us edit/delete the pet
// It will also include a button for adopting (include some error checking)
export default function PetItem() {
  // We will take the pet id from the path and use it to fetch the correct information
  const params = useParams();
  const id = params.id;

  // Setting up our pet state
  const [pet, setPet] = useState<Pet | null>(null);

  // retrieve our context from our custom hook:
  const context = useAuth();

  // store the result of useNavigate in navigate
  const navigate = useNavigate();

  useEffect(() => {
    axios.get(`${base_url}/pets/${id}`)
    .then(response => setPet(response.data))
    .catch(error => console.error(error));
  }, [])

  const onChangeHandler = (event:React.ChangeEvent<HTMLInputElement>) => {
    // If pet isn't defined yet, return
    if(!pet) return;
    setPet({
      ...pet,
      [event.target.name]: event.target.value
    })
  }

  // Note that we didn't pass in an event here because the event.preventDefault() is handled
  // in-line down in the TSX
  const onUpdateHandler = () => {
    // this function should send a PUT request to our back-end
    // With POST and PUT requests, we put the request body as the second argument
    axios.put(`${base_url}/pets`, pet)
    .then(response => {
      // Let the user know the update was successful:
      alert("Update was successful.")
      // re-route to the main page:
      navigate('/');
  })
    .catch(error => console.error(error));
  }

  const onDeleteHandler = () => {
    if(!pet) {
      alert("Pet is not defined properly");
      return;
    }
    axios.delete(`${base_url}/pets/${pet.id}`)
    .then(response => {
      alert("Deletion was successful");
      // go back to the main pets page:
      navigate("/");
    })
    .catch(error => console.error(error));
  }

  // Adopt pet, but we need to make sure the pet isn't already taken/claimed
  const onAdoptHandler = async () => {
    // ensure we are logged in before trying to adopt:
    if(!context.user) return;
    // We can use await to "wait" for the promise to fulfill before working with the data
    if(!pet) return;

    // get the owner information from the back-end:
    const jsonResponse = await axios.get(`${base_url}/pets/${pet.id}/owner`)
    let owner:Person = jsonResponse.data;
    // check, ensure that the corresponding owner is shelter
    if(owner.id === 1) {
      // TODO: Fetch this from our current logged in state
      let new_owner_id = context.user.id;
      try {
        // perform the adoption:
        await axios.put(`${base_url}/persons/${new_owner_id}/pets/${pet.id}`)
        // upon success, redirect to the main page:
        alert("Pet was adopted successfully!");
        navigate('/');
      }
      catch(error) {
        console.error(error);
      }
    }
    else {
      alert("Pet is already adopted!");
    }

  }

  return pet ? (
    <div className={styles.wrapper}>
      <h2 className={styles.title}>Pet View:</h2>

      <form className = {styles.form}>
        <div className = {styles.field}>
          <label className = {styles.label} htmlFor='name'>Pet Name</label>
          <input className = {styles.input} id = "name" name = "name" value = {pet.name} onChange={onChangeHandler}/>
        </div>
        <div className = {styles.field}>
          <label className = {styles.label} htmlFor='species'>Species</label>
          <input className = {styles.input} id = "species" name="species" value = {pet.species} onChange={onChangeHandler}/>
        </div>
        <div className = {styles.field}>
          <label className = {styles.label} htmlFor='food'>Food</label>
          <input className = {styles.input} id='food' name = 'food' value={pet.food} onChange={onChangeHandler}/>
        </div>

        <div className = {styles.actions}>
          <button className = {`${styles.button} ${styles.primary}`} type='button' onClick={(e) => {
            // prevent the default behavior before going into the callback function
            e.preventDefault();
            onUpdateHandler();
          }}>Update Pet</button>

          <button className = {`${styles.button} ${styles.danger}`} type='button' onClick={(e) => {
            e.preventDefault();
            onDeleteHandler();
          }}>Delete Pet</button>

          <button className = {`${styles.button} ${styles.primary}`} type='button' onClick={(e) => {
            e.preventDefault();
            onAdoptHandler();
          }}>Adopt Pet</button>

        </div>
      </form>

    </div>
  )
  :
  <h1>Pet Not found</h1>
}
