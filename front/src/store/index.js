import Vue from 'vue'
import Vuex from 'vuex'

import clientApp from './modules/clientApp'
import login from './modules/login'
import cas from './modules/cas'
//use vuex
Vue.use(Vuex);


// Export module
export default new Vuex.Store({
  modules:{
    cas,
    login,
    clientApp
  }
})
