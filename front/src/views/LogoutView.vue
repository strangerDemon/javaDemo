<template>
  <div class='logout-view'>
    <div class="mainBox">
      <img src="/static/images/logout/cloud-1.png" alt="" class="yun yun0">
      <img src="/static/images/logout/cloud-2.png" alt="" class="yun yun1">
      <img src="/static/images/logout/cloud-3.png" alt="" class="yun yun2">
      <img src="/static/images/logout/bird.png" alt="" class="bird">
      <img src="/static/images/logout/person.png" alt="" class="san">
      <div class="tipInfo">
        <div class="in">
          <div class="textThis">
            <h2>系统已登出</h2>
            <p>为了安全，请关闭当前tab页</p>
            <p>
              <span>即将跳转<b class="redirect" onclick="redirect()">跳转</b></span>
              <span>等待<b id="countDown">10</b>秒</span>
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'logout-view',
    directives: {},
    components: {},
    props: {},
    data() {
      return {}
    },
    computed: {},
    watch: {},
    methods: {},
    brforeCreate() {},
    //app created=>map created =>mapSwitch created=> map mounted=> mapSwitch mounted=>app mounted
    created() {},
    mounted() {},
    beforeDestroy() {}
  }
</script>

<style lang='postcss'>
  .logout-view {
    & .mainBox {
      position: absolute;
      width: 100%;
      background: linear-gradient(#40A3FF, #79BBFF);
      height: 100%;
      margin: 0 auto;
      overflow: hidden;
      min-width: 1200px;
      & img {
        position: absolute
      }
      & .yun0 {
        right: -140px;
        top: 85px;
        -webkit-animation: cloudLarge 105s infinite;
        -moz-animation: cloudLarge 105s infinite;
        -o-animation: cloudLarge 105s infinite;
        animation: cloudLarge 105s infinite
      }
      & .yun1 {
        left: 5%;
        top: 48%;
        -webkit-animation: cloudSmall 105s infinite;
        -moz-animation: cloudSmall 105s infinite;
        -o-animation: cloudSmall 105s infinite;
        animation: cloudSmall 105s infinite
      }
      & .yun2 {
        left: 16%;
        top: 35%;
        -webkit-animation: cloudMedium 105s infinite;
        -moz-animation: cloudMedium 105s infinite;
        -o-animation: cloudMedium 105s infinite;
        animation: cloudMedium 105s infinite
      }
      & .san {
        position: absolute;
        left: 10%;
        top: 20%;
        -webkit-animation: dn400 3s 0s ease both;
        -moz-animation: dn400 3s 0s ease both;
        animation: dn400 3s 0s ease both
      }
      & .bird {
        left: 27%;
        top: 15%;
        -webkit-animation: flying 3s infinite;
        -moz-animation: flying 3s infinite;
        -o-animation: flying 3s infinite;
        animation: flying 3s infinite
      }
      & .tipInfo {
        position: absolute;
        z-index: 99;
        margin-left: 150px;
        border: 4px solid #c0ece7;
        border-color: #c0ede8;
        border-radius: 5px;
        background: #c0ede8;
        width: 360px;
        top: 40%;
        right: 15%;
        & .in {
          background: #fff;
          padding: 0 10% & h2 {
            line-height: 50px;
            font-size: 30px;
            color: #e94c3c;
            border-bottom: 1px dashed #aacdd5;
            padding: 18px 0
          }
          & p {
            padding: 10px 0 20px;
            text-align: left;
            color: #289575 & span {
              margin-right: 20px;
            }
            & .redirect {
              cursor: pointer;
              color: red;
              margin: 0 5px;
            }
          }
        }
      }
    }
  }
  @keyframes cloudLarge {
    0% {
      right: -140px
    }
    100% {
      right: 118%
    }
  }
  @keyframes cloudSmall {
    0% {
      left: 5%
    }
    100% {
      left: 105%
    }
  }
  @keyframes cloudMedium {
    0% {
      left: 16%
    }
    100% {
      left: -18%
    }
  }
  @keyframes flying {
    0% {
      margin-top: 0
    }
    50% {
      margin-top: 6px
    }
    100% {
      margin-top: 0
    }
  }
  @keyframes dn400 {
    0% {
      opacity: 0;
      transform: translateY(-400px)
    }
    100% {
      opacity: 1;
      transform: translateY(0)
    }
  }
</style>
