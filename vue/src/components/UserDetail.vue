<template>
 <div>
     <h1>This is UserDetail</h1>
     <h2>User ID: {{ user.id }}</h2>
     <h2>User name: {{ user.username}}</h2>
     <post-display
        v-for="post in user.posts"
        v-bind:key="post.postId"
        v-bind:hedgehog="post"
         />
 </div>
</template>

<script>
import PostDisplay from './PostDisplay.vue';
import postService from '../services/PostService';
export default {
    name: 'user-detail',
    components: {
        PostDisplay,
    
    },
    data() {
        return {
            user: { }
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
    },
    
}
</script>

<style>

</style>