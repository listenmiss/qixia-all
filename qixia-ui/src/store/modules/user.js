/**
 * 用户模块
 */

import types from '../types.js'

 const state={
   count:6,
   userInfo:null
 }

var getters={
	count(state){
		return state.count;
	},
  userInfo(state){
    return state.userInfo;
  }
}

const actions = {
	increment({commit,state}){
		commit(types.INCREMENT); //提交一个名为increment的变化，名称可自定义，可以认为是类型名
	},
	decrement({commit,state}){
		if(state.count>10){
			commit(types.DECREMENT);
		}
	},
  saveUserInfo({commit,state},userInfo){

      commit(types.SAVEUSERINFO,userInfo);

  }
}

const mutations={
	[types.INCREMENT](state){
		state.count++;
	},
	[types.DECREMENT](state){
		state.count--;
	}
  ,
  [types.SAVEUSERINFO](state,userInfo){
    state.userInfo=userInfo;
  }
}

export default {
	state,
	getters,
	actions,
	mutations
}
