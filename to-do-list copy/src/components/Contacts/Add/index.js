import { useState, useEffect } from 'react'



function Add({ addJob, job }) {
    //verilrin yazılması için bir state
    const [todo, setTodo] = useState({ name: "", line: false })


    //state gelen veriler yazmak için
    const onChangeInput = (e) => {
        setTodo({ ...todo, [e.target.name]: e.target.value })
    }

    //
    const onSubmit = (e) => {
        e.preventDefault();

        if (!todo.name) return

        console.log("job.lentgh  : ", job.length)
        addJob([...job, {id: job.length + 1, ...todo  }])

        //ekleme yapıldıktan sonra tekrar boaltmak için bunu kullanmak için value değerini de kullanmak gerekir
        setTodo({ name: "" })

        console.log(todo)
    }

    return (

        <form onSubmit={onSubmit}>
            <div>
                <input name='name' value={todo.name} placeholder='What needs to be done ?' onChange={onChangeInput}></input>
            </div>
            <div>
                <button>ADD</button>
            </div>
        </form>

    )
}

export default Add
