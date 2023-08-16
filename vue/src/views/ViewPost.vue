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

            <textarea id="commenttext" name="comment" type="text" v-model="newComment.comment"/>

            <button class="button" type="submit">Comment</button>
        
        </form>

      </section>
      
      <section id="userComments">

      <comment-section />

      </section>

      
      
     
    </div>


</template>

<script>

import NavBar from '../components/NavBar.vue';
import PostService from '../services/PostService';
import InteractivePost from '../components/InteractivePost.vue';
import CommentSection from '../components/CommentSection.vue';


export default {
    name: "view-post",

    data() {
        return {
            post: {},
            newComment: {
                    userId: this.$store.state.user.id,
                    postId: this.$route.params.id,
                    comment: '',
                    username: this.$store.state.user.profileName
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
        InteractivePost,
        CommentSection
    },
        methods: {
        submitComment() {
          this.newComment = {
              userId: this.$store.state.user.id,
              postId: this.$route.params.id,
              comment: this.newComment.comment,
              username: this.$store.state.user.profileName
          }
          PostService.submitComment(this.newComment).then(response => {
              if (response.status === 201) {
              this.$router.push('/');
            }
          })
          this.newComment = {
            userId: this.$store.state.user.id,
            postId: this.$route.params.id, 
            comment: '',
            username: this.$store.state.user.profileName}
      },
    }
}
</script>

<style scoped>
#navbarSection{
    grid-area: navbar;
}
#postView{
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 1fr 1fr 3fr;
  grid-template-areas:
    "navbar navbar"
    "post postcomment"
    "commentsection commentsection"
}

#userComments{
  grid-area: commentsection;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  margin: 25px;
  margin-top: 0px;
  border-radius: 25px;
  height: auto;

}
.lightmode #commenttext{
border: 2px solid gold;
background: rgb(255, 185, 196);
  border-radius: 20px;
  margin: 25px;
}

.darkmode #commenttext{
  border: 2px solid black;
background: rgb(173, 173, 173);
  border-radius: 20px;
  margin: 25px;
}

.lightmode #userComments{
border: 2px solid gold;
background: rgb(255, 150, 167);
}

.darkmode #userComments{
  border: 2px solid black;
background: grey;
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
  grid-area: postcomment;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  border-radius: 20px;
  margin: 25px;
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

}
#usersPost{
    grid-area: post;
}
</style>