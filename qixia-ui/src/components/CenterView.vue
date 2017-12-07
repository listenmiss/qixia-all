<template>

  <div >
    <el-col :xs="24" :sm="6" >
      <div class="date_div">
        <div style="width:100%;    height: 65px;">
          <span style="font-size:20px; color: #2db7fe; float: left;margin-top:27px;margin-left:20px;">星期{{realTime.nowWeek}}</span>
          <img style=" float: left;width:38px;height:37px;margin-top: 22px;margin-left:30px;" src="../assets/images/sunny.png"/>

        </div>

        <div style="width:100%; height: 65px;">
          <span style="font-size:40px; color: #2db7fe; float: left;margin-left:20px;">{{realTime.nowDay}}</span>
          <span style="font-size:20px; color: #2db7fe; float: left;margin-left:16px;margin-top: 10px;">{{realTime.nowMonth}}月</span>
          <span style="font-size:40px; color: #2db7fe; float: left;margin-left:30px;">{{realTime.nowHours}}:{{realTime.nowMiunte}}</span>
          <span style="font-size:20px; color: #2db7fe; float: left;margin-left:14px;margin-top: 20px;">{{realTime.afternoon}}</span>
        </div>

      </div>

      <div class="news_div">
        <div style="width:100%" v-for="(item,index) in lastMatterStats">
          <span style="font-size:16px; color: #2db7fe; float: left;margin-top:8px;margin-left:10px;" >{{item.request_time.hours}}:{{item.request_time.minutes}}-{{item.request_time.item_name}}（{{item.item_name}}）{{item.m_name}}</span>
        </div>


      </div>

      <div class="sxbjs_div">

        <img src="../assets/images/header_arrow_right.png"  style="float:left;margin-left:50px;margin-top:15px;width:19px;height:14px;"/>
        <span style="font-size:28px; color: #2db7fe;  font-family:'Microsoft YaHei';">事项办结数</span>
        <img src="../assets/images/header_arrow_left.png"   style="float:right;margin-right:50px;margin-top:15px;width:19px;height:14px;"/>
      </div>

      <div class="sxbjs_item_div">

        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: left;margin-left: 90px;line-height: 35px;">今日：</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';margin-left:18px;line-height: 35px;">{{finishMattersCount.todayCount}}</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: right;margin-right: 90px;line-height: 35px;">件</span>
      </div>
      <div class="sxbjs_item_div">

        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: left;margin-left: 90px;line-height: 35px;">本周：</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';line-height: 35px;">{{finishMattersCount.weekCount}}</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: right;margin-right: 90px;line-height: 35px;">件</span>
      </div>
      <div class="sxbjs_item_div">

      <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: left;margin-left: 90px;line-height: 35px;">本月：</span>
      <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';line-height: 35px;">{{finishMattersCount.monthCount}}</span>
      <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: right;margin-right: 90px;line-height: 35px;">件</span>

    </div>
      <div class="sxbjs_item_div">

        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: left;margin-left: 90px;line-height: 35px;">今年：</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';line-height: 35px;">{{finishMattersCount.yearCount}}</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: right;margin-right: 90px;line-height: 35px;">件</span>

      </div>
      <div class="sxbjs_item_div">

        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: left;margin-left: 90px;line-height: 35px;">总计：</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';line-height: 35px;">{{finishMattersCount.allCount}}</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: right;margin-right: 90px;line-height: 35px;">件</span>


      </div>
      <div class="sxbjs_div">

        <img src="../assets/images/header_arrow_right.png"  style="float:left;margin-left:50px;margin-top:15px;width:19px;height:14px;"/>
        <span style="font-size:28px; color: #2db7fe;  font-family:'Microsoft YaHei';">用户动态</span>
        <img src="../assets/images/header_arrow_left.png"   style="float:right;margin-right:50px;margin-top:15px;width:19px;height:14px;"/>
      </div>
      <div class="sxbjs_item_div">

        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: left;margin-left: 60px;line-height: 35px;">在线人数：</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';line-height: 35px;">{{userCountInfo.onlineCount}}</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: right;margin-right: 60px;line-height: 35px;">人</span>

      </div>
      <div class="sxbjs_item_div">

        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: left;margin-left: 60px;line-height: 35px;">用户总数：</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';line-height: 35px;">{{userCountInfo.allCount}}</span>
        <span style="font-size:20px; color: #2db7fe;  font-family:'Microsoft YaHei';float: right;margin-right: 60px;line-height: 35px;">人</span>


      </div>

    </el-col>
  </div>


</template>


<script>
  import {mapState,mapGetters,mapActions} from 'vuex'
  export default {
    name: 'CenterView',
    data () {
      return {
      realTime:{
        nowWeek:"一",
        nowMonth:"一",
        nowDay:1,
        nowHours:"00",
        nowMiunte:"00",
        afternoon:"上午"
      },
        userCountInfo:{
          onlineCount:0,
          allCount:0
        }

      }
    },
    computed: {
      ...mapGetters([
        'jdepIds',
        'finishMattersCount',
        'lastMatterStats'
      ])
    },
      mounted() {
        this.showTime();
        this.refresh();;

        setInterval(this.showTime, 60000);

//        setInterval(this.refresh, 2000);
      },
    methods: {
      refresh()
      {
        this.showTime();
        this.refreshLastDatas();
        this.refreshDatas();
        this.refreshUserCountInfo();
      },
      refreshUserCountInfo()
      {
        var url ="/stats-api/statsApi/getUserCountInfo";
        var params={};


        var that = this;
        this.axios.get(url,{
          params: params
        }).then(function (response) {
         that.userCountInfo=response.data;

        }) .catch(function (error) {
          console.log(error);
        });


      },
      refreshLastDatas()
      {
        var url ="/stats-api/statsApi/findLastMatterStats";
        var params={};

        params.count=3;

        var that = this;
        this.axios.get(url,{
          params: params
        }).then(function (response) {
          that.$store.dispatch("updateLastMatterStats",response.data);

        }) .catch(function (error) {
          console.log(error);
        });


      },
      refreshDatas()
      {
        var url ="/stats-api/statsApi/getDepartmentsMatterStatsCountInfo";
        var params={};

        params.state=5;
        params.jdepIds=this.jdepIds;

        var that = this;
        this.axios.get(url,{
          params: params
        }).then(function (response) {
          that.$store.dispatch("updateFinishMattersCount",response.data);

        }) .catch(function (error) {
            console.log(error);
          });


      },showTime()
      {

        var nowDate = new Date();

        var month = nowDate.getMonth()+1;
        switch(month)
        {
          case 1:
            this.realTime.nowMonth="一";break;
          case 2:
            this.realTime.nowMonth ="二";break;
          case 3:
            this.realTime.nowMonth="三";break;
          case 4:
            this.realTime.nowMonth  ="四";break;
          case 5:
            this.realTime.nowMonth ="五";break;
          case 6:
            this.realTime.nowMonth ="六";break;
          case 7:
            this.realTime.nowMonth ="七";break;
          case 8:
            this.realTime.nowMonth ="八";break;
          case 9:
            this.realTime.nowMonth ="九";break;
          case 10:
            this.realTime.nowMonth ="十";break;
          case 11:
            this.realTime.nowMonth ="十一";break;
          case 12:
            this.realTime.nowMonth ="十二";break;
          default:break;

        }



        var week = nowDate.getDay();
         if(week == 0)
         {
           this.realTime.nowWeek ="天";
         }else if(week == 1)
        {
          this.realTime.nowWeek ="一";
        }else if(week == 2)
        {
          this.realTime.nowWeek ="二";
        }else if(week == 3)
         {
           this.realTime.nowWeek ="三";
         }else if(week == 4)
         {
           this.realTime.nowWeek ="四";
         }else if(week == 5)
         {
           this.realTime.nowWeek ="五";
         }else if(week == 6)
         {
           this.realTime.nowWeek ="六";
         }

        var date = nowDate.getDate();
        date = date>9 ? date : "0" + date;
        this.realTime.nowDay =date;

        var hour = nowDate.getHours();
        this.realTime.afternoon =hour>12? "下午" : "上午" ;
        hour = hour>9 ? hour : "0" + hour;
        this.realTime.nowHours =hour;
        var miunte = nowDate.getMinutes();
        miunte = miunte>9 ? miunte : "0" + miunte;
        this.realTime.nowMiunte =miunte;


      }

    }



  }
</script>

<style scoped>
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
  .date_div{
    height:130px;
    background: url(../assets/images/date_div_bg.png);
    background-size: 100% 100%;
  }
  .news_div{
    height:130px;
    background: url(../assets/images/news_bg.png);
    background-size: 100% 100%;
    margin-top:18px;
  }
  .sxbjs_div{
    text-align: center;
    margin-top:10px;
    margin-bottom:10px;
  }
  .sxbjs_item_div{
    height:35px;
    background: url(../assets/images/sx_count_bg.png);
    background-size: 100% 100%;
    margin-top:8px;
  }
</style>
