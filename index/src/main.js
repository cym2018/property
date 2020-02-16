import Vue from 'vue'
import App from './App.vue'
import axios from 'axios'
import ViewUI from 'view-design';
import 'view-design/dist/styles/iview.css';

Vue.config.productionTip = false;
Vue.use(ViewUI);
Vue.prototype.axios = axios;
export let app=new Vue({
  render: h => h(App),
}).$mount('#app');