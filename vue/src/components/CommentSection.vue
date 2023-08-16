<template>
        <div id="commentSection">


        <div v-for="comment in this.$store.state.postComments" v-bind:key="comment.commentId" id="comment">
            
            

            {{comment.username}}: {{comment.comment}}



        </div> 

        </div>
    

</template>

<script>

import PostService from '../services/PostService';

export default {
    name: "comment-section",
    data() {
        return {
             postComments: []
        }
    },
    created() {
         PostService.getCommentByPostId(this.$route.params.id).then((response) => {
          this.postComments = response.data;
          this.$store.commit("UPDATE_POST_COMMENTS", response.data);
        })
        },
    updated(){
         PostService.getCommentByPostId(this.$route.params.id).then((response) => {
          this.postComments = response.data;
          this.$store.commit("UPDATE_POST_COMMENTS", response.data);
        })
    }
    }
</script>

<style scoped>
#commentSection{
    display: flex;
    justify-content: flex-start;
    align-items: center;
    flex-direction: column;
    width: 100%;
    height: 100%;
    margin: 5px;
      flex-grow: 1;
}

#comment{
    display: flex;
    justify-content: flex-start;
    align-items: center;
    margin: 2px;
    width: 95%;
    height: 10%;
    border-radius: 5px;
    padding-left: 5px;
    padding-right: 5px;
}
.lightmode #comment{
  background-color: rgb(255, 202, 211);
  border: 2px solid gold;
}

.darkmode #comment{
        background: rgb(182, 182, 182);
          border: 2px solid black;
}
</style>