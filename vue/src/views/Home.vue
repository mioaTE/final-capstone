<template>
  <div :class="isDark ? 'darkmode' : 'home'">
    <carousel id="3dCarousel" />
    <side-bar class="sidebar"/>
    <button id="toggle-dark" @click="toggleDark()">Toggle Dark Mode</button>
  </div>
  
</template>
<script>
import Carousel from '../components/Carousel.vue';
import SideBar from '../components/SideBar';
export default {
  name: "home",
  data() {
    return {
      isDark: true,
    }
  },
  components: {
    Carousel,
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
  grid-template-columns: 1fr 5fr;
  grid-template-areas:
    "sidebar content"
    "sidebar content"
}
#3dCarousel {
  grid-area: content;
  display: flex;
  justify-content: flex-start;
  height: auto;
  justify-self: center;
}
#banner {
  grid-area: header;
  height: auto;
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
  justify-content: center;
  align-items: center;
  background-color: rgb(255, 158, 158);
  width: 100%;
  margin-right: auto;
  margin-left: auto;
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

   


   

  