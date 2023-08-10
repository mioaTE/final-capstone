<template>
    <carousel-3d>
    <slide :index="0">
      <user-post />
    </slide>
    <slide :index="1">
      <user-post />
    </slide>
    <slide :index="2">
      <user-post />
    </slide>
    <slide :index="3">
      <user-post />
    </slide>
    <slide :index="4">
      <user-post />
    </slide>
    <slide :index="5">
      <user-post />
    </slide>
    <slide :index="6">
      <user-post />
    </slide>
    <slide :index="7">
      <user-post />
    </slide>
    <slide :index="8">
      <user-post />
    </slide>

  </carousel-3d>
</template>

<script>
import { Carousel3d, Slide } from 'vue-carousel-3d';
import UserPost from '../components/UserPost.vue';

export default {
  components: {
    Carousel3d,
    Slide,
    UserPost
  }
};
</script>

<style>
#carousel-3d-slide{
  height: auto;
  border: 1px solid black;
  background-image: linear-gradient(to right, rgb(255, 110, 134), rgb(255, 135, 155));
}
#\33 dCarousel > div{
    padding: 0px;
}
.carousel-3d-container[data-v-07917306]{
  height: 300px;
}
#3dCarousel {
  grid-area: content;
  display: flex;
  justify-content: flex-start;
  justify-self: center;
}
</style>