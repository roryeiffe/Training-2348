import React from 'react'

type HookChildProps = {
  // callback function:
  onClickCB(): void
}

export default function HookChild({onClickCB}:HookChildProps) {
  return (
    <div>
      <button onClick = {onClickCB}>Double Count</button>
      </div>
  )
}
