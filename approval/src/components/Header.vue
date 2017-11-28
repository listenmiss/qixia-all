<template>

    <div class="header_wrap_div">
      <div class="header_left">
        <h3><span class="header_title">栖霞掌上社区业务审批平台</span></h3>
      </div>
      <div class="header_right" style="float:right">
        <i class="fa fa-user-circle-o" style="font-size:25px" aria-hidden="true"></i>
        <span style="margin-left: 10px;margin-right: 10px;">欢迎admin登录</span>
        <router-link :to="{ path: '/' }">
          <span style="margin-left: 10px;margin-right: 10px;font-weight:bold;color:#2db7fe">退出</span>
        </router-link>
      </div>

   


    </div>


</template>


<script>
  export default {
    name: 'Header',
    data () {
      return {

      }
    },methods: {


    }



  }
</script>

<style scoped>



  .header_wrap_div {
    margin: 0 auto;
    width: 1200px;
  }

  .header_title {
    text-align: center;
    font-weight: bold;
    /*color: #ec9101;*/

    color: #2db7fe;

  }

  .header_left {
    float: left;
    text-align: center;
    line-height: 60px;
  }

  .header_right {
    float: right;
    text-align: center;
    line-height: 60px;
  }
</style>
