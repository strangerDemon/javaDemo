import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/views/IndexView'
import Login from '@/views/LoginView'
import NotFound from '@/views/ErrorView'
import HttpUtils from '@/utils/httpUtils/axiosUtils'
Vue.use(Router)

let router = new Router({
  mode: "history",
  routes: [{
      path: '/',
      name: 'Index',
      component: Index
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login
    },
    {
      path: '/404',
      name: '404',
      component: NotFound
    }
  ]
});

/**
 * 每次路由切换都请求一次
 * router.beforeEach 前置守卫
 * router.beforeResolve 注册一个全局守卫。这和 router.beforeEach 类似，区别是在导航被确认之前，同时在所有组件内守卫和异步路由组件被解析之后，解析守卫就被调用。
 * router.afterEach 后置守卫
 */
router.beforeResolve(function (to, from, next) {
  //时都去请求一次
  HttpUtils.post('Cas/IsLogin')
    .then(function (resp) {
      if (resp instanceof Object) { //已登录
        next();
      } else if (to.name == "404" || to.name == "Login") { //不限定路径
        next();
      } else {
        next({
          path: '/Login'
        })
      }
    })
})

export default router;
