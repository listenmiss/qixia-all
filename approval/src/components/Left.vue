<template>
  <div>
    <div class="aside_left_title">
      <h5 style="margin-bottom:0px;"><span style="height:30px;line-height: 50px;font-weight:bold;color:white">掌上社区业务扭转</span>
      </h5>
    </div>
    <div class="aside_left_menu" v-bind:style="{ height: screenHeight-180 + 'px' }">

      <ul style="width:100%;padding:0px;">
        <li class="aside_left_li_active"><span style="font-size:14px;">申请人姓名</span></li>
        <li class="aside_left_li_normal"><span style="font-size:14px;">申请人姓名</span></li>
      </ul>
    </div>
  </div>
</template>


<script>
  import {mapState,mapGetters,mapActions} from 'vuex'
  export default {
    name: 'Left',
    props: ['screenHeight'],
    data () {
      return {

      }
    },
    computed:mapGetters([
      'token',
      'refreshToken'
    ]),
    created: function () {
      //  alert(this.token);
//      alert(this.refreshToken);
      var url ="/approval-api/stats/findMatterStatsByInsertStart";
      var params={};
      params.insert_start=1;
      var that = this;
      this.$axios.get(url,{
        params: params
      })
        .then(function (response) {

          console.log(response);
        })
        .catch(function (error) {
//          that.$message({
//            message: '用户名或密码错误，请重新输入！',
//            type: 'warning'
//          });
        });
    }
  }
</script>

<style scoped>
  .aside_left {
    /*background-color: rgb(84, 92, 100);*/
    width: 220px;
  }

  .aside_left_title {
    background-color: #4c4c4c;
    width: 220px;
    top: 0px;
  }

  .aside_left_li_active{
    height:58px;line-height: 58px;background-color: #eeeeee;color: #ed9100;
  }

  .aside_left_li_normal{
    height:58px;line-height: 58px;
  }
  .aside_left_menu {
    width: 220px;
    background-color: #ffffff;
    overflow-y: auto
  }
</style>
