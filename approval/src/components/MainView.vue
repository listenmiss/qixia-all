<template>
  <div>
    <div style="width:100%;height:50px;line-height: 50px;">
      <span style="float:left;font-weight:bold;font-size:16px;">待审核文件</span>
      <div style="float:right;">
        <el-button type="primary">待审通过</el-button>
        <el-button type="warning">驳回</el-button>
      </div>
    </div>

    <div style="width:100%;height:42px;background-color:#4c4c4c;">

    </div>


    <ul style="width:100%;padding:0px;margin: 0px;background-color:#ffffff;overflow-y: auto" v-bind:style="{ height: screenHeight-250 + 'px' }">
      <li class="container_main_li"><span style="font-size:14px;">文件名称一</span></li>
      <li class="container_main_li"><span style="font-size:14px;">文件名称一</span></li>
      <li class="container_main_li"><span style="font-size:14px;">文件名称一</span></li>
      <li class="container_main_li"><span style="font-size:14px;">文件名称一</span></li>
      <li class="container_main_li"><span style="font-size:14px;">文件名称一</span></li>
      <li class="container_main_li"><span style="font-size:14px;">文件名称一</span></li>
      <li class="container_main_li"><span style="font-size:14px;">文件名称一</span></li>
      <li class="container_main_li"><span style="font-size:14px;">文件名称一</span></li>
      <li class="container_main_li"><span style="font-size:14px;">文件名称一</span></li>
      <li class="container_main_li"><span style="font-size:14px;">文件名称一</span></li>
      <li class="container_main_li"><span style="font-size:14px;">文件名称一</span></li>
      <li class="container_main_li"><span style="font-size:14px;">文件名称一</span></li>
      <li class="container_main_li"><span style="font-size:14px;">文件名称一</span></li>
      <li class="container_main_li"><span style="font-size:14px;">文件名称一</span></li>
      <li class="container_main_li"><span style="font-size:14px;">文件名称一</span></li>
      <li class="container_main_li"><span style="font-size:14px;">文件名称一</span></li>

    </ul>
  </div>
</template>


<script>
  export default {
    name: 'MainView',
    props: ['screenHeight'],
    data () {
      return {

      }
    }
  }
</script>

<style scoped>
  .container_main_li{
    height:50px;line-height: 50px;border-bottom: 1px solid #eeeeee;
  }

</style>
