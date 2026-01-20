import React from 'react'
import { Link } from 'react-router-dom'
import styles from './Navbar.module.css';

export default function Navbar() {
  return (
    <nav className = {styles.navBar}>
      <Link className = {styles.navItem} to = "/">Pets</Link>
      <Link className = {styles.navItem} to = "/add">Add Pet</Link>
    </nav>
  )
}
