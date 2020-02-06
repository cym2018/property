import Vue from 'vue'
import App from './App.vue'
import Login from './Login.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')

new Vue({
  render: h => h(Login),
}).$mount('#login')