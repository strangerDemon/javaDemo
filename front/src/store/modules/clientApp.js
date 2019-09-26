import HttpUtils from '../../utils/httpUtils/axiosUtils'
/**
 * 变量参数
 */
const state = {
  defaultClients:[],//默认展示客户端
  allClients: [], //客户端
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
  getAuthClientApp(state, info) {
    //http://localhost:19433/webApi.asmx/getSysConfigPara
    HttpUtils.post('ClientApp/GetAuthClientApp', info).then(
      function (resp) {
        state.allClients = resp;
        state.defaultClients = state.allClients.filter(client => {
          client.appIcon = client.appIcon == null || client.appIcon == "" ? "/static/images/product/" + Math.floor(Math.random() * 3 + 1) + ".jpg" : client.appIcon;
          return client.IsDefaultApp > 0;
        });
        console.log("getAuthClientApp:", resp);
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
