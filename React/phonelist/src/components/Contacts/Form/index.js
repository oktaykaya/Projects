import {useState, useEffect} from 'react'

const initialFormValue = {fullname:"", phone_number:"" }

function Form({addContact, contacts}) {

  const[form, setForm] = useState(initialFormValue)

  useEffect(() => {
    setForm(initialFormValue)
  },[contacts])
  
  //formun name değerine girilen value değerini atamakta eski değerler tutulurken yenileri gelir
  const onChangeInput = (e) => {
    setForm({...form, [e.target.name]: e.target.value})
  }


  const onSubmit = (e) => {
    e.preventDefault(); // form yapısının defaultunu bozarak direkt sayfayı yenilememesini sağlıyoruz

    //boş değerler girilmesi durumunda kakbul etmemesini sağlar
    if(form.fullname === "" || form.phone_number === ""){
      return false;
    }
    addContact([...contacts,{...form, line:false}])
    console.log(form)
  }

  return (
    <form>
      <div>
        <input name='fullname' placeholder='Full Name' value={form.fullname} onChange={onChangeInput}>
        </input>
      </div>
      <div>
        <input name="phone_number" placeholder='Phone Number' value={form.phone_number} onChange={onChangeInput}>
        </input>
      </div>
      <div className='btn'>
        <button onClick={onSubmit}>Add</button>
      </div>
    </form>
  )
}

export default Form
