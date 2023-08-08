<template>
  <div id="app">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <div id="nav">
      <router-link class="btn" v-bind:to="{ name: 'home' }" ><i class="fa fa-home"></i> Home</router-link>&nbsp;|&nbsp;
      <router-link class="btn" v-show="isNotInLogin()" v-bind:to="{ name: 'logout' }">{{$store.state.token != '' ? 'Logout' : 'Login'}}</router-link>
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
#nav {
  background-color: pink;
}
.btn{
  background-color: rgb(252, 142, 160);
  border: none; /* Remove borders */
  color: white; /* White text */
  padding: 12px 16px; /* Some padding */
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
  width: 100%;
}
</style>
