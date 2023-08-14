<template>
  <div id="home" :class="this.$store.state.isDark ? 'darkmode' : 'lightmode'">
    <nav-bar id="navbar"/>
    <section id="carousel">
    <carousel id="3dCarousel" />
    </section>
  </div>
  
</template>
<script>
// import DisplayPosts from '../components/DisplayPosts.vue';
import Carousel from '../components/Carousel.vue';
import NavBar from '../components/NavBar.vue';



export default {
  sameSite:'none', 
    secure:true,
    httpOnly:true,
  name: "home",
  // data() {
  //   return {
  //     isDark: true,
  //   }
  // },
  props: ['isDark'],
  components: {
    Carousel,
    NavBar,

  }
};
</script>
<style>


.lightmode {
  background-image: radial-gradient(rgb(255, 225, 230), rgb(255, 171, 185)) ;

}
#home{
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 1fr 3fr;
  grid-template-areas:
    "navbar"
    "post"
}

#navbar{
  grid-area: navbar;
  height: auto;
  background: rgb(255, 154, 171);
}

#\33 dCarousel > div{
  height: 50%;
}
#carousel{
  grid-area: post;
  display: flex;
  justify-content: center;
  align-items: center;
  height: auto;
}

#3dCarousel{
  height: 100%;
  text-align: center;
}

#app > div.home > div.carousel-3d-container{
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: rgb(255, 158, 158);
}

  .darkmode {
 background-image: linear-gradient(to bottom, rgb(65, 65, 65),rgb(83, 83, 83),rgb(99, 99, 99) );
  }
</style>