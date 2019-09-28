import HttpUtils  from '../../utils/httpUtils/axiosUtils'
import router from '@/router'
/**
 * 变量参数
 */
const state = {
  userInfo:{//用户信息
    account:"",
    realName:""
  },
}

/**
 * Getters
 * @type {Object}
 */
const getters = {}

/**
 * Mutations
 *
 * @type {Object}
 */
const mutations = {
  userLogin (state,info) {
    HttpUtils.post('User/Login', info).then(
      function (resp) {
        state.userInfo=resp;
        router.push("/");
      }
    );
  },
  userLogout(state){
    HttpUtils.post("User/Logout").then(function(resp){
      state.userInfo={};
      router.push("Login");
    })
  }
}

/**
 * Actions
 * @type {Object}
 */
const actions = {
}

// Export module
export default {
  state,
  getters,
  mutations,
  actions
}
