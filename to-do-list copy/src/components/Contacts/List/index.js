import {useState} from 'react'

function List({ job, setJob }) {

  const[show, setShow] = useState(false)

  return (
    <div>
      <button onClick={()=>{setShow(true)}}>ALL</button>
      {show&&  
      <ul>{job.map((el, i) =>
        <li key={i}>
          <span style={{ textDecoration: el.line ? 'line-through' : "", cursor: "pointer" }} onClick={() => {
            const newJob = job.map((item) => item.name === el.name ? { ...item, line: !item.line }: item)
            setJob(newJob)
          }}>{el.name}</span>
        </li>)
      }
      </ul>}
     
    </div>
  )
}

export default List
