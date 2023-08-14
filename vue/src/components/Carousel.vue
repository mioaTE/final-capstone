<template>
    <carousel-3d >
       <div v-for="post in this.$store.state.postList" v-bind:key="post.postId">
    <slide :index="post.postId">
      <div v-bind:id="post.postId">
      <user-post v-if="rendered" v-bind:post="post"/>
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
        postList: [],
        rendered: false
        }
    },
   created() {
        PostService.listPosts().then((response) => {
          this.postList = response.data;
          this.postList.unshift({
            postId: 0,
            userId: 0,
            postDescription: "",
            urlImg: "http://res.cloudinary.com/dmxisezmv/image/upload/v1691883695/ku7zzwqczzgzm5it3wyv.png",

          })
          this.rendered = true;
          console.log(this.postList);
           this.$store.commit("UPDATE_POST_LIST", this.postList);
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