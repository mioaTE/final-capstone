<template>


    <div id="postView" :class="this.$store.state.isDark ? 'darkmode' : 'lightmode'">


      <section id="navbarSection"> 

            <nav-bar id="navbar"/>

      </section>


      <section id="usersPost">
          
        <interactive-post v-bind:postDetails="post" />

      </section>   

      <section id ="comment">
        <form v-on:submit.prevent="submitComment">
    
            <label for="comment">Submit Comment</label>

            <textarea id="comment" name="comment" type="text" v-model="newComment.comment"/>

            <button class="button" type="submit">Comment</button>
        
        </form>

      </section>


    </div>


</template>

<script>

import NavBar from '../components/NavBar.vue';
import PostService from '../services/PostService';
import InteractivePost from '../components/InteractivePost.vue';


export default {
    name: "view-post",

    data() {
        return {
            post: {},
            newComment: {
                    userId: this.$store.state.user.id,
                    postId: this.$route.params.id,
                    comment: ''
                }
        }
    },
    created() {
        PostService.getPost(this.$route.params.id).then((response) => {
          this.post = response.data;

        })
    },
    components: {
        NavBar,
        InteractivePost
    },
    methods: {
        submitComment() {
          this.newComment = {
              userId: this.$store.state.user.id,
              postId: this.$route.params.id,
              comment: this.newComment.comment,
          }
          PostService.submitComment(this.newComment).then(response => {
              if (response.status === 201) {
              this.$router.push('/');
            }
          })
          this.newComment = {
            userId: this.$store.state.user.id,
            postId: this.$route.params.id, 
            comment: ''}
      },
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
.lightmode #UserPicture{
  height: 75%;
  width: 100%;
}
.lightmode #PostHeader{
  display: flex;
  justify-content: flex-start;
  align-items: center;
  height: 15%;
  background-image: linear-gradient(to right, rgb(255, 110, 134), rgb(255, 135, 155));
}
.lightmode #Username{
  display: inline-block;
  font-size: 15px;
  padding-left: 5%;
}
.lightmode #InteractionPanel{
  height: 10%;
  background-image: linear-gradient(to right, rgb(255, 110, 134), rgb(255, 135, 155));
}
.darkmode #carousel div{
  height: 100%;
  width: 100%;
}
.darkmode #UserPicture{
  height: 75%;
  width: 100%;
}
.darkmode #PostHeader{
  display: flex;
  justify-content: flex-start;
  align-items: center;
  height: 15%;
  background: orange;
}
.darkmode #Username{
  display: inline-block;
  font-size: 15px;
  padding-left: 5%;
}
.darkmode #InteractionPanel{
  height: 10%;
  background: orange;
}
</style>