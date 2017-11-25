<template>
  <div id="app">
    <router-view/>
    <div style="display:none">

      <button @click="increment">增加</button>
      <button @click="decrement">减小</button>
      <button @click="incrementAsync">增加</button>
      <p>当前数字为：{{count}}</p>
      <p>{{isEvenOrOdd}}</p>

    </div>
  </div>
</template>

<script>
  import {mapState,mapGetters,mapActions} from 'vuex'
export default {
  name: 'app',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  //方式1：通过this.$store访问
  /*computed:{
    count(){
      return this.$store.state.count;
    }
  }*/
  /*computed:mapState([
    'count'
  ]),*/
  computed:mapGetters([
    'count',
    'isEvenOrOdd'
  ]),
  methods:mapActions([
    'increment',
    'decrement',
    'incrementAsync'
  ])
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /*margin-top: 60px;*/
  top:0px;
  height:100%;
}
</style>
