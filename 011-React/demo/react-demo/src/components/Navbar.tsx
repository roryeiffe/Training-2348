import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar() {
  return (
    <nav>
      <ul>
        <li>
          <Link to='/'>Welcome</Link>
        </li>
        <li>
          <Link to='/hooks'>Hooks</Link>
        </li>
        <li>
          <Link to='/events'>Events</Link>
        </li>
        <li>
          <Link to = "/controlled">Controlled Component</Link>
        </li>
        <li>
          <Link to = "/uncontrolled">Uncontrolled Component</Link>
        </li>
        <li>
          <Link to = "/axios">Axios Example</Link>
        </li>
        <li>
          <Link to = "/formhook">React Hook Form Example</Link>
        </li>
      </ul>
    </nav>
  )
}
