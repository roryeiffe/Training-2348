import React from 'react'

const HelloWorld2:React.FC<{title: string}> = ({title}) => {
  return (
    <div>
      {title}
    </div>
  )
}

export default HelloWorld2;