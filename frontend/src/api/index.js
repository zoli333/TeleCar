import axios from 'axios'

export const api = axios.create({
  // baseURL: process.env.NODE_ENV === 'development' ? 'https://10.0.7.58:7503/vilma/api' : '/vilma/api',
  baseURL: process.env.NODE_ENV === 'development' ? 'http://localhost:8090/' : '/vilma/api'
  // headers: {
  //   Authorization: VueCookie.get('token') ? 'Bearer ' + VueCookie.get('token') : null
  // }
})
