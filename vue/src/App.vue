
<template>
    <router-view />
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
<style>
.carousel-3d-container[data-v-07917306]{
  height: 80%;
}
body{
  margin: 0px;
}
#nav {
  display: flex;
  justify-content: space-evenly;
    /* width: 100vw; */
    /* height: auto; */
  background-color:pink;
  height: 10%;
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
#app {
  height: 100%;
  width: 100%;
}
#TEgram-logo{
  height: 150px;
}
.carousel-3d-container[data-v-07917306]{
  border-radius: 10px 10px 10px 10px;
  height: 300px;
}
</style>