import React, { useState } from 'react'
import { AuthContext, AuthContextValue, Person } from './types'
import axios from 'axios';
import base_url from './url';
import { useNavigate } from 'react-router-dom';

// Provider - everything rendered inside of this will have access the context
// So, we pass in a children prop to be rendered down below:
export default function AuthProvider({children}: {children : React.ReactNode}) {
  // use useState to keep track of the logged in user, default to null:
  const [user, setUser] = useState<Person | null> (null);

  const navigate = useNavigate();

  const login = async (name:string, password: string) => {
    try {
      let response = await axios.post(`${base_url}/login`, {username: name, password});
      // set the result of the axios call to our user state
      setUser(response.data);
      // redirect to home page after log-in:
      navigate('/');
    } catch(error) {
      console.error(error);
      alert("Login Attempt Failed");
    }
  }


  // logout function just nullifies the user object:
  const logout = () => {
    setUser(null);
  }

  const value: AuthContextValue = {
    // need a user object
    user,
    // login function
    login,
    // logout function:
    logout
  }
  
  return (
    <AuthContext.Provider value = {value}>
      {children}
    </AuthContext.Provider>
  )
}
