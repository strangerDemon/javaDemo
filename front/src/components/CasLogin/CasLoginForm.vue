<template>
  <div class='cas-login-form'>
  </div>
</template>

<script>
  import * as urlUtlis from "@/utils/otherUtils/urlUtils";
  export default {
    name: 'cas-login-form',
    directives: {},
    components: {},
    props: {},
    data() {
      return {}
    },
    computed: {},
    watch: {},
    methods: {
      casLogin() {
        let vm = this;
        let urlParam = urlUtlis.transformToJson(location.search.substring(1))
        if (urlParam.service == "") {
          router.push("Login");
        } else {
          vm.$store.commit('getTicket', urlParam);
        }
      }
    },
    brforeCreate() {},
    created() {},
    mounted() {
      this.casLogin();
    },
    beforeDestroy() {}
  }
</script>

<style lang='postcss'>
  .cas-login-form {}
</style>
