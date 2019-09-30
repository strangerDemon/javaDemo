<template>
  <div class="index-main-view">
    <div class="main-nav" id="particles-js">
      <div class="header-nav">
        <div class="title-div">
          <i class="el-icon-video-camera-solid"></i>
          {{title}}
        </div>
        <div class="sign" @click="singOut">
          Sign Out
          <i class="el-icon-switch-button"></i>
        </div>
      </div>
    </div>
    <div class="waves-div">
      <svg width="100%" height="20%" version="1.1" class="wave">
        <defs />
        <path id="feel-the-wave" d />
      </svg>
    </div>
    <div class="product-display-div">
      <div
        v-for="(client,index) in defaultClients"
        :key="index"
        class="product"
        @click="openClient(client)"
      >
        <img class="hover-image" :src="client.appIcon" alt />
        <div class="hover-mask">
          <h2 class="product-title">{{client.appName}}</h2>
          <p class="product-content">{{client.description}}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import * as wavifyUtlis from "@/utils/otherUtils/wavify";
import * as particlesUtils from "particlesjs";
export default {
  name: "index-main-view",
  directives: {},
  components: {},
  props: {},
  data() {
    return {
      title: "CAS",
      clientApp: null
    };
  },
  computed: {
    allClients() {
      return this.$store.state.clientApp.allClients;
    },
    defaultClients() {
      return this.$store.state.clientApp.defaultClients;
    }
  },
  watch: {},
  methods: {
    init() {
      this.initPage();
      this.initData();
    },
    initData() {
      this.$store.commit("getClientAppList");
    },
    openClient(client) {
      window.open(client.appLoginUrl);
    },
    singOut() {
      let vm = this;
      vm.$confirm("CAS登出, 是否继续?", "登出", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        vm.$store.commit("userLogout");
      });
    },
    //页面渲染
    initPage() {
      this.initWaves();
      this.initParticles();
    },
    initWaves() {
      wavifyUtlis.wavify($("#feel-the-wave"), {
        height: 45,
        bones: 3,
        amplitude: 60,
        color: "#79BBFF",
        speed: 0.25
      });
    },
    initParticles() {
      particlesJS("particles-js", {
        particles: {
          number: {
            value: 80, // 20,//80
            density: {
              enable: true,
              value_area: 800
            }
          },
          color: {
            value: "fff"
          },
          shape: {
            type: "circle",
            stroke: {
              width: 0,
              color: "#000000"
            },
            polygon: {
              nb_sides: 5
            },
            image: {
              src: "img/github.svg",
              width: 100,
              height: 100
            }
          },
          opacity: {
            value: 0.5,
            random: false,
            anim: {
              enable: false,
              speed: 1,
              opacity_min: 0.1,
              sync: false
            }
          },
          size: {
            value: 3,
            random: true,
            anim: {
              enable: false,
              speed: 100,
              size_min: 10,
              sync: false
            }
          },
          line_linked: {
            enable: true,
            distance: 150,
            color: "#fff",
            opacity: 0.4,
            width: 1
          },
          move: {
            enable: true,
            speed: 3,
            direction: "none",
            random: false,
            straight: false,
            out_mode: "out",
            attract: {
              enable: false,
              rotateX: 600,
              rotateY: 1200
            }
          }
        },
        interactivity: {
          detect_on: "canvas",
          events: {
            onhover: {
              enable: true,
              mode: "grab"
            },
            onclick: {
              enable: true,
              mode: "repulse"
            },
            resize: true
          },
          modes: {
            grab: {
              distance: 150,
              line_linked: {
                opacity: 1
              }
            },
            bubble: {
              distance: 400,
              size: 40,
              duration: 2,
              opacity: 8,
              speed: 3
            },
            repulse: {
              distance: 200
            },
            push: {
              particles_nb: 4
            },
            remove: {
              particles_nb: 2
            }
          }
        },
        retina_detect: true,
        config_demo: {
          hide_card: false,
          background_color: "#b61924",
          background_image: "",
          background_position: "50% 50%",
          background_repeat: "no-repeat",
          background_size: "cover"
        }
      });
    }
  },
  brforeCreate() {},
  //app created=>map created =>mapSwitch created=> map mounted=> mapSwitch mounted=>app mounted
  created() {},
  mounted() {
    this.init();
  },
  beforeDestroy() {}
};
</script>

<style lang='postcss'>
.index-main-view {
  position: relative;
  width: 100%;
  height: 100%;
  & .main-nav {
    width: 100%;
    height: 50%;
    min-height: 330px;
    z-index: 98;
    background: linear-gradient(#409eff, #79bbff);
    & .header-nav {
      position: absolute;
      width: 100%;
      min-width: 960px;
      height: 60px;
      color: #fff;
      font-size: 24px;
      font-weight: 600;
      display: inline-block;
      & .title-div {
        position: absolute;
        width: 20%;
        height: 100%;
        line-height: 100px;
        text-align: right;
        & i {
          font-size: 2.5em;
        }
      }
      & .sign {
        position: absolute;
        width: 20%;
        height: 100%;
        line-height: 100px;
        right: 0px;
        text-align: center;
        transition: all 0.3s;
        cursor: pointer;
      }
      & .sign:hover {
        font-size: 1.05em;
      }
    }
  }
  & .waves-div {
    & .wave {
      position: absolute;
      left: 0;
      right: 0;
      top: 49%;
      z-index: 1;
      transform: rotate(180deg);
    }
    .wave + .wave {
      z-index: 2;
    }
    @media screen and (max-height: 660px) {
      /*当屏幕尺寸小于600px时，应用下面的CSS样式*/
      & .wave {
        top: 325px;
      }
    }
  }
  & .product-display-div {
    width: 100%;
    height: 50%;
    min-height: 330px;
    bottom: 0;
    background-color: #fff;
    text-align: center;
    & .product {
      position: relative;
      width: 25%;
      height: 50%;
      min-width: 320px;
      min-height: 230px;
      display: inline-block;
      top: 50%;
      margin: 25px;
      transform: translate(0%, -50%);
      z-index: 99;
      overflow: hidden;
      & .hover-mask {
        position: absolute;
        padding: 0;
        width: 100%;
        height: 100%;
        top: 0;
        left: 0;
        background: #000;
        opacity: 0;
        filter: alpha(opacity=0);
        -webkit-transition: all 0.3s ease-out;
        transition: all 0.3s ease-out;
        color: #fff;
        & .product-title {
          margin: 0;
          padding: 16px;
          font-size: 24px;
          line-height: 24px;
          font-weight: 500;
          text-align: left;
        }
        & .product-content {
        }
      }
      & .hover-image {
        width: 100%;
        height: 100%;
        webkit-transform: scale(1);
        transform: scale(1);
        -webkit-transition: -webkit-transform 0.3s ease-out;
        transition: transform 0.3s ease-out;
      }
    }
    & .product:hover {
      & .hover-mask {
        width: calc(100% - 50px);
        height: calc(100% - 50px);
        top: 25px;
        left: 25px;
        opacity: 0.6;
      }
      & .hover-image {
        webkit-transform: scale(1.4);
        transform: scale(1.4);
      }
    }
  }
}
</style>
