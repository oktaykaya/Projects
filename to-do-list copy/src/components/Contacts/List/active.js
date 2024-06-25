import { useState } from 'react'

function Active({ job }) {
    const [show, setShow] = useState(false)

    return (
        <div>
            <button onClick={() => { setShow(true) }}>Active</button>
            {show &&
                <div>
                    <ul>{job.map((el, i) =>
                        <li key={i}>
                            {el.line === false && el.name}
                        </li>)}
                    </ul>
                </div>
            }
        </div>
    )
}

export default Active
