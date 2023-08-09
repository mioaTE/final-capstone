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

</style>