<template>


    <div id="postView" :class="this.$store.state.isDark ? 'darkmode' : 'lightmode'">


      <section id="navbarSection"> 

            <nav-bar id="navbar"/>

      </section>


      <section id="usersPost">
          <img v-bind:src="post.urlImage" />

      </section>   


    </div>


</template>

<script>

import NavBar from '../components/NavBar.vue';
import PostService from '../services/PostService';


export default {
    name: "view-post",
    data() {
        return {
        user: {},
          post: {}
        }
    },
    created() {
        PostService.getPost(this.$route.params.id).then((response) => {
          this.post = response.data;

        })
        PostService.getUser(this.post.postId).then((response) => {
            this.user = response.data;
        })
    },
    components: {
        NavBar
    }
}
</script>

<style>
#postView{
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
}

#usersPost{
    grid-area: post;
}
</style>