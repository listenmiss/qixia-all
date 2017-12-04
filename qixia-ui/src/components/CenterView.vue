<template>

  <div >
    <el-col :xs="24" :sm="6" >
      <div class="date_div">
        <div style="width:100%;    height: 65px;">
          <span style="font-size:20px; color: #2db7fe; float: left;margin-top:27px;margin-left:20px;">星期一</span>
          <img style=" float: left;width:38px;height:37px;margin-top: 22px;margin-left:30px;" src="../assets/images/sunny.png"/>

        </div>

        <div style="width:100%; height: 65px;">
          <span style="font-size:40px; color: #2db7fe; float: left;margin-left:20px;">10</span>
          <span style="font-size:20px; color: #2db7fe; float: left;margin-left:16px;margin-top: 10px;">二月</span>
          <span style="font-size:40px; color: #2db7fe; float: left;margin-left:30px;">03:27</span>
          <span style="font-size:20px; color: #2db7fe; float: left;margin-left:14px;margin-top: 20px;">pm</span>
        </div>

      </div>

      <div class="news_div">
        <span style="font-size:16px; color: #2db7fe; float: left;margin-top:8px;margin-left:10px;">10:30-受灾人员救助（0000156）申请人</span>
        <span style="font-size:16px; color: #2db7fe; float: left;margin-top:8px;margin-left:10px;">10:30-受灾人员救助（0000156）申请人</span>
        <span style="font-size:16px; color: #2db7fe; float: left;margin-top:8px;margin-left:10px;">10:30-受灾人员救助（0000156）申请人</span>
      </div>

      <div class="sxbjs_div">

        <img src="../assets/images/header_arrow_right.png"  style="float:left;margin-left:50px;margin-top:15px;width:19px;height:14px;"/>
        <span style="font-size:28px; color: #2db7fe;  font-family:'Microsoft YaHei';">事项办结数</span>
        <img src="../assets/images/header_arrow_left.png"   style="float:right;margin-right:50px;margin-top:15px;width:19px;height:14px;"/>
      </div>

      <div class="sxbjs_item_div">

        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: left;margin-left: 90px;line-height: 35px;">今日：</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';margin-left:18px;line-height: 35px;">812</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: right;margin-right: 90px;line-height: 35px;">件</span>
      </div>
      <div class="sxbjs_item_div">

        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: left;margin-left: 90px;line-height: 35px;">本周：</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';line-height: 35px;">1522</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: right;margin-right: 90px;line-height: 35px;">件</span>
      </div>
      <div class="sxbjs_item_div">

        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: left;margin-left: 90px;line-height: 35px;">本月：</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';line-height: 35px;">356</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: right;margin-right: 90px;line-height: 35px;">件</span>

      </div>
      <div class="sxbjs_item_div">

        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: left;margin-left: 90px;line-height: 35px;">总计：</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';line-height: 35px;">10234</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: right;margin-right: 90px;line-height: 35px;">件</span>


      </div>
      <div class="sxbjs_div">

        <img src="../assets/images/header_arrow_right.png"  style="float:left;margin-left:50px;margin-top:15px;width:19px;height:14px;"/>
        <span style="font-size:28px; color: #2db7fe;  font-family:'Microsoft YaHei';">用户动态</span>
        <img src="../assets/images/header_arrow_left.png"   style="float:right;margin-right:50px;margin-top:15px;width:19px;height:14px;"/>
      </div>
      <div class="sxbjs_item_div">

        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: left;margin-left: 60px;line-height: 35px;">在线人数：</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';line-height: 35px;">134</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: right;margin-right: 60px;line-height: 35px;">人</span>

      </div>
      <div class="sxbjs_item_div">

        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: left;margin-left: 60px;line-height: 35px;">用户总数：</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';line-height: 35px;">2005</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: right;margin-right: 60px;line-height: 35px;">人</span>


      </div>

    </el-col>
  </div>


</template>


<script>
  export default {
    name: 'CenterView',
    data () {
      return {

      }
    },methods: {


    }



  }
</script>

<style scoped>
  .left_arrow{
    line-height: 171px;
    height: 17px;
    float: left;

  }

  .right_arrow{
    line-height: 17px;
    height: 17px;
    float: right;

  }
  .date_div{
    height:130px;
    background: url(../assets/images/date_div_bg.png);
    background-size: 100% 100%;
  }
  .news_div{
    height:100px;
    background: url(../assets/images/news_bg.png);
    background-size: 100% 100%;
    margin-top:18px;
  }
  .sxbjs_div{
    text-align: center;
    margin-top:18px;
    margin-bottom:10px;
  }
  .sxbjs_item_div{
    height:35px;
    background: url(../assets/images/sx_count_bg.png);
    background-size: 100% 100%;
    margin-top:8px;
  }
</style>
