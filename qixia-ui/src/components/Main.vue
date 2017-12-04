<template>
  <div class="mainview">

    <el-row>
      <el-col :xs="24" :sm="24" >
        <Header></Header>
      </el-col>
    </el-row>
    <el-row>
      <el-col :xs="24" :sm="24" >
<!--        <div class="header_bottom_bar">
          <img src="../assets/images/header_arrow_left.png" class="left_arrow"  style="margin-left: 8px;"/>
          <img src="../assets/images/header_arrow_left.png" class="left_arrow" style="margin-left:5px"/>

          <img src="../assets/images/header_arrow_right.png" class="right_arrow"  style="margin-right: 8px;"/>
          <img src="../assets/images/header_arrow_right.png" class="right_arrow" style="margin-right:5px"/>
        </div>-->

        <div class="header_division"> </div>

      </el-col>
    </el-row>




    <el-row :gutter="10" style=" margin-top: 35px;">
      <el-col :xs="24" :sm="9" >

        <div class="left_ju">
            <img src="../assets/images/title_today.png" class="title_today_img"  />
            <span class="title_today_txt">今日事项总办结数</span>

        </div>
        <div class="left_ju_container" v-bind:style="{ height: screenHeight-230 + 'px' }">
          <el-row :gutter="42">
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:5px solid #61d13e;">
                <span class="ju_title_txt">市场监管局</span>

                <span class="ju_value">280</span>
              </div>

            </el-col>
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:5px solid #01feff;">
                <span class="ju_title_txt">住建局</span>

                <span class="ju_value">145</span>
              </div>
            </el-col>
          </el-row>



          <el-row :gutter="42">
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:5px solid #ff5c0d;">
                <span class="ju_title_txt">人社局</span>

                <span class="ju_value">150</span>
              </div>

            </el-col>
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:5px solid #0183e8;">
                <span class="ju_title_txt">环保局</span>

                <span class="ju_value">240</span>
              </div>
            </el-col>
          </el-row>



          <el-row :gutter="42">
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:5px solid #61d13e;">
                <span class="ju_title_txt">财政局</span>

                <span class="ju_value">254</span>
              </div>

            </el-col>
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:5px solid #01feff;">
                <span class="ju_title_txt">安监局</span>

                <span class="ju_value">280</span>
              </div>
            </el-col>
          </el-row>



          <el-row :gutter="42">
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:5px solid #ff5c0d;">
                <span class="ju_title_txt">发改局</span>

                <span class="ju_value">123</span>
              </div>

            </el-col>
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:5px solid #0283e7;">
                <span class="ju_title_txt">农业局</span>

                <span class="ju_value">212</span>
              </div>
            </el-col>
          </el-row>



          <el-row :gutter="42">
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:5px solid #61d13e;">
                <span class="ju_title_txt">教育局</span>

                <span class="ju_value">50</span>
              </div>

            </el-col>
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:5px solid #01feff;">
                <span class="ju_title_txt">编办</span>

                <span class="ju_value">50</span>
              </div>
            </el-col>
          </el-row>




          <el-row :gutter="42">
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:5px solid #ff5c0d;">
                <span class="ju_title_txt">民宗局</span>

                <span class="ju_value">280</span>
              </div>

            </el-col>
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:5px solid #0283e7;">
                <span class="ju_title_txt">体育局</span>

                <span class="ju_value">15</span>
              </div>
            </el-col>
          </el-row>



          <el-row :gutter="42">
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:5px solid #61d13e;">
                <span class="ju_title_txt">物价局</span>

                <span class="ju_value">280</span>
              </div>

            </el-col>
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:5px solid #01feff;">
                <span class="ju_title_txt">交运局</span>

                <span class="ju_value">120</span>
              </div>
            </el-col>
          </el-row>


          <el-row :gutter="42">
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:5px solid #ff5c0d;">
                <span class="ju_title_txt">水务局</span>

                <span class="ju_value">120</span>
              </div>

            </el-col>
            <el-col :xs="24" :sm="12" >
              <div class="ju_info_div" style="border-left:5px solid #0283e7;">
                <span class="ju_title_txt">文化旅游局</span>

                <span class="ju_value">112</span>
              </div>
            </el-col>
          </el-row>

        </div>

      </el-col>
      <el-col :xs="24" :sm="6" >
        <div class="grid-content bg-purple-light"
        ></div>
      </el-col>
      <el-col :xs="24" :sm="9">
        <div class="grid-content bg-purple">

        </div>
      </el-col>

    </el-row>
  </div>
</template>

<script>

  import Header from './Header'

  export default {
    name: 'Main',
    data() {

      return {
        screenHeight:$(window).height()

      }
    },
    components: {
      Header
    }  , mounted() {
      const that = this
      window.onresize = () => {
        return (() => {
          that.screenHeight =$(window).height()
        })()
      }
    }
  }
</script>

<style scoped>
  li {
    list-style-type: none;
  }


  .el-col {
    border-radius: 4px;
  }



  .mainview{
    padding-left:8px;
    padding-right:8px;
    padding-bottom:10px;
    background: -webkit-linear-gradient( #012f63,#010006); /* Safari 5.1 - 6.0 */
    background: -o-linear-gradient( #012f63,#010006);/* Opera 11.1 - 12.0 */
    background: -moz-linear-gradient( #012f63,#010006); /* Firefox 3.6 - 15 */
    background: linear-gradient( #012f63,#010006); /* 标准的语法（必须放在最后） */


  }

  .header_bottom_bar{
    width:100%;
    height:21px;
    background: -webkit-linear-gradient(#0c5e9d,#187cb5, #0c5e9d); /* Safari 5.1 - 6.0 */
    background: -o-linear-gradient(#0c5e9d,#187cb5, #0c5e9d); /* Opera 11.1 - 12.0 */
    background: -moz-linear-gradient(#0c5e9d,#187cb5, #0c5e9d); /* Firefox 3.6 - 15 */
    background: linear-gradient(#0c5e9d,#187cb5, #0c5e9d); /* 标准的语法（必须放在最后） */
    padding-top: 2px;
    padding-bottom: 2px;

  }


  .header_division{
    width:100%;
    height:21px;
    background: url(../assets/images/header_division.png) center top no-repeat;
    background-size: 100% 100%;
  }
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
    padding-top:54px;
    padding-bottom:54px;

    padding-left:45px;
    padding-right:45px;
  }


  .ju_info_div{
    border:1px solid rgba(0,186,255,0.6);
    /*border-left:5px solid #61d13e;*/
    height:60px;
    padding-left:10px;
    padding-right:10px;
  }
  .ju_title_txt {
    /*font-size:24px;*/
    /*text-align: center;*/
    color: #2db7fe;
    line-height: 60px;
    /*margin-left:35px;*/
    float: left;

  }

  .ju_value{
    /*font-size:24px;*/
    color: #2db7fe;
    line-height: 60px;
    /*margin-left:192px;*/
    float: right;

  }
</style>
