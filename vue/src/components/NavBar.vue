<template>
  <div id="navbar"  :class="$store.state.isDark ? 'darkmode' : 'lightmode'">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
     
     
     
      <section id="darkmodebutton">
        <button id="toggle-dark" @click="toggleDark()">{{$store.state.isDark != '' ? '  Toggle Light Mode' : '  Toggle Dark Mode'}}</button>
      </section>


      <section id="navbarsection">
        <router-link class="btn" id="navbutton" v-bind:to="{ name: 'home' }" ><i  class="fa fa-home"></i>  Home</router-link>

        <h2 id="brandtitle"> TEgram </h2>

      <router-link class="btn" id="navbutton" v-show="isNotInLogin()" v-bind:to="{ name: 'logout' }"><i class="icon-user" ></i>{{$store.state.token != '' ? '  Logout' : '  Login'}}</router-link>
      </section>

      <section id="favorites">
        <router-link class="btn button" id="navbutton" v-show="isNotInLogin()" v-bind:to="{ name: 'favorites' }"><i class="icon-user" ></i>{{$store.state.token != '' ? '  View Favorites' : '  View Favorites'}}</router-link>
      </section>

      <section id="makePost">   
          <router-link class="btn" id="navbutton" v-show="isNotInLogin()" v-bind:to="{ name: 'createpost' }"><i class="icon-user" ></i>{{$store.state.token != '' ? '  Create Post' : ' Create Post'}}</router-link>    
      </section>   
      
    </div>
</template>
<script>
export default {
  computed: {
    checkLogo() {
      if(this.$store.state.isDark){
             return require ("../assets/TEgram.png");
     } else {
       return require ("../assets/TEgram-logo.png");

    }
    }
  },
  methods: {
    isNotInLogin() {
      return this.$router.history.current["path"] !== "/login";
    },
    toggleDark() {
        this.$store.commit('TOGGLE_DARK_MODE');
    },

  }
}

</script>

<style scoped>

#navbarsection{
  margin-left: 18%;
}
#favorites{
display: flex;
align-items: center;
justify-content: center;
margin-right: 2%;
width: 18%;;
}

#brandtitle{
  font-family:'Open Sans', sans-serif;
  font-size: 40px;
  margin-left: 10px;
  margin-right: 10px;
  color: rgb(189, 78, 78);
}
.lightmode #navbar {
  display: flex;
    border-bottom: 2px solid rgb(0, 0, 0);
  justify-content: space-between;
    /* width: 100vw; */
    /* height: auto; */
  background-color:pink;
}

.lightmode body{
  margin: 0px;
}
.lightmode #navbutton{
  border: 2px solid black;
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
  border: 2px solid black;
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
#makePost{
display: flex;
align-items: center;
justify-content: center;
margin-right: 2%;
width: 16%;
}
.lightmode #darkmodebutton{
display: flex;
align-items: center;
justify-content: center;
margin-left: 2%;
width: 10%;
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
  background-image: linear-gradient(to right, rgb(53, 53, 53) ,rgb(85, 85, 85),rgb(53, 53, 53) );
  border-bottom: 2px solid rgb(0, 0, 0);
}
.darkmode #navbutton{
    border: 2px solid black;
  width: auto;
}
.darkmode button{
   display: inline-block;
  justify-content: center;
  align-items: center;
  font-family:'Open Sans', sans-serif;
  background-color: rgb(255, 164, 79);
  border: none; /* Remove borders */
  color: white; /* White text */
  padding: 10px; /* Some padding */
  margin: 5px;
  font-size: 16px; /* Set a font size */
  cursor: pointer; /* Mouse pointer on hover */
  text-decoration: none;
  border-radius: 25px;
  border: 2px solid black;
  width: auto;
  height: auto;
}
.darkmode button:hover {
  top: 3px;
  background-color:#ff9419;
  box-shadow: none;
}

.darkmode .btn{
  display: inline-block;
  justify-content: center;
  align-items: center;
  font-family:'Open Sans', sans-serif;
  background-color: rgb(255, 164, 79);
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
  background-color:#ff9419;
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
width: 10%;
}
.darkmode #navbarsection{
  display: flex;
  align-items: center;
justify-content: center;
  width: 100%;
}
</style>



