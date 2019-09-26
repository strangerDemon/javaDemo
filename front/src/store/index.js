import Vue from 'vue'
import Vuex from 'vuex'

import clientApp from './modules/clientApp'
import login from './modules/login'

//use vuex
Vue.use(Vuex);


// Export module
export default new Vuex.Store({
  modules:{
    login,
    clientApp
  }
})
