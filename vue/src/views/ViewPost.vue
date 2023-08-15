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
    
            <label id="label" for="comment">Submit Comment</label>

            <textarea id="comment" name="comment" type="text" v-model="newComment.comment"/>

            <button class="button" type="submit">Comment</button>
        
        </form>

      </section>
      
      <section id="userComments">

          <div v-for="comment in this.$store.state.commentList" v-bind:key="comment.commentId">
              </div>

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

<style scoped>
#postView{
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  grid-template-areas:
    "navbar"
    "post"
    "comment"
}

#label{
    color: black;
}
textarea{

   border: 1px solid #b5bcc7;
    height: 50px;
    width: 250px;
    background-color: #F7FCFF;
    margin-top: 1px;
    margin-left: 4px;
    margin-right: 1px;
    padding: 20px;
    overflow: hidden;
}

form{
display: flex;
justify-content: center;
align-items: center;
flex-direction: column;
}

#comment{
    display: flex;
justify-content: center;
align-items: center;
flex-direction: column;
grid-area: comment;
margin: 25px;
border-radius: 20px;
}

.lightmode #comment{
border: 2px solid gold;
background: rgb(255, 150, 167);
}

.darkmode #comment{
border: 2px solid black;
background: grey;
}
#navbar{
    grid-area: navbar;
}
#usersPost{
    grid-area: post;
}
</style>