import router from './router/router'
import { api } from './api'
import store from './store/store'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'font-awesome/css/font-awesome.css'

import './assets/css/paper-dashboard.css'
import './assets/js/paper-dashboard.js'

import Vue from 'vue'
import App from './App.vue'
import BootstrapVue from 'bootstrap-vue'

Vue.use(BootstrapVue)

Vue.config.productionTip = false

Vue.prototype.axios = api

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
