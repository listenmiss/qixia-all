<template>
  <div>
    <el-col :xs="24" :sm="9" >

      <div class="left_ju">
        <img src="../assets/images/title_today.png" class="title_today_img"  />
        <span class="title_today_txt">今日事项总办结数</span>

      </div>
      <div class="left_ju_container" >

        <!-- <div class="left_ju_wrap"  v-bind:style="{ 'margin-top': (screenHeight-740)/2 + 'px' }">-->
        <div class="left_ju_wrap"  >
          <el-row :gutter="42">
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:8px solid #61d13e;">
                <span class="ju_title_txt">市场监管局</span>

                <span class="ju_value">280</span>
              </div>

            </el-col>
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:8px solid #01feff;">
                <span class="ju_title_txt">住建局</span>

                <span class="ju_value">145</span>
              </div>
            </el-col>
          </el-row>



          <el-row :gutter="42">
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:8px solid #ff5c0d;">
                <span class="ju_title_txt">人社局</span>

                <span class="ju_value">150</span>
              </div>

            </el-col>
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:8px solid #0183e8;">
                <span class="ju_title_txt">环保局</span>

                <span class="ju_value">240</span>
              </div>
            </el-col>
          </el-row>



          <el-row :gutter="42">
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:8px solid #61d13e;">
                <span class="ju_title_txt">财政局</span>

                <span class="ju_value">254</span>
              </div>

            </el-col>
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:8px solid #01feff;">
                <span class="ju_title_txt">安监局</span>

                <span class="ju_value">280</span>
              </div>
            </el-col>
          </el-row>



          <el-row :gutter="42">
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:8px solid #ff5c0d;">
                <span class="ju_title_txt">发改局</span>

                <span class="ju_value">123</span>
              </div>

            </el-col>
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:8px solid #0283e7;">
                <span class="ju_title_txt">农业局</span>

                <span class="ju_value">212</span>
              </div>
            </el-col>
          </el-row>



          <el-row :gutter="42">
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:8px solid #61d13e;">
                <span class="ju_title_txt">教育局</span>

                <span class="ju_value">50</span>
              </div>

            </el-col>
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:8px solid #01feff;">
                <span class="ju_title_txt">编办</span>

                <span class="ju_value">50</span>
              </div>
            </el-col>
          </el-row>




          <el-row :gutter="42">
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:8px solid #ff5c0d;">
                <span class="ju_title_txt">民宗局</span>

                <span class="ju_value">280</span>
              </div>

            </el-col>
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:8px solid #0283e7;">
                <span class="ju_title_txt">体育局</span>

                <span class="ju_value">15</span>
              </div>
            </el-col>
          </el-row>



          <el-row :gutter="42">
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:8px solid #61d13e;">
                <span class="ju_title_txt">物价局</span>

                <span class="ju_value">280</span>
              </div>

            </el-col>
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:8px solid #01feff;">
                <span class="ju_title_txt">交运局</span>

                <span class="ju_value">120</span>
              </div>
            </el-col>
          </el-row>


          <el-row :gutter="42">
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:8px solid #ff5c0d;">
                <span class="ju_title_txt">水务局</span>

                <span class="ju_value">120</span>
              </div>

            </el-col>
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:8px solid #0283e7;">
                <span class="ju_title_txt">文化旅游局</span>

                <span class="ju_value">112</span>
              </div>
            </el-col>
          </el-row>
        </div>


      </div>

    </el-col>
  </div>
</template>


<script>
  export default {
    name: 'TodayMatter',
    props: ['screenHeight'],
    data () {
      return {

      }
    },methods: {


    }



  }
</script>

<style scoped>

  .left_ju{
    height:60px;
    background: rgba(20,116,191,0.6);
    /*background:#0d5798*/
    border:1px solid rgba(0,186,255,0.6);
    text-align: left;

  }


  .title_today_img{
    margin-left:20px;
  }
  .title_today_txt {
    font-size:24px;
    text-align: center;
    color: #2db7fe;
    line-height: 60px;
    margin-left:20px;
  }


  .left_ju_container{
    border:1px solid rgba(0,186,255,0.6);
    background:url(../assets/images/ju_bg.png);
	 background-size: 100% 100%;
    padding-top:0;
    padding-bottom:0;

    padding-left:15px;
    padding-right:15px;
    /*text-align:center;*/
    /*position: relative;*/
    margin-top:10px;
  }
  .left_ju_wrap{
    /*position: absolute;*/
    /*top: 50%;*/
    /*line-height:564px;*/
    /*margin:0 auto;*/
    /*height:480px;*/
    /*position: absolute;*/
    /*top: 50%;*/
    margin-top:50px;
	margin-bottom:50px;
  }


  .ju_info_div{
    border:1px solid rgba(0,186,255,0.6);
    /*border-left:5px solid #61d13e;*/
    height:50px;
    padding-left:10px;
    padding-right:10px;
    margin-top:10px;
  }
  .ju_title_txt {
    font-size:24px;
    /*text-align: center;*/
    color: #2db7fe;
    line-height: 50px;
    /*margin-left:35px;*/
    float: left;

  }

  .ju_value{
    font-size:24px;
    color: #2db7fe;
    line-height: 50px;
    /*margin-left:192px;*/
    float: right;

  }
</style>
