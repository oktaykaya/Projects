import React from 'react'
import { Formik, Field, Form, useFormik } from 'formik';
import validationSchema from './validation';

function Signup() {
    const {handleSubmit, handleChange,handleBlur, values, errors, touched} = useFormik({
        initialValues: {
          firstName: '',
            lastName: '',
            email: '',
            gender:'',
            hobies:'',
            country:'',
            password:'',
            passwordConfirm:''
        },
        onSubmit: values => {
          console.log(values);
        },
        validationSchema,//yup için
      });
  return (
    <div>
      <h1>Sign Up</h1>
          <form onSubmit={handleSubmit}>
        <label className='block' htmlFor="firstName">First Name</label>
        <input name='firstName' placeholder='Name' value={values.firstName} onChange={handleChange}></input>
        <br/>
        <br/>
        <label className='block' htmlFor="lastName">Last Name</label>
        <input name='lastName' placeholder='Last Name' onChange={handleChange}></input>
        <br/>
        <br/>
        <label className='block' htmlFor="email">Email</label>
        <input
          id="email"
          name="email"
          placeholder="example@gmail.com"
          type="email"
          onChange={handleChange}
          onBlur={handleBlur}// fokus olunup olunmadığını, sekmeden ayrılıp ayrılmadığımızı kontrol eder.
        />
        {errors.email && touched.email && <div className='error'>{errors.email}</div>}
        <br/>
        <br/>
        <label className='block' htmlFor='password' >password</label>
        <input name='password' placeholder='*****' onChange={handleChange} onBlur={handleBlur}/>
        {errors.password && touched.password && <div className='error'>{errors.password}</div>}
        <br/>
        <br/>
        <label className='block' htmlFor='passwordConfirm'>password confirm</label>
        <input name='passwordConfirm' placeholder='*****' onChange={handleChange} onBlur={handleBlur}/>
        {errors.passwordConfirm && touched.passwordConfirm && <div className='error'>{errors.passwordConfirm}</div>}
        <br/>
        <br/>
        <div className='gender' >
            <label className='radio' htmlFor='gender'>Male</label>
            <input type='radio' name='gender' value='male' checked={values.gender === 'male'} onChange={handleChange}></input>

            <label className='radio' htmlFor='gender'>Female</label>
            <input type='radio' name='gender' value='female' checked={values.gender === 'female'} onChange={handleChange}></input>
      
            <label className='radio' htmlFor='gender'>I don't want to specify</label>
            <input type='radio' name='gender' value='both' checked={values.gender === 'both'} onChange={handleChange}></input>
        </div>
        <br/><br/>
         <div className='checkbox'>
            Football
            <input type='checkbox' name='hobies' value='football' onChange={handleChange}></input>
         </div>
         <div className='checkbox'>
            Chess
            <input type='checkbox' name='hobies' value='Chess' onChange={handleChange}></input>
         </div>
         <br/>
         <br/>
         <select name='country' onChange={handleChange}>
         <option value=''>Empty</option>
          <option value='Türkiye'>Türkiye</option>
          <option value='England'>England</option>
          <option value='USA'>USA</option>

         </select>
         <br/>
         <br/>
        <button type="submit">Submit</button>
      </form>
    </div>
  )
}

export default Signup
