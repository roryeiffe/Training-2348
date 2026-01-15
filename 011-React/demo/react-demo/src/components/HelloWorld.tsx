import React from "react";

// One way to handle props is to specifically set up the type:
type HelloWorldProps = {
  message: string,
  author?: string,
}

export default function HelloWorld({message, author}: HelloWorldProps) {

  console.log(message);

  return (
    <div>
      <h1>{message}</h1>
      <h2>By {author || "Anonymous"}</h2>

    </div>

  )
}

