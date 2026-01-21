import React, {useContext} from 'react'
import { AuthContext } from './types';

// This is a re-usable custom hook that gives us the context values
// when we invoke the hook:
export default function useAuth() {

  // Retrieving our context from AuthContext
  const context = useContext(AuthContext);

  // error-handling, check if we're outside of the provider:
  if(!context) {
    throw new Error("context must be used within AuthProvider")
  }

  return context;
}
