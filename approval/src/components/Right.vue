<template>
  <div style="background-color: #4c4c4c;" v-bind:style="{ height: screenHeight-130 + 'px' }">
    <div class="aside_right_title">
      <h5 style="margin-bottom:0px;"><span style="height:30px;line-height: 50px;font-weight:bold;color:white">业务对象信息</span>
      </h5>
    </div>
    <div
      style="text-align:left;background-color: #2a2a2a;margin-left:5px;margin-right:5px;padding:10px;overflow-y: auto;height:180px;">
      <el-row>
        <el-col :span="8"><span style="color:white">姓名：</span></el-col>
        <el-col :span="16"><span style="color:white">张三</span></el-col>
      </el-row>
      <el-row>
        <el-col :span="8"><span style="color:white">性别：</span></el-col>
        <el-col :span="16"><span style="color:white">男三</span></el-col>
      </el-row>
      <el-row>
        <el-col :span="8"><span style="color:white">身份证号码：</span></el-col>
        <el-col :span="16"><span style="color:white">321183199105221612</span></el-col>
      </el-row>
      <el-row>
        <el-col :span="8"><span style="color:white">联系方式：</span></el-col>
        <el-col :span="16"><span style="color:white">123456789</span></el-col>
      </el-row>
      <el-row>
        <el-col :span="8"><span style="color:white">家庭住址：</span></el-col>
        <el-col :span="16"><span style="color:white">xxxxxxxxxxxxxx</span></el-col>
      </el-row>
    </div>
    <div class="aside_right_title">
      <h5 style="margin:0px;"><span
        style="height:30px;line-height: 50px;font-weight:bold;color:white">事项信息</span></h5>
    </div>
    <div
      style="text-align:left;background-color: #2a2a2a;margin-left:5px;margin-right:5px;margin-bottom:5px;padding:10px;overflow-y:auto "
      v-bind:style="{ height: screenHeight-440 + 'px' }">
      <el-row>
        <el-col :span="8"><span style="color:white">事项名称：</span></el-col>
        <el-col :span="16"><span style="color:white">事项名称</span></el-col>
      </el-row>
      <el-row>
        <el-col :span="8"><span style="color:white">业务类型：</span></el-col>
        <el-col :span="16"><span style="color:white">个人</span></el-col>
      </el-row>
      <el-row>
        <el-col :span="8"><span style="color:white">实施主体：</span></el-col>
        <el-col :span="16"><span style="color:white">个人</span></el-col>
      </el-row>
    </div>


  </div>
</template>


<script>
  export default {
    name: 'Right',
    props: ['screenHeight'],
    data () {
      return {

      }
    }
  }
</script>

<style scoped>

  .aside_right_title {
    background-color: #4c4c4c;
    width: 220px;
    top: 0px;
  }

  .aside_right {
    /*background-color: #4c4c4c;*/
    width: 200px;
  }
</style>
