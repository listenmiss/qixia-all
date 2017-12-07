/**
 * 用户模块
 */

import types from '../types.js'



const state={
  jdepIds:"11,12,13,14,15,16,17,32,33,4,28,31,1,3,9,5",
  todayFinishMatters:[],
  finishMattersCount:{
    todayCount:0,
    weekCount:0,
    monthCount:0,
    yearCount:0,
    allCount:0
  },
  lastMatterStats:[]

}

var getters={
  jdepIds(state){
    return state.jdepIds;
  },
  todayFinishMatters(state){
    return state.todayFinishMatters;
  },
  finishMattersCount(state){
    return state.finishMattersCount;
  },
  lastMatterStats(state){
    return state.lastMatterStats;
  }
}

const actions = {


  updateTodayFinishMatters({commit,state},todayFinishMatters){

    commit(types.UPDATETODAYFINISHMATTERS,todayFinishMatters);

  },updateFinishMattersCount({commit,state},obj){

    commit(types.UPDATEFINISHMATTERSCOUNT,obj);

  },updateLastMatterStats({commit,state},arr){

    commit(types.UPDATELASTMATTERSTATS,arr);

  }

}

const mutations={
  [types.UPDATETODAYFINISHMATTERS](state,todayFinishMatters){
    state.todayFinishMatters=todayFinishMatters;
  },
  [types.UPDATEFINISHMATTERSCOUNT](state,obj){
    state.finishMattersCount=obj;
  },
  [types.UPDATELASTMATTERSTATS](state,arr){
    state.lastMatterStats=arr;
  }
}

export default {
  state,
  getters,
  actions,
  mutations
}
