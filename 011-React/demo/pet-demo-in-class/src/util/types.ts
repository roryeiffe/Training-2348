import { createContext } from "react";

// define the types for our entities:
export interface Pet {
  id?: number,
  name: string,
  species: string,
  food: string
}

export interface Person {
  id?: number,
  name: string,
  password: string
}

// Define Types for our Context:
export type AuthContextValue = {
  // define the shape of the value we're keeping track of
  user: Person | null;
  // login function takes in the params and returns a promise:
  login: (name: string, password: string) => Promise<void>;
  // logout doesn't need to call the API, rather just set the user back to null
  logout: () => void;
}

// create + export the context:
export const AuthContext = createContext<AuthContextValue | null> (null);