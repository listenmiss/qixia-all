<template>

  <div class="header_wrap_div">
    <!--<div class="header_left">-->
      <!--&lt;!&ndash;<h3><span class="header_title">栖霞掌上社区业务审批平台</span></h3>&ndash;&gt;-->
    <!--</div>-->

    <div class="title_div_bg">
      <img src="../assets/images/logo.png" class="logo" />
      <div class="title_txt_div">
        <h1>
          <span class="header_title">政务一张网统计平台</span>
        </h1>
      </div>

    </div>


  </div>


</template>


<script>
  export default {
    name: 'Headerbar',
    data () {
      return {

      }
    },methods: {


    }



  }
</script>

<style scoped>
  .header_wrap_div{
    text-align:center;
    padding-bottom: 10px;
  }
.title_div_bg{


  margin: 0 auto;
  background: url(../assets/images/title_bg.png) center top no-repeat;
  width:1024px;
  height: 90px;
  background-size: 100% 100%;
}



  .logo{
    width:38px;
    height:40px;
    float:left;
    line-height:40px;
    margin-top: 35px;
    margin-left: 310px;
  }

  .header_title {
    text-align: center;
    font-weight: bold;
    /*color: #ec9101;*/

    color: #2db7fe;
  }

  .title_txt_div{
    float:left;
    margin-left: 20px;
    margin-top:10px;
  }
</style>
