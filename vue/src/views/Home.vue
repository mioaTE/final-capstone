<template>

  <div class="home">
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
  grid-template-columns: 1fr 8fr;
  grid-template-areas:
    "sidebar content"
  
}

#\33 dCarousel > div{
  height: 50%;
}
#3dCarousel{
  height: 50%;
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
  width: 100%;
}


</style>