<template>
  <div id="favorites" :class="this.$store.state.isDark ? 'darkmode' : 'lightmode'">

    <nav-bar />

    <div id="fav-main">

      <section id="favoritesHeader">

        <h1>These Are Your Favorite Post</h1>

       </section> 



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
      user: {}
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

              postService.getUser(this.$route.params.id).then((response) => {
          this.user = response.data;
        })
  }
};
</script>

<style scoped>
#favoritesHeader {
    display: flex;
    width: 100%;
    flex-direction: row;
    /* background-color: white; */
    /* background-color: #616161; */
    align-items: center;
    font-family: 'Open Sans', sans-serif;
    box-shadow: 0px 2px 10px rgb(184, 184, 184);
    justify-content: center;
    height: 100px;
}

.lightmode #favoritesHeader{
    background: rgb(255, 154, 171);
}

.darkmode #favoritesHeader{
    background: rgb(110, 110, 110);
}

#favorites{
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 1fr 3fr;
  grid-template-areas:
    "navbar"
}

#navbar{
  grid-area: navbar;
  display: flex;
  justify-content: center;
  align-items: center;
}



</style>