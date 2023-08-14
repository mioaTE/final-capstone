<template>
 <div>
     <h1>This is UserDetail</h1>
     <h2>User ID: {{ user.id }}</h2>
     <h2>User name: {{ user.profileName}}</h2>
     <div v-for="post in posts" v-bind:key="post.postId">
         <h3>{{ post.postId }}</h3>
      
        <img class="image" v-bind:src="post.urlImage" />
         </div>
 </div>
</template>

<script>
import postService from '../services/PostService';
export default {
    name: 'user-detail',
    data() {
        return {
            user: { },
            posts: []
        }
    },    
    computed: {
        users() {
            return this.$store.state.users;
        },
        currentUser(){
            return postService.getUser(this.$route.params.id)
        }
    },
    created() {
      const activeUserId = this.$route.params.id;
      this.$store.commit('SET_ACTIVE_USER', activeUserId);
        postService.getUser(this.$route.params.id).then((response) => {
          this.user = response.data;
          console.log(this.user);
        })
        postService.getPostsByUser(this.$route.params.id).then((response) => {
          this.posts = response.data;
          console.log(this.posts);
        })
    },
    
}
</script>

<style>
#navbar{
    grid-area: navbar;
    height: auto;
    background: rgb(255, 154, 171);
}
.profile-header {
    display: flex;
    width: 100%;
    flex-direction: row;
    /* background-color: white; */
    /* background-color: #616161; */
    background: rgb(255, 154, 171);
    align-items: center;
    font-family: 'Open Sans', sans-serif;
    box-shadow: 0px 2px 10px rgb(184, 184, 184);
    justify-content: space-between;
    height: 100px;
}
.settings-icon {
    margin-top: 15px;
    margin-right: 10px;
    max-height: 30px;
    max-width: 30px;
    border-radius: 100%;
    background: rgb(255, 154, 171);
    background-clip: border-box;
}
.lightmode {
    background-image: radial-gradient(rgb(255, 225, 230), rgb(255, 171, 185)) ;
}
.darkmode {
    background-image: linear-gradient(to bottom, rgb(65, 65, 65),rgb(83, 83, 83),rgb(99, 99, 99) );
}
</style>