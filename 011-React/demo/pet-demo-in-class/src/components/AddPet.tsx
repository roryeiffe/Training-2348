import React, { useState } from 'react'
import { Pet } from '../util/types';
import base_url from '../util/url';
import axios from 'axios';
import styles from './PetItem.module.css';
import { useNavigate } from 'react-router-dom';

export default function AddPet() {

  const navigate = useNavigate();

  const [pet, setPet] = useState<Pet>({ name: '', food: '', species: '' });

  const onChangeHandler = (event: React.ChangeEvent<HTMLInputElement>) => {
    // If pet isn't defined yet, return
    if (!pet) return;
    setPet({
      ...pet,
      [event.target.name]: event.target.value
    })
  }

  const onInsertHandler = () => {
    if (!pet.name || !pet.food || !pet.species) {
      alert("Must have values for each field");
      return;
    }
    axios.post(`${base_url}/pets`, pet)
      .then(response => {
        console.log(response.data);
        alert(`Pet added successfully! Generated id is : ${response.data.id}`);
        navigate('/');
      })
      .catch(error => console.error(error));
  }

  return (
    <div className={styles.wrapper}>
      <h2 className={styles.title}>Add Pet</h2>

      <form className={styles.form}>
        <div className={styles.field}>
          <label className={styles.label} htmlFor='name'>Pet Name</label>
          <input className={styles.input} id="name" name="name" value={pet.name} onChange={onChangeHandler} />
        </div>
        <div className={styles.field}>
          <label className={styles.label} htmlFor='species'>Species</label>
          <input className={styles.input} id="species" name="species" value={pet.species} onChange={onChangeHandler} />
        </div>
        <div className={styles.field}>
          <label className={styles.label} htmlFor='food'>Food</label>
          <input className={styles.input} id='food' name='food' value={pet.food} onChange={onChangeHandler} />
        </div>

        <div className={styles.actions}>
          <button className={`${styles.button} ${styles.primary}`} type='button' onClick={(e) => {
            // prevent the default behavior before going into the callback function
            e.preventDefault();
            onInsertHandler();
          }}>AddPet</button>
        </div>
      </form>

    </div>
  )
}
