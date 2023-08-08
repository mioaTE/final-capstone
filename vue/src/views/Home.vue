<template>
  <div class="home">
    <h1 id="TEGram">TEGram</h1>
    <p id="banner">Welcome to TEGram!</p>
    <user-post />
    <side-bar class="sidebar"/>
  </div>
</template>

<script>
import UserPost from '../components/UserPost';
import SideBar from '../components/SideBar'; 
export default {
  name: "home",
  components: {
    UserPost,
    SideBar
  }
};
</script>

<style>
.home {
  background-color: pink;
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas:
    "sidebar header header header"
    "sidebar content content content"
    "sidebar content content content"
}
user-post {
  grid-area: content;
}
#TEGram {
  display: flex;
  justify-content: center;
  grid-area: header;
  font-size: 50px;
  font-weight: 300;
  font-family: 'Open Sans', sans-serif;
  color: gold;
  padding-top: 10px;
  margin-bottom: 10px;
}
#banner {
  grid-area: header;
  font-family: 'Open Sans', sans-serif;
  color: gold;
  text-align: center;
}
.sidebar {
  grid-area: sidebar;
  display: flex;
  justify-content: space-between;
}
</style>