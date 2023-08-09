<template>
  <div class="home">
    <h1 id="TEGram">TEGram</h1>
    <p id="banner">Welcome to TEGram!</p>
    <carousel id="3dCarousel" />
    <side-bar class="sidebar"/>
  </div>
</template>

<script>
import Carousel from '../components/Carousel.vue';
import SideBar from '../components/SideBar'; 

export default {
  name: "home",
  components: {
    Carousel,
    SideBar
  }
};
</script>

<style>
.home {
  background-image: radial-gradient(rgb(255, 225, 230), rgb(255, 171, 185)) ;
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-columns: 1fr 5fr;
  grid-template-areas:
    "sidebar header"
    "sidebar content"
    "sidebar content "
}
#3dCarousel {
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
#app > div.home > div.carousel-3d-container{
  display: flex;
  overflow: visible;
  justify-content: center;
  align-items: center;
}
</style>