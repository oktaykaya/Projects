import React from 'react'

function Feature({job}) {
    
    const left = job.length
  
    return (
    <div>
      <hr/>
      {left} items left
    </div>
  )
}

export default Feature
