<template>
  <div class="mainview" v-bind:style="{ height: screenHeight-10 + 'px' }">

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




    <el-row :gutter="10" style=" margin-top: 35px;" >
      <Today-Matter :screenHeight="screenHeight"></Today-Matter>
      <Center-View></Center-View>
      <Right-View></Right-View>



    </el-row>
  </div>
</template>

<script>

  import Header from './Header'
  import TodayMatter from './TodayMatter.vue'
  import CenterView from './CenterView.vue'
  import RightView from './RightView.vue'

  export default {
    name: 'Main',
    data() {
//alert($(window).height()-230);
      return {
        screenHeight:$(window).height()

      }
    },
    components: {
      Header,
      TodayMatter,
      CenterView,
      RightView
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




</style>
