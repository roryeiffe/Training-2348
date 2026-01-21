import React, { useState } from 'react'
import { Person } from '../util/types'
import useAuth from '../util/useAuth'

export default function Login() {
  const [loginFormData, setLoginFormData] = useState<Person>({name: '', password: ''})

  // const context = useAuth();
  // context.login()
  // retrieve the login function from our Auth hook:
  const {login} = useAuth();

  const onChangeHandler = (event: React.ChangeEvent<HTMLInputElement>) => {
    setLoginFormData({
      ...loginFormData,
      [event.target.name]: event.target.value
    })
  }

  const onSubmitHandler = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    // send login credentials to back-end, utilizing the login function from our context
    console.log(loginFormData);
    login(loginFormData.name, loginFormData.password);
  }

  return (
    <div>
      <form onSubmit = {onSubmitHandler}>
        <div>
          <label htmlFor="username">Username</label>
          <input id = "username" value = {loginFormData.name} onChange = {onChangeHandler} name = "name"/>
        </div>
        <div>
          <label htmlFor="password">Password</label>
          <input type = 'password' id = "password" value = {loginFormData.password} onChange = {onChangeHandler} name = "password"/>
        </div>
        <div>
          <button type = 'submit'>Log In</button>
        </div>
      </form>
    </div>
  )
}
