/**
 * 用户模块
 */

import types from '../types.js'

const state={
  curStats:{},
  allStats:[]
}

var getters={
  curStats(state){
    return state.curStats;
  },
    allStats(state){
    return state.allStats;
  }
}

const actions = {

  setCurStats({commit,state},curStats){

    commit(types.SETCURSTATS,curStats);

  },
    setAllStats({commit,state},allStats){

    commit(types.SETALLSTATS,allStats);

  },
   handleStats({commit,state},idx){
    let newDatas =[];

    if(state.allStats!=null && state.allStats.length>0)
    {
      for(let i=0;i<state.allStats.length;i++)
      {
        if(state.allStats[i].idx !=idx)
        {
          newDatas.push(state.allStats[i]);
        }else
        {
          //设置当前处理事项
          if(i==state.allStats.length-1)//如果是最后一个
          {
            // commit(types.SETCURSTATS,state.allStats[i+1]);
            
            commit(types.SETCURSTATS,{});

          }else{
           
              commit(types.SETCURSTATS,state.allStats[i+1]);

          }
          
        }
      }
       commit(types.SETALLSTATS,newDatas);
    }

  }

}

const mutations={
  [types.SETCURSTATS](state,curStats){
    state.curStats=curStats;
  },
    [types.SETALLSTATS](state,allStats){
    state.allStats=allStats;
  }
}

export default {
  state,
  getters,
  actions,
  mutations
}
