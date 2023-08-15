<template>
  <div id="favorites">
    <nav-bar />
    <div id="fav-main">
      <section id="userPost">
        <div v-for="post in favorites" v-bind:key="post.postId">
       <router-link id="post" v-bind:to="{name: 'post', params: {id: post.postId} }">
         <img class="image" v-bind:src="post.urlImage" />
       </router-link>
        </div>
    </section>
    </div>
  </div>
</template>
<script>
import postService from "../services/PostService.js";
import NavBar from "../components/NavBar.vue";
export default {
  name: "favorites",
  components: {
    NavBar
    },
  data() {
    return {
      favorites: [],
    }
  },
  created() {
    postService
      .listFavoritesByUser(this.$store.state.user.id)
      .then((response) => {
        this.favorites = response.data;
        console.log(this.favorites);
      })
      console.log(this.favorites)
      .catch((error) => {
        if (error.response.status == 404) {
          this.$router.push("/not-found");
        }
        console.log(error);
      });
  }
};
</script>
<style>
</style>