/**
 * 用户模块
 */

import types from '../types.js'

const state={
  curStats:{}
}

var getters={
  curStats(state){
    return state.curStats;
  }
}

const actions = {

  setCurStats({commit,state},curStats){

    commit(types.SETCURSTATS,curStats);

  }
}

const mutations={
  [types.SETCURSTATS](state,curStats){
    state.curStats=curStats;
  }
}

export default {
  state,
  getters,
  actions,
  mutations
}
