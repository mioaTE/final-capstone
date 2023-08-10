<template>
  <div :class="$store.state.isDark ? 'darkmode' : 'lightmode'">
    <nav-bar id="navbar"/>
    <carousel id="3dCarousel" />
  </div>
  
</template>
<script>
import Carousel from '../components/Carousel.vue';
import NavBar from '../components/NavBar.vue';


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
    NavBar
  }
};
</script>
<style>
.lightmode {
  background-image: radial-gradient(rgb(255, 225, 230), rgb(255, 171, 185)) ;
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas:
    "navbar"
    "content"
    "content"
    "content"
    "content"
    "content"
    "content"
    "content"
    
}

#navbar{
  grid-area: navbar;
  height: 10%;
  background: rgb(255, 154, 171);
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
  background-image: radial-gradient(rgb(68, 68, 68), rgb(255, 157, 46)) ;
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas:
    "navbar"
    "content"
    "content"
    "content"
    "content"
    "content"
    "content"
    "content"
    
  
  }
</style>