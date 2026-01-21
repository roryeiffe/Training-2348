import React from 'react'
import {useForm, SubmitHandler} from "react-hook-form"

// Define the shape of our login data:
type LoginForm = {
  email: string,
  password: string
}

export default function Login() {

  const {
    register, // register - let us inject the React-Hook-Form logic into the input fields
    handleSubmit, // wrap around the submit function we set up, ensuring the data is valid before 
    formState: {errors, isSubmitting, isValid} // errors contain information about validation errors, 
    // also have isSubmitting and isValid booleans to keep track of form state
  } = useForm<LoginForm> ({
    mode: "onBlur", // configures when to run validation. onBlur should run whenever our cursor leaves an input field
    defaultValues: {
      email: "",
      password: ""
    }
  })

  const onSubmit: SubmitHandler<LoginForm> = async (data) => {
    console.log(data.email, data.password);
  }

  return (
    // Makes it so when we  try tosubmit, the data must be 
    // valid before actually moving on to the submit function:
    <form onSubmit={handleSubmit(onSubmit)}>
      <label>Email</label>
      <input type = 'email' {...register("email", {required: "Email is required"})}/>
      {/* If there are email errors, render them: */}
      {errors.email && <p>{errors.email.message}</p>} 

      <label>Password</label>
      <input type = 'password' {...register("password", 
      {required: "Password is required", 
        minLength: {value: 8, message: "Password must be at least 8 characters"},})}/>
      {errors.password && <p>{errors.password.message}</p>}

        {/* Disable the button if it's still submitting or if it's not valid: */}
      <button type = 'submit' disabled={isSubmitting || !isValid}>
        Sign In
      </button>

    </form>
  )
}
