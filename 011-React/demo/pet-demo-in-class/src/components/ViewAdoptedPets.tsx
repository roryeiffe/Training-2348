import React, {useEffect, useState} from 'react'
import { useNavigate } from 'react-router-dom'
import useAuth from '../util/useAuth';
import { Pet } from '../util/types';
import base_url from '../util/url';
import axios from 'axios';
import styles from './Pets.module.css';

export default function ViewAdoptedPets() {
  const navigate = useNavigate();

  // Take in the current user from the useAuth hook:
  const {user} = useAuth();

  const [pets, setPets] = useState<Pet[]>([]);

  useEffect(() => {
    // redirect away from this page if not logged in:
    if(!user) navigate('/');
    else {
      axios.get(`${base_url}/persons/${user.id}/pets`)
      .then(response => setPets(response.data))
      .catch(error => console.error(error));
    }
  }, [])


  return (
    <div className = {styles.wrapper}>
    <table className = {styles.table}>
      <thead>
        <tr className = {styles.headerRow}>
          <th>ID</th>
          <th>Name</th>
          <th>Species</th>
          <th>Food</th>
        </tr>
      </thead>
      <tbody>
        {pets.map(pet => (
          <tr className={styles.row} key = {pet.id}>
            <td className={styles.cell}>{pet.id}</td>
            <td className={styles.cell}>{pet.name}</td>
            <td className={styles.cell}>{pet.species}</td>
            <td className={styles.cell}>{pet.food}</td>
          </tr>
        ))}
      </tbody>
    </table>
    </div>
   
  )
}
