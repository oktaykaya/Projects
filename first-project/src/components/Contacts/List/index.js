import { useState } from 'react'

function List({ contacts, setConcats }) {

  const [filterText, setFilterText] = useState("")

  //contactsden aldığımız itemleri önce parçalıyoruz fullname ya da phone number olarak bunlardan herhangi biri bizim aradığımıza eşitse diyoruz
  const filtered = contacts.filter((item) => {
    return Object.keys(item).some((key) =>
      item[key].toString().toLowerCase().includes(filterText.toLocaleLowerCase())
    )
  })

  return (
    <div>
      <input placeholder='Filter Contact' value={filterText} onChange={(e) => setFilterText(e.target.value)}></input>
      <ul className='list'>{filtered.map((el, i) => (
        <li key={i}>
          <span style={{ textDecoration: el.line ? 'line-through' : "", cursor:"pointer" }}
            onClick={() => {
              const newContacts = contacts.map((contact) => contact.fullname === el.fullname ? { ...contact, line: !contact.line } : contact)
              setConcats(newContacts)
            }}
          >{el.fullname}</span>
          <span>{el.phone_number}</span>
        </li>
      ))}</ul>
      <p>
        Total Contacts ({filtered.length})
      </p>
    </div>
  )
}

export default List
