<template>
  <div id="home" :class="$store.state.isDark ? 'darkmode' : 'lightmode'">
    <nav-bar id="navbar"/>
    <display-posts />
    <!-- <carousel id="3dCarousel" /> -->
    <upload-pic />
  </div>
  
</template>
<script>
import DisplayPosts from '../components/DisplayPosts.vue';
// import Carousel from '../components/Carousel.vue';
import NavBar from '../components/NavBar.vue';
import UploadPic from '../components/UploadPic.vue';



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
    // Carousel,
    NavBar,
    UploadPic,
    DisplayPosts,

  }
};
</script>
<style>
img {
  height: 50px;
  width: 50px;
}
.lightmode {
  background-image: radial-gradient(rgb(255, 225, 230), rgb(255, 171, 185)) ;

}
#home{
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
 background-image: linear-gradient(to top, rgb(255, 191, 71) ,rgb(99, 99, 99),rgb(82, 82, 82));
  }
</style>