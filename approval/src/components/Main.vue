<template>
  <div class="mainview">
    <el-container>
      <el-header class="main_header">

        <div class ="header_wrap_div">
          <div class="header_left">
            <h3><span class="header_title">栖霞掌上社区业务审批平台</span></h3>
          </div>
          <div class="header_right" style="float:right">
            <i class="fa fa-user-circle-o" style="font-size:25px" aria-hidden="true"></i>
            <span style="margin-left: 10px;margin-right: 10px;">欢迎admin登陆</span>
            <router-link :to="{ path: '/' }">
              <span style="margin-left: 10px;margin-right: 10px;font-weight:bold;color:#2db7fe">退出</span>
            </router-link>
          </div>
        </div>

      </el-header>
      <el-container class="container_div">

          <el-aside class="aside_left" style="width:220px;">
              <div class="aside_left_title">
                <h5><span style="height:30px;line-height: 50px;font-weight:bold;color:white">掌上社区业务扭转</span></h5>
              </div>
            <div  class="aside_left_menu" v-bind:style="{ height: windowHeight-190 + 'px' }">

              <ul style="width:100%;padding:0px;" >
                <li style="height:58px;line-height: 58px;"><span style="font-size:14px;color: #ed9100;">申请人姓名</span></li>
                <li style="height:58px;line-height: 58px;"><span style="font-size:14px;color: #ed9100;">申请人姓名</span></li>
              </ul>
            </div>


            </el-aside>
          <el-main>Main</el-main>
          <el-aside class="aside_right" style="width:264px;">
            <div style="background-color: #4c4c4c;" v-bind:style="{ height: windowHeight-140 + 'px' }">
              <div class="aside_left_title">
                <h5 style="margin-bottom:0px;"><span style="height:30px;line-height: 50px;font-weight:bold;color:white">业务对象信息</span></h5>
              </div>
              <div style="text-align:left;background-color: #2a2a2a;margin-left:5px;margin-right:5px;padding:10px;overflow-y: auto;height:180px;">
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
              <div class="aside_left_title">
                <h5 style="margin:0px;"><span style="height:30px;line-height: 50px;font-weight:bold;color:white">事项信息</span></h5>
              </div>
              <div style="text-align:left;background-color: #2a2a2a;margin-left:5px;margin-right:5px;margin-bottom:5px;padding:10px;height:460px;">
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

          </el-aside>

      </el-container>
    </el-container>

    <el-footer class="main_footer">

      <div style="margin-top:8px;">
        <span style="font-size: 13px;margin-top:20px;">版本号V1.0.0</span><br/>
        <span style="font-size: 13px">栖霞掌上社区业务审批平台</span>
      </div>



    </el-footer>
  </div>
</template>

<script>
  export default {
    name: 'Main',
    data () {

      return {
        msg: '这是主界面'
      }
    },

    computed: {
      // 计算属性的 getter
      windowHeight: function () {
        // `this` 指向 vm 实例
       var windowHeight = $(window).height();
        return windowHeight;
      }
    },
    created: function () {
//      $("#aside_left_wrap").css("height", "300px");
//      $("#aside_left_wrap").height($(window).height() - 50);
    }
  }
</script>

<style scoped>
  li {list-style-type:none;}
  .main_header{
    background-color: #ffffff;
    margin-top: 0px;
    top:0px;
    text-align: center;
    border-bottom: 2px solid #cccccc;
  }
  .main_footer{
    background-color: #ffffff;
    margin-top: 0px;
    top:0px;
    text-align: center;
    border-top: 2px solid #cccccc;
  }


  .header_wrap_div{
    margin:0 auto; width:1200px;
  }
.header_title{
  text-align:center;
  font-weight: bold;
  /*color: #ec9101;*/

  color:#2db7fe;

}
  .header_left{
    float:left;
    text-align:center;
    line-height:60px;
  }

  .header_right{
    float:right;
    text-align:center;
    line-height:60px;
  }



.container_div{
  margin:0 auto; width:1200px;
}

  .aside_left{
    /*background-color: rgb(84, 92, 100);*/
    width:220px;
  }
  .aside_left_title{
    background-color: #4c4c4c;
    width:220px;
    top:0px;
  }

  .aside_left_menu{
    width:220px;background-color: #ffffff;overflow-y: scroll
  }
  .aside_right{
    /*background-color: #4c4c4c;*/
    width:200px;
  }
</style>
