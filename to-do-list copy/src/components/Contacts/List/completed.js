import {useState} from 'react'

function Completed({job}) {

    const [show, setShow] = useState(false)

    return (
        <div>
            <button onClick={()=>{setShow(true)}}>Completed</button>
            {show &&
                <div>
                    <ul>{job.map((el, i) =>
                        <li key={i}>
                               {el.line === true && el.name}
                        </li>)}
                    </ul>
                </div>
            }
        </div>
    )
}

export default Completed
