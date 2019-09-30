<template>
  <div class='login-view'>
    <div class="main-dw">
      <div class="main-bg"></div>
    </div>
    <div class="footer">
      <p class="tc">
        版权所有©strangerDemo
        <br />
        <a style="color:#000" href="http://www.miitbeian.gov.cn/"> xxx</a>
      </p>
    </div>
    <div class="main">
      <login-form></login-form>
    </div>
  </div>
</template>

<script>
import loginForm from "../components/Login/LoginForm"
  export default {
    name: 'login-view',
    directives: {},
    components: {
      loginForm
    },
    props: {},
    data() {
      return {}
    },
    computed: {},
    watch: {},
    methods: {
    },
    brforeCreate() {},
    created() {},
    mounted() {},
    beforeDestroy() {}
  }
</script>

<style lang='postcss'>
  .login-view {
    position: absolute;
    z-index: 0;
    & .footer {
      position: fixed;
      bottom: 0px;
      text-align: center;
      font-size: 12px;
      width: 100%
    }
    & .main-dw {
      position: fixed;
      top: 0;
      height: 220px;
      width: 100%;
      & .main-bg {
        position: absolute;
        left: 0px;
        right: 0px;
        overflow-x: hidden;
        background-position-y: center;
        background-position-x: center;
        background-image: url(/static/images/bg.jpg);
        height: 435px;
      }
    }
    & .main {
    }
  }
</style>
