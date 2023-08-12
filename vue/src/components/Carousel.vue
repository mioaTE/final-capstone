<template>
    <carousel-3d>
       <div v-for="user in $store.state.users" v-bind:key="user.id">
    <slide :index="user.id">
      <div v-bind:id="user.id">
      <user-post v-bind:user="user"/>
      </div>
    </slide>
    </div>
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
  },
  methods: {
    getUserById(id) {
      this.$store.state.users.forEach(user => {
        if(user.id === id){
          return user;
        }
      });
    }
  },
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