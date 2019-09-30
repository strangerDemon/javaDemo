<template>
  <div class='cas-login-view'>
    <cas-login-form></cas-login-form>
  </div>
</template>

<script>
  import casLoginForm from '../components/CasLogin/CasLoginForm'
  export default {
    name: 'cas-login-view',
    directives: {},
    components: {
      casLoginForm
    },
    props: {},
    data() {
      return {}
    },
    computed: {},
    watch: {},
    methods: {},
    brforeCreate() {},
    created() {},
    mounted() {},
    beforeDestroy() {}
  }
</script>

<style lang='postcss'>
  .cas-login-view {}
</style>
