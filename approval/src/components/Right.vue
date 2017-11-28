<template>
  <div style="background-color: #4c4c4c;" v-bind:style="{ height: screenHeight-130 + 'px' }">
    <div class="aside_right_title">
      <h5 style="margin-bottom:0px;"><span style="height:30px;line-height: 50px;font-weight:bold;color:white">业务对象信息</span>
      </h5>
    </div>
    <div
      style="text-align:left;background-color: #2a2a2a;margin-left:5px;margin-right:5px;padding:10px;overflow-y: auto;height:180px;">
      <el-row>
        <el-col :span="9"><span style="color:white">姓名：</span></el-col>
        <el-col :span="15"><span style="color:white">{{curStats.m_name}}</span></el-col>
      </el-row>
      <el-row>
        <el-col :span="9"><span style="color:white">性别：</span></el-col>
        <el-col :span="15"><span style="color:white">{{curStats.m_dname}}</span></el-col>
      </el-row>
      <el-row>
        <el-col :span="9"><span style="color:white;">身份证号码：</span></el-col>
        <el-col :span="15"><span style="color:white">{{curStats.m_cer_nno}}</span></el-col>
      </el-row>
      <el-row>
        <el-col :span="9"><span style="color:white">联系方式：</span></el-col>
        <el-col :span="15"><span style="color:white">{{curStats.m_tel}}</span></el-col>
      </el-row>
      <el-row>
        <el-col :span="9"><span style="color:white">家庭住址：</span></el-col>
        <el-col :span="15"><span style="color:white">{{curStats.m_addr}}</span></el-col>
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
        <el-col :span="16"><span style="color:white">{{curItem.item_name}}</span></el-col>
      </el-row>
      <el-row>
        <el-col :span="8"><span style="color:white">业务类型：</span></el-col>
        <el-col :span="16"><span style="color:white">{{curItem.item_state|businessTypeFilter}}</span></el-col>
      </el-row>
      <el-row>
        <el-col :span="8"><span style="color:white">实施主体：</span></el-col>
        <el-col :span="16"><span style="color:white">{{curDepartment.depart_name}}</span></el-col>
      </el-row>
    </div>


  </div>
</template>


<script>
  import {mapState,mapGetters,mapActions} from 'vuex'
  export default {
    name: 'Right',
    props: ['screenHeight'],
    data () {
      return {
       curDepartment:{},
        curItem:{}
      }
    },
    computed:{
      ...mapGetters([
      'curStats'
    ])
    },
    watch: {
      curStats: function(a, b) {
//        console.log(a);
//        console.log(b);
        this.changeItem();
      }
    },	methods: {
      changeItem(){
      
        let itemId=this.curStats.itemid;
        var url ="/approval-api/item/findItemById";
        var params={};
        params.id=itemId;
        var that = this;
        this.axios.get(url,{
          params: params
        })
          .then(function (response) {

            if(response.data)
            {
              that.curItem = response.data;
              if(that.curItem)
              {
                that.curDepartment = that.curItem.department;
              }
            }
            console.log(response.data);
          })
          .catch(function (error) {

          });
      }
    },
    created: function () {

      this.changeItem();

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
