<template>
  <div v-bind:key="hedgehog.postId">
      <h3>{{ hedgehog.postId }}</h3>
      
      <img class="image" v-bind:src="post.postImage" />
  </div>
</template>

<script>
export default {
    
    name: "post-display",
    props:["hedgehog"],
  
     computed: {
         postImage() {
             return this.$store.state.users.posts.find((post) =>{
                 return post.postImage == this.$store.state.users.activePost;
             })
         }
     },
    //  created() {
    //      const activePostID = this.$route.params.id;
    //  }
    // }
}
</script>

<style>

</style>