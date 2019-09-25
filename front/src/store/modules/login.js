import HttpUtils  from '../../utils/httpUtils/axiosUtils'
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
    HttpUtils.post('UserLogin', info).then(
      function (resp) {
        console.log(resp)
      }
    );
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
