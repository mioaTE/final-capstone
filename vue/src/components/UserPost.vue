<template>
  <div id="Post" :class="$store.state.isDark ? 'darkmode' : 'lightmode'">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
      <div v-bind:key="post.postId">
      <section id="PostHeader" >
      <router-link id="Username" v-bind:to="{name: 'user-detail', params: {id: post.userId} }">
        {{ user.profileName }}
        </router-link>
      </section>
      <section id="UserPicture">

      <img id="Picture"  v-bind:src="post.urlImage"/>

      </section>
      <section id="InteractionPanel">
        <button id="likebutton" v-on:click="likePost(post)" v-if="!postLiked" >Like</button> 
        <button id="likebutton" v-on:click="unlikePost(post)" v-if="postLiked" >Unlike</button>
         <p> {{currentLikes}} </p>
        <button id="favoritebutton" v-on:click="favoritePost(post)" v-if="!postFavorited" >Favorite</button>


        <!-- add  unfavoritebutton -->
      </section>
      </div>
    </div>
</template>
<script>
import postService from "../services/PostService.js";
export default {
    name: "user-post",
    props: ['post'],
    
    data() {
        return {
          user: {},
          currentPost: {},
          postList: [],
          newLike: {userId: this.$store.state.user.id,
                    postId: '',
          },
          removeLike: {userId: this.$store.state.user.id,
                      postId: ''},
          allLikes: [],

          newFavorite: {userId: this.$store.state.user.id,
                    postId: '',
          },
          allFavorites: [],
        }
    },
    mounted(){
      postService.getPostById(this.post.postId).then(response => {
        this.currentPost = response.data;
      })
    },
    created() {
      if(this.post.userId != 0) {
       postService.getUser(this.post.userId).then((response) => {
          this.user = response.data;
        })
      }
       
       postService.listPosts().then((response) => {
         this.postList = response.data;
       })

        postService.getAllLikes().then((response) => {
          this.allLikes = response.data;
        })

    },
    computed: {
      postLiked() {
        if(this.allLikes.some((like)=> like.postId == this.post.postId && like.userId == this.$store.state.user.id)) {
          return true;
        } else {
          return false;
        }
      },
      postFavorited() {
        if(this.allFavorites.some((favorite)=> favorite.postId == this.post.postId && favorite.userId == this.$store.state.user.id)) {
          return true;
        } else {
          return false;
        }
        },
        currentLikes() {
          return this.post.likesCount
        }

    },
    methods: {
      
      viewPostDetails(){
        this.$router.push(`/user`);
      },

      likePost(post) {
        this.newLike = {
          userId: this.$store.state.user.id,
          postId: post.postId
        }
        postService.addLiked(this.newLike).then(response => {
              if (response.status === 201) {
                

              postService.updatePostLikes(post);
              
              this.allLikes.push(this.newLike);             
              }
            }) ;
        
        
      },

      unlikePost(post) {
        this.removeLike = {
          userId: this.$store.state.user.id,
          postId: post.postId
        }
        postService.removeLiked(this.removeLike.userId, this.removeLike.postId).then(response => {
          if (response.status != 500) {
             postService.updatePostLikes(post);
              this.allLikes = this.allLikes.filter((like) => {
                (like.userId !== this.removeLike.userId && like.postId !== this.removeLike.postId)});
          }
            
    
          
        });
        
        
        
      },
      

      favoritePost(post) {
        this.newFavorite = {
          userId: this.$store.state.user.id,
          postId: post.postId
        }
        postService.addFavorite(this.newFavorite).then(response => {
            if (response.status === 200) {
              console.log("favorite updated");
            } else {
              console.log("favorite did not update");
            }
        })
          this.allFavorites.push(this.newFavorite);
      },
    
  }
  
}
</script>
<style>
#favoritebutton{
    height: 90%;
    width: 20%;
    margin-top: 1px;
    margin-left: 50%;
    margin-right: 2%;
    padding: 0px;
}
  #likebutton{
    height: 90%;
    width: 20%;
    margin-top: 1px;
    margin-left: 2%;
    padding: 0px;
  }
#Username{
text-decoration: none;
  font-family:'Open Sans', sans-serif;
  font-size: 3em;
}
.lightmode #carousel div{
    height: 100%;
  width: 100%;
}
#Post{
  height: 100%;
  width: 100%;
}
h3{
  font-family:'Open Sans', sans-serif;
}
h4{
  height: auto;
  margin: 0px;
  margin-left: 5%;
  font-family:'Open Sans', sans-serif;
}
img {
    height: 100%;
    width: 200px;
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
#InteractionPanel p{
  display: inline-block;
  margin: 0px;
}
.lightmode #InteractionPanel{
  display: flex;
  height: auto;
    justify-content: center;
  align-items: center;
   background-image: linear-gradient(to right, rgb(255, 110, 134), rgb(255, 135, 155));
}

.darkmode #InteractionPanel{
    justify-content: flex-start;
  align-items: center;
  display: flex;
  height: auto;
background: orange;
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
.darkmode #ProfilePicture{
  display: inline-block;
  height: 15px;
  width: 15px;
  border-radius: 10%;
  margin-left: 5%;
  border: 1px solid grey;
}
.darkmode #Username{
  display: inline-block;
  font-size: 15px;
  padding-left: 5%;
}


#Username{
    font-family:'Open Sans', sans-serif;
    text-decoration: none;
    font-size: 20px;
    font-weight: 15px;
}
</style>