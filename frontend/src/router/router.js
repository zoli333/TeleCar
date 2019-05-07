import Vue from 'vue'
import Router from 'vue-router'

import Cars from '@/pages/Cars.vue'
import AddCar from '@/pages/AddCar.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/cars',
      name: 'Cars',
      component: Cars
    },
    {
      path: '/add-car',
      name: 'addCar',
      component: AddCar
    }
  ]
})
