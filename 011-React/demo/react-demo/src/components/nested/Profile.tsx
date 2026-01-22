import React from 'react'
import { Link, Outlet } from 'react-router-dom'

export default function Profile() {
  return (
    <>
    
      <div>Profile</div>

      <div>
        <Link to = "/profile/preferences">Show Preferences</Link>
        <Link to = "/profile/settings">Show Settings</Link>
      </div>

      {/* Renders the matching child route based on the path  */}
      <Outlet/> 



    </>

  )
}
