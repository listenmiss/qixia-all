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


    <ul style="width:100%;padding:0px;margin: 0px;background-color:#ffffff;overflow-y: auto" v-bind:style="{ height: screenHeight-270 + 'px' }" >
      <li class="container_main_li"  v-bind:class="{ container_main_li_active: selectedIndex === index }" @click="changeItem(index,item)"  v-for="(item,index) in curDocs"><span style="font-size:14px;">{{index+1}}.{{item}}</span> 

      <i   v-show="ifShow(item)" class="el-icon-success" style="float:right;margin-right:10px;line-height:50px;color:#67c23a;font-size:18px;"></i>

      </li>

    </ul>
    <el-button type="success" style=" margin-top: 10px;float: right;"  @click="download">下载</el-button>
  </div>
</template>


<script>
  import {mapState,mapGetters,mapActions} from 'vuex'
  import conf from '../util/conf.js'

  export default {
    name: 'MainView',
    props: ['screenHeight'],
    data () {
      return {
        selectedIndex:0,
        curDocs:[],
        downloadFiles:[]
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

            //  if( that.curDocs == null ||  that.curDocs.length==0)
            //  {
             //        that.$message({
             //         message: '无审核文件！',
             //         type: 'warning'
             //       });
             //   
             // }
            }else {
               //   that.$message({
                 //      message: '无审核文件！',
                   //   type: 'warning'
                   //        });
            }
            console.log(response.data);
          })
          .catch(function (error) {
                  //  that.$message({
                  //     message: '无审核文件！',
                   //   type: 'warning'
                  //  });
          });
      },  changeItem(index,item){
        this.selectedIndex = index;
       
      },handleStatus(status)
      {

          if(JSON.stringify(this.curStats) == "{}" )
          {
            
               this.$message({
                message: '请选择处理事项！',
                type: 'warning'
              });
              return;

          }
                   var params = {};
                  params.id =this.curStats.idx;
                   params.status = 2;

               
            let msg ="确认审核通过吗？是否继续？";
            if(status==3)
            {
               msg ="确认驳回吗？ 是否继续？";
                params.status = 3;
            }

              this.$confirm(msg, '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
              }).then(() => {


                  let url = conf.SERVERADDRESS+"/approval-api/stats/updateMatterStatsInsertStart"

var that = this
              this.axios.post(url,params)
                .then(function (response) {

                  if(response.data)
                  {

                   that.$store.dispatch("handleStats",params.id);

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

              }).catch(() => {
                  
              });



      },download()
      {
            
           if(this.curDocs==null || this.curDocs.length==0)
           {
                  this.$message({
                    message: '当前无文件可下载！',
                    type: 'warning'
                  });
           } else
           {
                   let userid =this.curStats.userid;
                   let idx = this.curStats.idx;

                
                    let name = this.curDocs[this.selectedIndex];

                    let url = conf.SERVERADDRESS+"/approval-api/fileTransfer/download?userid="+userid+"&idx="+idx+"&&filename="+name;
                    window.location.href = url;

                    let key = userid+"##"+idx+"##"+name
                    this.downloadFiles.push(key);

                 
           }
      },ifShow(item)
      {
                let userid =this.curStats.userid;
                   let idx = this.curStats.idx;

                

             let find=false;
             for(let i=0;i<this.downloadFiles.length;i++)
             {
              let key = userid+"##"+idx+"##"+item
               if(this.downloadFiles[i]==key)
               {
                     find=true;
                     break;
               }
             }
             return find;
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
