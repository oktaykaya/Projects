import {useState, useEffect} from 'react'
import { Link, Route, useParams, Routes } from 'react-router-dom'
import axios from 'axios'

function Users() {

    const { id } = useParams();
    const[isLoading, setIsLoading] = useState(true)
    const[users, setUsers] = useState([])

    useEffect(() => {
        axios('https://jsonplaceholder.typicode.com/users').then((res) => setUsers(res.data)).finally(() => setIsLoading(false))
    },[]);


  return (
    <div>
    <h2>Users</h2>
    {isLoading && <div>Loading..</div>}
    <ul>
        {users.map((user)=>(
            <li key={user.id}>
                <Link to = {`/user/${user.id}`}>{user.name}</Link>
            </li>
        ))}
    </ul>

    <Routes>
        <Route exact path={id}>
            Please select a user  
        </Route>
    </Routes>
  </div>
  )
}

export default Users
