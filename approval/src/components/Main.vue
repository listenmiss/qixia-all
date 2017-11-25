<template>
  <div class="mainview">
    <el-container>
      <el-header class="main_header">

        <Header></Header>

      </el-header>
      <el-container class="container_div">

        <el-aside class="aside_left" style="width:220px;">
          <Left :screenHeight="screenHeight"></Left>
        </el-aside>
        <el-main style="padding-top: 10px;">

          <Main-View :screenHeight="screenHeight"></Main-View>

        </el-main>
        <el-aside class="aside_right" style="width:264px;">

          <Right :screenHeight="screenHeight"></Right>
        </el-aside>

      </el-container>
    </el-container>

    <el-footer class="main_footer">
      <Footer></Footer>
    </el-footer>
  </div>
</template>

<script>

  import Header from './Header'
  import Left from './Left'
  import MainView from './MainView'
  import Right from './Right'
  import Footer from './Footer'

  export default {
    name: 'Main',
    data() {

      return {
        msg: '这是主界面',
        screenHeight: $(window).height()

      }
    },
    components: {
      Header,
      Left,
      MainView,
      Right,
      Footer
    },

    computed: {
//      // 计算属性的 getter
//      screenHeight: function () {
//        // `this` 指向 vm 实例
//       var screenHeight = document.body.clientHeight;
//        return screenHeight;
//      }
    },
    created: function () {
//      $("#aside_left_wrap").css("height", "300px");
//      $("#aside_left_wrap").height($(window).height() - 50);
    }
    , mounted() {
      const that = this
      window.onresize = () => {
        return (() => {
          that.screenHeight = $(window).height()
        })()
      }
    }
  }
</script>

<style scoped>
  li {
    list-style-type: none;
  }

  .main_header {
    background-color: #ffffff;
    margin-top: 0px;
    top: 0px;
    text-align: center;
    border-bottom: 2px solid #cccccc;
  }
  .main_footer {
    background-color: #ffffff;
    margin-top: 0px;
    top: 0px;
    text-align: center;
    border-top: 2px solid #cccccc;
  }



  .container_div {
    margin: 0 auto;
    width: 1200px;
  }







</style>
