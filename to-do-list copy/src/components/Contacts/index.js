import { useState, useEffect } from 'react'
import Add from './Add'
import List from './List'
import Feature from './Feature'

import Completed from './List/completed'
import Active from './List/active'

function Todo() {

  const [job, setJob] = useState([
    {
      id: 1,
      name: "Ders Çalış",
      line: false
    },
    {
      id: 2,
      name: "Spora Git",
      line: false
    }
  ])

  //add den obje return ediyo buraya burda setjoba giriyo setjabo addjobdan dönen todo ile geliyo o da job ı etkiliyo ve biz jobı görüyoruz
  useEffect(() => {
    console.log(job)
  }, [job])



  return (
    <div>
      TODOS
      <Add addJob={setJob} job={job} />
      <List setJob={setJob} job={job} />
      <Feature job={job} />
      <Completed job={job} />
      <Active job={job} />
      
    </div>
  )
}

export default Todo
