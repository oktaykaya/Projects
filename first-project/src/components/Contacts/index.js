import {useState, useEffect} from 'react'
import List from './List'
import Form from './Form'
import "./style.css"


function Contacts() {

  const [contacts1, setConcats] = useState([

    {
      fullname: "Oktay",
      phone_number: "123",
      line: false
    },
    {
      fullname: "Efe",
      phone_number: "123321",
      line: false
    },
    {
      fullname: "Furkan",
      phone_number: "213123",
      line: false
    }
  ])

  useEffect(() => {
    console.log(contacts1)
  },[contacts1])

  //addcontact ile verileri alıyoruz ve setcontact ile arraye yazıyoruz
  //contacts ile olnları tekrar gönderiyoruz ve olanları tekrar alıyoruz

  return (
    
    <div id='container'>
      Contacts
      <List contacts={contacts1} setConcats={setConcats}></List>
      <Form addContact={setConcats} contacts={contacts1} />
    </div>
  )
}

export default Contacts
