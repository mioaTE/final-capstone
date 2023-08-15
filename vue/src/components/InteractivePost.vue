<template>
  <div id="PostView">
         {{ user.profileName }}
      <img  v-bind:src="postDetails.urlImage" />
         {{ postDetails.postDescription }}
  </div>
</template>

<script>
// import PostService from '../services/PostService'

export default {
    name: "interactPost",
    props: ['postDetails'],
    data() {
        return {
        user: {}
          
        }
    },
    // created() {
    //     PostService.getUserById(this.postDetails.userId).then((response) => {
    //       this.user = response.data;
    //     })
    // }
}
</script>

<style>

</style>