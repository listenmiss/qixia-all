<template>
  <div class="login_div">
    <section class="content ">
      <div class="logodiv">

        <div><img src="../assets/images/login/logo.png" height="68" width="65"/></div>
        <!--<div><img src="../img/title.png" height="44" width="300"/></div>-->
        <div class="login_title">
          <h3><span style="color: #f4bd83;">栖霞掌上社区业务审批平台</span></h3>
        </div>
        <div class="form-wrapper">
          <div class="linker">
            <span class="ring"></span>
            <span class="ring"></span>
            <span class="ring"></span>
            <span class="ring"></span>
            <span class="ring"></span>
          </div>
          <form class="login-form" action="#" method="post">
            <input type="text" name="username" placeholder="账号" />
            <input type="password" name="password" placeholder="密码" />
            <div class="checkbox">
              <input type="checkbox" id="checkbox_a2" class="chk_1" /><label for="checkbox_a2"></label>
              <span class="checkboxlabel">记住密码</span>
            </div>
            <button type="button" name="submit"   @click='login'>登  录</button>
          </form>
        </div>
      </div>
    </section>

  </div>
</template>

<script>
  export default {
    name: 'Login',
    data () {
      return {
        msg: '这是登陆界面'
      }
    },
    methods:{
      login()
      {

//        // 字符串
//        this.$router.push('/home/first')
//
//// 对象
//        this.$router.push({ path: '/home/first' })
//
//// 命名的路由
//        this.$router.push({ name: 'home', params: { userId: wise }})

        this.$router.push({ path: '/main' })
      }
    }
  }
</script>

<style scoped>
.login_title{
  margin:10px;
}
  .content{
    overflow: hidden;
    height: 100%;
  }
  /*.content {*/
  /*width:680px;*/
  /*height:320px;*/
  /*margin:50px auto;*/
  /*}*/
  .logodiv{
    width:300px;
    height:278px;
    text-align:center;
    position:absolute;
    top: 40%;
    left: 50%;
    margin-left: -132px;
    margin-top: -136px;
  }
  .form-wrapper {
    /*margin:32px auto;*/
    width:300px;
    height:278px;
    position:relative;
    /*top: 50%;*/
    /*left: 50%;*/
    /*margin-left: -132px;*/
    /*margin-top: -136px;*/
    border:1px solid rgb(197,200,204);
    background-color:rgb(248,249,250);
    text-align:center;
    border-radius:5px;
    box-shadow:0 1px 0 rgb(255,255,255), 0 2px 0 rgb(197,200,204), 0 3px 0 rgb(255,255,255), 0 4px 0 rgb(197,200,204);
  }
  .form-wrapper:before {
    content:"";
    display:block;
    height:37px;
    border-bottom:1px solid rgb(197,200,204);
    border-radius:5px 5px 0 0;
    box-shadow:inset 2px 2px 0 rgb(255,255,255);
  }
  .form-wrapper .login-form {
    padding-top:40px;
    box-shadow:inset 2px 0 0 rgb(255,255,255);
  }
  .form-wrapper input[name="username"] {
    height:40px;
    width: 200px;
    margin:0 auto;
    padding-left:15px;
    display:block;
    border:1px solid rgb(197,200,204);
    border-bottom:none;
    border-radius:5px 5px 0 0;
    box-shadow:inset 0 1px 0 rgb(212,214,217);
    background-color:rgb(228,230,233);
  }
  .form-wrapper input[name="password"] {
    height:40px;
    width: 200px;
    margin:0 auto;
    padding-left:15px;
    display:block;
    border:1px solid rgb(197,200,204);
    border-radius:0 0 5px 5px;
    background-color:rgb(228,230,233);
  }
  .form-wrapper button[name="submit"] {
    margin-top:10px;
    width:215px;
    height:44px;
    color:#fff;
    font-size:20px;
    border:none;
    border-top:1px solid rgb(190,143,48);
    position:relative;
    /*利用双背景制作垂直渐变色边框*/
    background: rgb(228,182,88) no-repeat;
    background-size:213px 41px,215px 43px;
    border-radius:5px;
    box-shadow:inset 0 1px 0 rgb(242,220,175);
    text-shadow:1px 1px 0 rgb(138,100,50);
    transition:color 300ms linear;
  }
  .form-wrapper button[name="submit"]:hover {
    color:rgb(195,188,81);
    background:rgb(196,84,64);
  }
  /*日历链条和环的制作*/
  .form-wrapper .linker {
    position:absolute;
    width:240px;
    height:40px;
    top:18px;
    left:30px;
  }
  /*上环*/
  .linker .ring {
    position:relative;
    display:inline-block;
    border:1px solid rgb(163,164,167);
    background-color:rgb(220,222,225);
    height:12px;
    width:12px;
    border-radius: 6px;
    margin-right:33px;
  }
  .linker .ring:last-child {
    margin-right:0;
  }
  /*下环*/
  .linker .ring:before {
    content:"";
    position:absolute;
    bottom:-25px;
    left:-1px;
    border:1px solid rgb(163,164,167);
    background-color:rgb(220,222,225);
    height:12px;
    width:12px;
    border-radius: 6px;
  }
  /*中间链条*/
  .linker .ring:after{
    content:"";
    position:absolute;
    top:2px;
    left:2px;
    width:6px;
    height:30px;
    border:1px solid rgb(202,202,202);
    background-color:rgb(255,255,255);
    border-radius: 3px;
  }
  .checkbox{
    text-align: left;
    padding-left:40px;
    margin-top: 10px;
    font-size: 14px;
    color: #555;
  }

  /*checkbox*/
  .chk_1 {
    display: none;
  }

  /*******STYLE 1*******/
  .checkboxlabel{
    vertical-align: top;
  }
  .chk_1 + label {
    background-color: #FFF;
    border: 1px solid #C1CACA;
    box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05), inset 0px -15px 10px -12px rgba(0, 0, 0, 0.05);
    padding: 9px;
    border-radius: 5px;
    display: inline-block;
    position: relative;
  }
  .chk_1 + label:active {
    box-shadow: 0 1px 2px rgba(0,0,0,0.05), inset 0px 1px 3px rgba(0,0,0,0.1);
  }

  .chk_1:checked + label {
    background-color: #ECF2F7;
    border: 1px solid #92A1AC;
    box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05), inset 0px -15px 10px -12px rgba(0, 0, 0, 0.05), inset 15px 10px -12px rgba(255, 255, 255, 0.1);
    color: #243441;
  }

  .chk_1:checked + label:after {
    content: '\2714';
    position: absolute;
    top: 0px;
    left: 0px;
    color: #0def0b;
    width: 100%;
    text-align: center;
    /*font-size: 1.4em;*/
    padding: 1px 0 0 0;
    /*vertical-align: text-top;*/
  }


  #checkbox_d2 + label:after, #checkbox_d2 + label:before, #checkbox label {
    -webkit-transition: all 0.1s ease-in;
    transition: all 0.1s ease-in;
  }

  .login_div{
    background-image:url(../assets/images/bg.jpg);
  }
</style>
