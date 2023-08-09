<template>
  <div id="app">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
    <div id="nav">
      <router-link class="btn" v-bind:to="{ name: 'home' }" ><i class="fa fa-home"></i>  Home</router-link>
      <img src="./assets/TEgram-logo.png" id="TEgram-logo" />
      <router-link class="btn" v-show="isNotInLogin()" v-bind:to="{ name: 'logout' }"><i class="icon-user"></i>{{$store.state.token != '' ? '  Logout' : '  Login'}}</router-link>
      
    </div>
    <router-view />
  </div>
</template>
<script>
export default {
  methods: {
    isNotInLogin() {
      return this.$router.history.current["path"] !== "/login";
    }
  }
}
  </script>

<style scoped>
body{
  margin: 0px;
}
#nav {
  display: flex;
  justify-content: space-evenly;
    /* width: 100vw; */
    /* height: auto; */
  background-color:pink;
}
.btn{
  display: inline-block;
  width: 5%;
  height: 25px;
  justify-content: center;
  align-items: center;
  font-family:'Open Sans', sans-serif;
  background-color: rgb(252, 142, 160);
  border: none; /* Remove borders */
  color: white; /* White text */
  padding: 10px; /* Some padding */
  margin: 5px;
  font-size: 16px; /* Set a font size */
  cursor: pointer; /* Mouse pointer on hover */
  text-decoration: none;
  border-radius: 25px;
}
.btn:hover {
  top: 3px;
  background-color:#e83e8c;
  -webkit-box-shadow: none; 
  -moz-box-shadow: none; 
  box-shadow: none;
}
#app{
height: 100%;
width: 100%;
}
#TEgram-logo{
  width: 150px;
  height: 90px;
  
  
}
</style>
