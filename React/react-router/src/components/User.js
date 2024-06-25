import {Link, useParams} from 'react-router-dom'
import {useState,useEffect} from 'react'
import axios from 'axios'

function User() {

    const[isLoading, setIsLoading] = useState(true)
    const {id} = useParams();
    const[user, setUser] = useState({})
    

    useEffect(()=>{
        axios(`https://jsonplaceholder.typicode.com/users/${id}`).then(res => setUser(res.data)).finally(()=>setIsLoading(false))
    },[id])

    
  return (
    <div>
        <h2>User Detail</h2>
        {isLoading && <div>Loading...</div>}
        {!isLoading && <code>{JSON.stringify(user)}</code>}
        <br></br>
        <br></br>
        <Link to={`/user/${parseInt(id)+1}`}>Next User</Link>
    </div>
  )}

export default User
