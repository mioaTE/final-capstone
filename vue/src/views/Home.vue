<template>
  <div :class="isDark ? 'darkmode' : 'home'">
    <nav-bar id="navbar"/>
    <carousel id="3dCarousel" />
    <side-bar class="sidebar"/>
  </div>
  
</template>
<script>
import Carousel from '../components/Carousel.vue';
import NavBar from '../components/NavBar.vue';
import SideBar from '../components/SideBar';

export default {
  name: "home",
  // data() {
  //   return {
  //     isDark: true,
  //   }
  // },
  props: ['isDark'],
  components: {
    Carousel,
    SideBar,
    NavBar
  }
};
</script>
<style>
.home {
  background-image: radial-gradient(rgb(255, 225, 230), rgb(255, 171, 185)) ;
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-columns: 1fr 8fr;
  grid-template-areas:
    "navbar navbar"
    "sidebar content"
  
}

#navbar{
  grid-area: navbar;
  height: 10%;
}

#\33 dCarousel > div{
  height: 50%;
}

#3dCarousel{
  height: 50%;
  text-align: center;
}
.sidebar {
  grid-area: sidebar;
  display: flex;
  justify-content: space-between;
}
#app > div.home > div.carousel-3d-container{
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: rgb(255, 158, 158);
}

  .darkmode {
  background-image: radial-gradient( rgb(17, 16, 17),rgb(54, 37, 39));
  color: orange;
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-columns: 1fr 5fr;
  grid-template-areas:
    "sidebar content"
    "sidebar content"
  }

  #toggle-dark {
    width: 100px;
    height: 50px;
  }
</style>