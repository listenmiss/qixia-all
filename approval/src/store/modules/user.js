/**
 * 用户模块
 */

import types from '../types.js'

 const state={
   count:6,
   token:"",
   refreshToken:""
 }

var getters={
	count(state){
		return state.count;
	},
  token(state){
    return state.token;
  }
  ,
  refreshToken(state){
    return state.refreshToken;
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
  saveToken({commit,state},token){

      commit(types.SAVETOKEN,token);

  },
  saveRefreshToken({commit,state},refresh){

    commit(types.SAVEREFRESHTOKEN,refresh);

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
  [types.SAVETOKEN](state,token){
    state.token=token;
  },
  [types.SAVEREFRESHTOKEN](state,refreshToken){
    state.refreshToken=refreshToken;
  }
}

export default {
	state,
	getters,
	actions,
	mutations
}
