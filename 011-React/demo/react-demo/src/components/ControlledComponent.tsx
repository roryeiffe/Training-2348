import React from 'react'
import { useState } from 'react'

// define the structure of our data:
type User = {
  username: string,
  password: string
}

export default function ControlledComponent() {
  // Set up the starting state (empty strings for the fields)
  const [user, setUser] = useState<User>({username: '', password: ''});

  // This onChangeHandler can be used with any text input fields
  // To make this work though, we need to specify which field we are updating
  const onChangeHandler = (event:React.ChangeEvent<HTMLInputElement>) => {
    event.preventDefault();
    // Whenever a change is made to the input, we update the state accordingly:
    // console.log(event.target.value);hello
    // How do we access the field name from the event object?
    // console.log(event.target.name);

    // update the state with this new field/value:
    // make a copy of the user:
    // const userCopy:any = {
    //   username: user.username,
    //   password: user.password
    // }

    // // set the field that we want to change:
    // userCopy[event.target.name] = event.target.value;

    // // set this back to the state:
    // setUser(userCopy);

    // "better" way to do this:
    setUser({
      // use the spread operator to fill in the existing copies
      ...user,
      // assign whatever value was changed:
      [event.target.name]: event.target.value
    }
    )
  }

  const onSubmitHandler = (event:React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    // validation:
    if(!user.username) alert("Username is required.");
    if(!user.password) alert("Password is not required");
    console.log("Sending user to API call");
    console.log(user);
  }

  return (
    <div>

    <form onSubmit ={onSubmitHandler}>
      <label>Username</label>
      <input name = 'username' onChange={onChangeHandler} value={user.username}/>
      <label>Password</label>
      <input name = 'password' onChange={onChangeHandler} type='password' value = {user.password}/>
      <button type = 'submit'>Submit</button>


    </form>

    <div>State (This should display the data from state):
      <h3>
        Username: {user.username}
      </h3>
      <h3>
        Password: {user.password}
      </h3>
    </div>
    </div>
  )
}
