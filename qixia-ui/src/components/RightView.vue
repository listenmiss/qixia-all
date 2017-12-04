<template>

  <div >
    <el-col :xs="24" :sm="9">
      <div class="bjs_chart_title_div">
        <span class="bjs_chart_title_txt">办结数图表</span>

      </div>
      <div class="bjs_chart_div" >
      </div>

      <div class="bjs_map_div" >
      </div>
    </el-col>

  </div>


</template>


<script>
  export default {
    name: 'RightView',
    data () {
      return {

      }
    },methods: {


    }



  }
</script>

<style scoped>
  .bjs_chart_title_div{
    height:40px;
    background: rgba(20,116,191,0.6);
    /*background:#0d5798*/
    border:1px solid rgba(0,186,255,0.6);
    text-align: center;

  }
  .bjs_chart_title_txt {
    font-family:'Microsoft YaHei';
    font-size:20px;
    text-align: center;
    color: #2db7fe;
    line-height: 40px;
  }
  .bjs_chart_div{
    height:310px;
    border:1px solid rgba(0,186,255,0.6);
    background:url(../assets/images/bjs_chart_bg.png);

    margin-top:10px;
  }
  .bjs_map_div{
    height:310px;
    border:1px solid rgba(0,186,255,0.6);

    margin-top:10px;
  }
</style>
