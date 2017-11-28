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




import './assets/libs/bootstrap/js/jquery-3.2.1.js'
import './assets/libs/bootstrap/js/bootstrap.js'
import './assets/libs/bootstrap-table/bootstrap-table.js'
import './assets/libs/bootstrap-table/bootstrap-table-zh-CN.js'



import './assets/libs/bootstrap/css/bootstrap.css';
//import './assets/libs/css/font-awesome.min.css';
import './assets/libs/bootstrap-table/bootstrap-table.css';
import './assets/libs/font-awesome-4.7.0/css/font-awesome.min.css';

//自定义过滤器
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
