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

  #likebutton{
    height: 90%;
    width: 20%;
    margin-top: 1px;
    margin-left: 2%;
    padding: 0px;
  }

  .lightmode button{
   display: inline-block;
  width: 5%;
  height: 25px;
  justify-content: center;
  align-items: center;
  font-family:'Open Sans', sans-serif;
  background-color: rgb(252, 142, 160);
  border: none; /* Remove borders */
  color: white; /* White text */
  padding: 10px; /* Some padding */
  margin: 5px;
  font-size: 16px; /* Set a font size */
  cursor: pointer; /* Mouse pointer on hover */
  border: 2px solid black;
  border-radius: 25px;
  width: auto;
  height: auto;
}
.lightmode button:hover {
  top: 3px;
  background-color:#e83e8c;
  -webkit-box-shadow: none;
  -moz-box-shadow: none;
  box-shadow: none;
}

.lightmode .btn{
  display: inline-block;
  width: 5%;
  height: 25px;
  justify-content: center;
  align-items: center;
  font-family:'Open Sans', sans-serif;
  background-color: rgb(252, 142, 160);
  border: none; /* Remove borders */
  color: white; /* White text */
  padding: 10px; /* Some padding */
  margin: 5px;
  font-size: 16px; /* Set a font size */
  cursor: pointer; /* Mouse pointer on hover */
  text-decoration: none;
  border-radius: 25px;
}
.lightmode .btn:hover {
  top: 3px;
  background-color:#e83e8c;
  -webkit-box-shadow: none;
  -moz-box-shadow: none;
  box-shadow: none;
}
.darkmode button{
   display: inline-block;
  justify-content: center;
  align-items: center;
  font-family:'Open Sans', sans-serif;
  background-color: rgb(255, 164, 79);
  border: none; /* Remove borders */
  color: white; /* White text */
  padding: 10px; /* Some padding */
  margin: 5px;
  font-size: 16px; /* Set a font size */
  cursor: pointer; /* Mouse pointer on hover */
  text-decoration: none;
  border-radius: 25px;
  border: 2px solid black;
  width: auto;
  height: auto;
}
.darkmode button:hover {
  top: 3px;
  background-color:#ff9419;
  box-shadow: none;
}

.darkmode .btn{
  display: inline-block;
  justify-content: center;
  align-items: center;
  font-family:'Open Sans', sans-serif;
  background-color: rgb(255, 164, 79);
  border: none; /* Remove borders */
  color: white; /* White text */
  padding: 10px; /* Some padding */
  margin: 5px;
  font-size: 16px; /* Set a font size */
  cursor: pointer; /* Mouse pointer on hover */
  text-decoration: none;
  border-radius: 25px;
}
.darkmode .btn:hover {
  top: 3px;
  background-color:#ff9419;
  box-shadow: none;
}
</style>