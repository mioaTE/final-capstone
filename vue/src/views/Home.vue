<template>
  <div class="home">
    <h1>TEGram</h1>
    <user-post />
    <p>Welcome to TEGram!</p>
  </div>
</template>

<script>
import UserPost from '../components/UserPost'; 
export default {
  name: "home",
  components: {
    UserPost
  }
};
</script>

<style>
#home {
  display: flex;
  background-color: pink;
  height: 100vh;
  width: 100%;
}
h1 {
  font-size: 50px;
  font-weight: 300;
  font-family: 'Open Sans', sans-serif;
  color: gold;
  padding-top: 10px;
  margin-bottom: 10px;
}
p {
  font-family: 'Open Sans', sans-serif;
  color: gold;
  text-align: center;
}
</style>