import React from 'react'
import { Link, useNavigate } from 'react-router-dom'
import styles from './Navbar.module.css';
import useAuth from '../util/useAuth';

export default function Navbar() {
  const navigate = useNavigate();

  const {logout, user} = useAuth();

  const logoutHandler = () => {
    logout();
    navigate('/');
  }


  return (
    <nav className = {styles.navBar}>
      <Link className = {styles.navItem} to = "/">Pets</Link>
      <Link className = {styles.navItem} to = "/add">Add Pet</Link>
      {user // check the truthiness of this value
      ? 
      // if true, render the logout button
      <button onClick={logoutHandler} className = {styles.navItem}>Logout</button>
      : 
      // if false, render the login button:
      <Link className = {styles.navItem} to = "/login">Login</Link> }

      <Link className = {styles.navItem} to = "/adopted">View Adopted Pets</Link>
    </nav>
  )
}
