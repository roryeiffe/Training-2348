import axios from 'axios'
import React, { useEffect, useState } from 'react'
import base_url from '../util/url'
import { Pet } from '../util/types';
import styles from './Pets.module.css';
import { useNavigate } from 'react-router-dom';

// This component should render all pets from the database
// in a table format. Optionally include a link to redirect to a page
// fully dedicated to that pet
export default function Pets() {
  const [pets, setPets] = useState<Pet[]>([]);

  const navigate = useNavigate();

  useEffect(() => {
    // start by fetching data
    const full_url = `${base_url}/pets`
    axios.get(full_url)
      .then(response => {
        console.log(response.data)
        setPets(response.data);
      })
      .catch(error => console.error(error));
  }, [])

  // Upon clicking the button, we navigate to the pet page where we can edit/delete/adopt:
  const onClickHandler = (id:number) => {
    navigate(`/pets/${id}`)
  }

  return (
    <div className = {styles.wrapper}>

    <table className = {styles.table}>
      <thead>
        <tr className = {styles.headerRow}>
          <th>ID</th>
          <th>Name</th>
          <th>Species</th>
          <th>Food</th>
          <th>Navigation Link</th>
        </tr>
      </thead>
      <tbody>
        {pets.map(pet => (
          <tr className={styles.row} key = {pet.id}>
            <td className={styles.cell}>{pet.id}</td>
            <td className={styles.cell}>{pet.name}</td>
            <td className={styles.cell}>{pet.species}</td>
            <td className={styles.cell}>{pet.food}</td>
            <td><button className={styles.btn} onClick = {
              (e) => {
                e.preventDefault();
                if(!pet.id) alert("Can't navigate");
                else onClickHandler(pet.id);
              }
            }>View Pet</button></td>
          </tr>
        ))}
      </tbody>
    </table>
    </div>
   
  )
}

//  <div>
//       {pets.map(pet => 
//         <h1>{pet.name}</h1>
//       )}
//     </div>