<template>
<div>
  <cloud-post v-for="post in postList" v-bind:key="post.user" v-bind:post="post"/>
  </div>
</template>

<script>
import CloudPost from './CloudPost.vue'
export default {
    sameSite:'none', 
    secure:true,
    httpOnly:true,
  components: { CloudPost },
  computed: {
      postList() {
        const posts = this.$store.state.posts;
        return posts;
      }
  }
}
</script>

<style>

</style>