<template>
    <carousel-3d  v-if="rendered" >
       <div v-for="post in this.$store.state.postList" v-bind:key="post.postId">
    <slide :index="post.postId">
      <div v-bind:id="post.postId">
      <user-post v-bind:post="post"/>
      </div>
    </slide>
    </div>
  </carousel-3d>
</template>
<script>
import { Carousel3d, Slide } from 'vue-carousel-3d';
import UserPost from '../components/UserPost.vue';
import PostService from '../services/PostService';

export default {
  components: {
    Carousel3d,
    Slide,
    UserPost
  },
    data() {
        return {
        rendered: false
        }
    },
   created() {
        PostService.listPosts().then((response) => {

          response.data.unshift({
            postId: 0,
            userId: 0,
            postDescription: "We hope you enjoy our app!",
            urlImage: "http://res.cloudinary.com/dmxisezmv/image/upload/v1692106263/gduezwmegin1aa0c2ey0.png",

          });
          console.log(response.data);
           this.$store.commit("UPDATE_POST_LIST", response.data);
           this.rendered = true;
        })
    },
  methods: {
    getPostById(id) {
      this.postList.forEach(post => {
        if(post.id === id){
          return post;
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
  background-image: linear-gradient(to right, #e83e8c rgb(255, 135, 155));
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