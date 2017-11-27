// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store/index.js'

import axios from './util/axios_conf'

import * as custom from './filters/customFilters'


Object.keys(custom).forEach(key => {
  Vue.filter(key, custom[key])
})

Vue.prototype.axios = axios
Vue.config.productionTip = false
Vue.use(ElementUI)


router.beforeEach((to, from, next) => {
  let token = window.sessionStorage.getItem('token');
  if(to.fullPath!="/"&&  (!token || token === null))
  {
    next('/')
  }else
  {
    next();
  }

});


/* eslint-disable no-new */
new Vue({
  store,
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
