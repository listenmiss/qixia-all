<template>
  <div>
    <div class="aside_left_title">
      <h5 style="margin-bottom:0px;"><span style="height:30px;line-height: 50px;font-weight:bold;color:white">掌上社区业务流转</span>
      </h5>
    </div>
    <div class="aside_left_menu" v-bind:style="{ height: screenHeight-180 + 'px' }">

      <ul style="width:100%;padding:0px;" v-for="(item,index) in allStats">
        <li class="aside_left_li_normal"  v-bind:class="{ aside_left_li_active: selectedIndex === index }" @click="changeItem(index,item)"><span style="font-size:14px;">{{item.user.nickname}}</span></li>
        <!--<li class="aside_left_li_normal"><span style="font-size:14px;">申请人姓名</span></li>-->
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
        selectedIndex:0
      }
    },
    computed:mapGetters([
      'token',
      'refreshToken',
      'allStats'
    ]),
    created: function () {
      //  alert(this.token);
//      alert(this.refreshToken);

      var url ="/approval-api/stats/findMatterStatsByInsertStart";
      var params={};
      params.insert_start=1;
      var that = this;
      this.axios.get(url,{
        params: params
      })
        .then(function (response) {
      

//          if(response.data!=null && response.data.length>0&&response.data.allStats!=null)
//          {
              let datas = response.data;

               that.$store.dispatch("setCurStats",datas[0]);
                that.$store.dispatch("setAllStats",datas);
//          }

          console.log(response.data);
        })
        .catch(function (error) {
   
//          that.$message({
//            message: '用户名或密码错误，请重新输入！',
//            type: 'warning'
//          });
        });
    },	methods: {
      changeItem(index,item){
        this.selectedIndex = index;
        this.$store.dispatch("setCurStats",item);
      }
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
    height:58px;line-height: 58px;
    background-color:#dcdcdc;
    color: #ed9100;
    /*border-top:1px solid #ed9100;*/
    /*border-bottom:1px solid #ed9100;*/
    /*border:1px solid #ed9100;*/
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
