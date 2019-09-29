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
      <div class="content">
        <div class="icon">
          <img src="/static/images/login_logo.png" />
        </div>
        <div class="title">单点登录</div>
        <div class="desc"></div>
        <div class="login">
          <el-input placeholder="请输入用户名/admin" prefix-icon="el-icon-user" v-model="account" ref="account" @keyup.enter.native="handleClickLogin">
          </el-input>
          <el-input placeholder="请输入用户名/123456" prefix-icon="el-icon-lock" ref="password" v-model="password" show-password>
          </el-input>
          <el-button @click="handleClickLogin" class="btn" type="primary" style="width:100%">登录</el-button>
          <el-alert v-show="!!errorText" :title="errorText" type="error" :closable="false"></el-alert>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'login-view',
    directives: {},
    components: {},
    props: {},
    data() {
      return {
        flag: true,
        loginValue: "登录",
        isLoading: false,
        account: "",
        password: "",
        errorText: ""
      }
    },
    computed: {},
    watch: {},
    methods: {
      toggleLoginState(flag) {
        if (flag) {
          this.isLoading = true;
          this.loginValue = "";
        } else {
          this.isLoading = false;
          this.loginValue = "登录";
        }
      },
      submit() {
        let vm = this
        let info = {
          account: vm.account,
          password: vm.password
        }
        vm.$store.commit("userLogin", info);
      },
      checkIsEmpty(key, label) {
        if (!this[key]) {
          this.errorText = label + "!";
          this.$refs[key].focus();
          return false;
        } else {
          return true;
        }
      },
      handleClickLogin() {
        if (this.checkIsEmpty("account", "账号不能为空") &&
          this.checkIsEmpty("password", "密码不能为空")) {
          this.submit();
        }
      }
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
      position: fixed;
      top: 50%;
      margin-top: -250px;
      width: 100%;
      text-align: center;
      & .content {
        position: absolute;
        left: 50%;
        margin-left: -190px;
        /*  border-bottom: 10px solid rgba(0, 121, 254, 1); 边框 */
        background-color: #fff;
        padding: 20px 40px;
        /* 边距 */
        text-align: center;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
        border-radius: 1px;
        & .icon {
          margin: 4px 0 20px 0;
        }
        & .title {
          color: #0079fe;
          font-size: 24px;
          font-weight: bolder;
          letter-spacing: 1px;
        }
        & .desc {
          color: #0079fe;
          font-size: 20px;
          margin-bottom: 30px;
          letter-spacing: 2px;
        }
        & .login {
          width: 300px;
          text-align: left;
          & .el-input {
            margin-bottom: 20px;
            /* 行间距 */
          }
          & .el-input__inner,
          & .el-button,
          & .el-alert {
            border-radius: 1px;
          }
          & .el-input__icon {
            font-size: 16px;
            /* 图标大小 */
            color: #0079fe;
            font-weight: bold;
          }
          & .btn {
            margin: 6px 0 16px 0;
          }
          & .fix {
            *zoom: 1;
          }
          & .fix:after {
            content: '';
            display: table;
            clear: both;
          }
        }
      }
    }
  }
</style>
