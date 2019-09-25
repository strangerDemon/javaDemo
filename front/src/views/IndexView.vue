<template>
  <div class='index-view' :style="{'background-image':backgroundImg}">
    <el-scrollbar ref="index">
      <main-view></main-view>
    </el-scrollbar>
    <el-backtop target=".el-scrollbar__wrap"></el-backtop>
  </div>
</template>

<script>
  import mainView from "../components/Index/Main"
  export default {
    name: 'index-view',
    directives: {},
    components: {
      mainView
    },
    props: {},
    data() {
      return {
        backgroundImg: "",
        currentPage: 0,
        pages: ["first", "second"]
      }
    },
    computed: {},
    watch: {},
    methods: {
      init() {
        let vm = this
        let random = Math.ceil(5 * Math.random());
        vm.backgroundImg = "url(/static/images/background/" + random + ".jpg)";
      }
    },
    brforeCreate() {},
    created() {},
    mounted() {
      // this.$store.dispatch("init");
      this.init()
    },
    beforeDestroy() {}
  }
</script>

<style lang="postcss">
  .index-view {
    position: absolute;
    width: 100%;
    height: 100%;
    display: inline-block;
    background-size: cover;
    overflow-y: auto;
    & .el-scrollbar {
      height: 100%;
      & .el-scrollbar__wrap {
        height: 100%;
        max-height: 100%;
        overflow-x: hidden;
        border: 0px;
        padding: 0px;
        & .el-scrollbar__view {
          height: 100%;
        }
      }
    }
  }
</style>
