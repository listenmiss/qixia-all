<template>
  <div class="mainview">

    <el-row>
      <el-col :xs="24" :sm="24" >
        <Header></Header>
      </el-col>
    </el-row>
    <el-row>
      <el-col :xs="24" :sm="24" >
        <div class="header_bottom_bar">
          <img src="../assets/images/header_arrow_left.png"/>
        </div>
      </el-col>
    </el-row>




    <el-row :gutter="10">
      <el-col :xs="24" :sm="12" ><div class="grid-content bg-purple"></div></el-col>
      <el-col :xs="24" :sm="12" ><div class="grid-content bg-purple-light"></div></el-col>
      <el-col :xs="24" :sm="12"><div class="grid-content bg-purple"></div></el-col>
      <el-col :xs="24" :sm="12" ><div class="grid-content bg-purple-light"></div></el-col>
    </el-row>
  </div>
</template>

<script>

  import Header from './Header'

  export default {
    name: 'Main',
    data() {

      return {
        msg: '这是主界面',
        screenHeight: $(window).height()

      }
    },
    components: {
      Header
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
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }

  .header_bottom_bar{
    width:100%;
    height:21px;



    background: -webkit-linear-gradient(#022d60,#187cb5 ,#022d60); /* Safari 5.1 - 6.0 */
    background: -o-linear-gradient(#022d60,#187cb5 ,#022d60); /* Opera 11.1 - 12.0 */
    background: -moz-linear-gradient(#022d60,#187cb5 ,#022d60); /* Firefox 3.6 - 15 */
    background: linear-gradient(#022d60,#187cb5 ,#022d60); /* 标准的语法（必须放在最后） */

  }





</style>
