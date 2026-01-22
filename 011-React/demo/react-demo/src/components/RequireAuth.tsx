import React from 'react'
import { Navigate, Outlet } from 'react-router-dom'

type RequireAuthProps = {
  isAuthed: boolean
}

export default function RequireAuth({isAuthed}:RequireAuthProps) {
  // optionally, check if prop is passed in. If not, access the user
  // from the context
  
  
  // Outlet returns child component based on path
  if(isAuthed) return <Outlet/>
  // If this is rendered, will navigate back to the main page "/"
  else return <Navigate to = "/"/>
}
