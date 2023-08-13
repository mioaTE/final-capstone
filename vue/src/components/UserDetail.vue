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

</style>