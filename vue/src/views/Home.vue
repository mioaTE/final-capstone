<template>
  <div class="home">
    <!-- <img src="../assets/TEgram-logo.png" id="TEGram" /> -->
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
  background-color: pink;
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