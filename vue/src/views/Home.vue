<template>
<span :class="isDark ? 'darkmode' : 'home'">
  <div>
    <h1 id="TEGram">TEGram</h1>
    <p id="banner">Welcome to TEGram!</p>
    <button @click="toggleDark()">Toggle Dark Mode</button>
    <user-post />
    <side-bar class="sidebar"/>
  </div>
  </span>
</template>

<script>
import UserPost from '../components/UserPost';
import SideBar from '../components/SideBar';
export default {
  data() {
    return {
      isDark: true,
    }
  },
   
  name: "home",
  components: {
    UserPost,
    SideBar
  },
  methods: {
    toggleDark() {
      return this.isDark = ! this.isDark;
    }
  }
};
</script>

<style>
.home {
  background-image: radial-gradient(rgb(255, 225, 230), rgb(255, 171, 185)) ;
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
  color: goldenrod;
  padding-top: 10px;
  margin-bottom: 10px;
}
#banner {
  grid-area: header;
  font-family: 'Open Sans', sans-serif;
  color: goldenrod;
  text-align: center;
}
.sidebar {
  grid-area: sidebar;
  display: flex;
  justify-content: space-between;
}

.darkmode {
  background-image: radial-gradient( rgb(17, 16, 17),rgb(54, 37, 39));
  color: orange;
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas:
    "sidebar header header header"
    "sidebar content content content"
    "sidebar content content content"
}
</style>