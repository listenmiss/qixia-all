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
            <el-col :xs="24" :sm="12"   v-for="(item,index) in todayFinishMatters">
              <div class="ju_info_div" v-bind:class="{ 'c1': index%4==0, 'c2': index%4==1, 'c3': index%4==2, 'c4': index%4==3 }">
                <span class="ju_title_txt">{{item.depart_name}}</span>

                <span class="ju_value">{{item.stats_count}}</span>
              </div>

            </el-col>

          </el-row>




        </div>


      </div>

    </el-col>
  </div>
</template>


<script>
  import {mapState,mapGetters,mapActions} from 'vuex'
  export default {
    name: 'TodayMatter',
    props: ['screenHeight'],
    data () {
      return {

      }
    },
    computed: {
      ...mapGetters([
        'jdepIds',
        'todayFinishMatters'
      ])
    },
  created: function () {

  },
    mounted() {
      var that = this;
      let p1 =  this.initDatas();
      p1.then(function (response) {

        if(response.data!=null)
        {
          for(let i=0;i<response.data.length;i++)
          {
            response.data[i].stats_count= 0;
          }
        }
        that.$store.dispatch("updateTodayFinishMatters",response.data);
        that.refreshDatas();

      })
        .catch(function (error) {
          console.log(error);
        });
      this.refreshDatas();
      setInterval(this.refreshDatas, 2000);
    },methods: {
      initDatas(){
        var url ="/stats-api/statsApi/findAllDepartmentsByIds";
        var params={};
        params.jdepIds=this.jdepIds

        let p =this.axios.get(url,{
          params: params
        });
        return p;

      },
      refreshDatas(){

        var url ="/stats-api/statsApi/findAllDepartmentsMatterStatsToday";
        var params={};

        params.dateType=1;
        params.state=5;
        params.jdepIds=this.jdepIds;
        var that = this;
        this.axios.get(url,{
          params: params
        }).then(function (response) {
          that.$store.dispatch("updateTodayFinishMatters",response.data);


        })
          .catch(function (error) {
            console.log(error);
          });

      }
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
	margin-bottom:58px;
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


  .c1{
    border-left:8px solid #61d13e;
  }
  .c2{
    border-left:8px solid #01feff;
  }
  .c3{
    border-left:8px solid #ff5c0d;
  }
  .c4{
    border-left:8px solid #0183e8;
  }
</style>
