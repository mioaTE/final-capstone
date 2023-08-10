<template>
  <div id="navbar"  :class="$store.state.isDark ? 'darkmode' : 'lightmode'">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
     
     
      <section id="darkmodebutton">
        <button id="toggle-dark" @click="toggleDark()">Toggle Dark Mode</button>
      </section>


      <section id="navbarsection">
        <router-link class="btn" id="navbutton" v-bind:to="{ name: 'home' }" ><i  class="fa fa-home"></i>  Home</router-link>
      <img src="../assets/TEgram-logo.png" id="TEgram-logo" />
      <router-link class="btn" id="navbutton" v-show="isNotInLogin()" v-bind:to="{ name: 'logout' }"><i class="icon-user" ></i>{{$store.state.token != '' ? '  Logout' : '  Login'}}</router-link>
      </section>
          
      
    </div>
</template>
<script>
export default {
  methods: {
    isNotInLogin() {
      return this.$router.history.current["path"] !== "/login";
    },
    toggleDark() {
        this.$store.commit('TOGGLE_DARK_MODE');
    }
  }
}
</script>

<style scoped>

#navbar {
  display: flex;
  justify-content: space-between;
    /* width: 100vw; */
    /* height: auto; */
  background-color:pink;
  height: 100%;
}

.lightmode body{
  margin: 0px;
}
.lightmode #navbutton{
  width: auto;
}

.lightmode button{
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
  width: auto;
  height: auto;
}
.lightmode button:hover {
  top: 3px;
  background-color:#e83e8c;
  -webkit-box-shadow: none;
  -moz-box-shadow: none;
  box-shadow: none;
}

.lightmode .btn{
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
.lightmode .btn:hover {
  top: 3px;
  background-color:#e83e8c;
  -webkit-box-shadow: none;
  -moz-box-shadow: none;
  box-shadow: none;
}
.lightmode #app {
  height: 100%;
  width: 100%;
}
.lightmode #TEgram-logo{
  height: 100%;
}
.lightmode .carousel-3d-container[data-v-07917306]{
  border-radius: 10px 10px 10px 10px;
  height: 300px;
}
.lightmode #darkmodebutton{
display: flex;
align-items: center;
justify-content: center;
margin-left: 2%;
}
.lightmode #navbarsection{
  display: flex;
  align-items: center;
justify-content: center;
  width: 100%;
}






.darkmode #navbar {
  display: flex;
  justify-content: space-between;
    /* width: 100vw; */
    /* height: auto; */
  background-color:rgb(85, 85, 85);
  height: 100%;
}
.darkmode button{
   display: inline-block;
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
  width: auto;
  height: auto;
}
.darkmode button:hover {
  top: 3px;
  background-color:#e83e8c;
  -webkit-box-shadow: none;
  -moz-box-shadow: none;
  box-shadow: none;
}

.darkmode .btn{
  display: inline-block;
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
.darkmode .btn:hover {
  top: 3px;
  background-color:#e83e8c;
  -webkit-box-shadow: none;
  -moz-box-shadow: none;
  box-shadow: none;
}
.darkmode #app {
  height: 100%;
  width: 100%;
}
.darkmode #TEgram-logo{
  height: 100%;
}
.darkmode .carousel-3d-container[data-v-07917306]{
  border-radius: 10px 10px 10px 10px;
  height: 300px;
}
.darkmode #darkmodebutton{
display: flex;
align-items: center;
justify-content: center;
margin-left: 2%;
}
.darkmode #navbarsection{
  display: flex;
  align-items: center;
justify-content: center;
  width: 100%;
}
</style>



