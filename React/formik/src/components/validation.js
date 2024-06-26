import { object, string, number, date, InferType, ref } from 'yup';

let validations = object({
  firstName: string().required('zorunlu alan'),
  email: string().email('Geçerli bir e-mail giriniz').required('zorunlu alan'),
  password: string().min(5, 'parola en az 5 karakter olmalıdır').required('zorunlu alan'),
  passwordConfirm: string().oneOf([ref('password')], 'parolalar aynı olmalıdır').min(5,'parola en az 5 karakter olmalıdır').required('zorunlu alan'),// oneof ile passwordun aynısı olup olmadığı kontrol ediliyor
});

export default validations;