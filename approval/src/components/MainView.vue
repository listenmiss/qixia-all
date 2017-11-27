<template>
  <div>
    <div style="width:100%;height:50px;line-height: 50px;">
      <span style="float:left;font-weight:bold;font-size:16px;">待审核文件</span>
      <div style="float:right;">
        <el-button type="primary" @click="handleStatus(2)">待审通过</el-button>
        <el-button type="warning" @click="handleStatus(3)">驳回</el-button>
      </div>
    </div>

    <div style="width:100%;height:42px;background-color:#4c4c4c;">

    </div>


    <ul style="width:100%;padding:0px;margin: 0px;background-color:#ffffff;overflow-y: auto" v-bind:style="{ height: screenHeight-250 + 'px' }" >
      <li class="container_main_li"  v-bind:class="{ container_main_li_active: selectedIndex === index }" @click="changeItem(index,item)"  v-for="(item,index) in curDocs"><span style="font-size:14px;">{{index+1}}.{{item}}</span></li>

    </ul>
  </div>
</template>


<script>
  import {mapState,mapGetters,mapActions} from 'vuex'
  export default {
    name: 'MainView',
    props: ['screenHeight'],
    data () {
      return {
        selectedIndex:0,
        curDocs:[]
      }
    },
    computed: {
      ...mapGetters([
        'curStats'
      ])
    },
    watch: {
      curStats: function(a, b) {
//        console.log(a);
//        console.log(b);
        this.changeDocs();
      }
    },	methods: {
      changeDocs(){
        let idx=this.curStats.idx;
        var url ="/approval-api/stats/findMatterStatsDocs";
        var params={};
        params.id=idx;
        var that = this;
        this.axios.get(url,{
          params: params
        })
          .then(function (response) {
            if(response.data)
            {
              that.curDocs = response.data

              if(curDocs || curDocs.length==0)
              {
                that.$message.error('无审核文件！');
              }
            }else {
              that.$message.error('无审核文件！');
            }
            console.log(response.data);
          })
          .catch(function (error) {
            that.$message.error('无审核文件！');
          });
      },  changeItem(index,item){
        this.selectedIndex = index;
        this.$store.dispatch("setCurStats",item);
      },handleStatus(status)
      {
        var url ="/approval-api/stats/updateMatterStatsInsertStart";
        var params={};
        params.id=this.curStats.idx;
        params.status=status;
        var that = this;


        this.axios.post(url,params)
          .then(function (response) {

            if(response.data)
            {

              that.$message({
                message: '处理成功！',
                type: 'success'
              });
            }else {
              that.$message({
                message: '处理失败！',
                type: 'warning'
              });
            }
            console.log(response);
          })
          .catch(function (error) {
            that.$message({
              message: '处理失败！',
              type: 'warning'
            });
          });
      }


    },
    created: function () {

      this.changeDocs();

    }
  }
</script>

<style scoped>
  .container_main_li{
    height:50px;
    line-height: 50px;
    border-bottom: 1px solid #cccccc;
    text-align: left;
    padding-left:20px;
  }
  .container_main_li_active{

    background-color:#dcdcdc;
    color: #ed9100;
    /*border-top:1px solid #ed9100;*/
    /*border-bottom:1px solid #ed9100;*/
    /*border:1px solid #ed9100;*/
  }
</style>
