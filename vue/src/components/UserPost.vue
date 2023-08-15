<template>
  <div id="Post" :class="$store.state.isDark ? 'darkmode' : 'lightmode'">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
        <button id="likebutton" v-on:click="likePost(post)" v-if="!postLiked" ><i class="fa fa-heart" style="font-size:15px;color:red"></i> Like</button> 
        <button id="likebutton" v-on:click="unlikePost(post)" v-if="postLiked" >Unlike</button>
        <button id="favoritebutton" v-on:click="favoritePost(post)" v-if="!postFavorited" >Favorite</button>
        <button id="favoritebutton" v-on:click="unFavoritePost(post)" v-if="postFavorited" >Unfavorite</button>
        <p> {{this.postLikes}} </p>
      </section>
      </div>
    </div>
</template>
<script>
// import catPicService from '../services/CatPictureServices.js';
import postService from "../services/PostService.js";
export default {
    name: "user-post",
    props: ['post'],
    
    data() {
        return {
          user: {},
          postLikes: '',
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
          removeFavorite: {userId: this.$store.state.user.id,
                      postId: ''},
          allFavorites: []
        }
    },
    updated() {
      this.postLikes = this.post.likesCount;
     
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
        postService.addLiked(this.newLike);
        postService.updatePostLikes(post);
        this.allLikes.push(this.newLike);
      },

      unlikePost(post) {
        this.removeLike = {
          userId: this.$store.state.user.id,
          postId: post.postId
        }
        postService.removeLiked(this.removeLike.userId, this.removeLike.postId);
        postService.updatePostLikes(post);
        this.allLikes = this.allLikes.filter((like) => {
          (like.userId !== this.removeLike.userId && like.postId !== this.removeLike.postId)});
      },
      

      favoritePost(post) {
        this.newFavorite = {
          userId: this.$store.state.user.id,
          postId: post.postId
        }
        postService.addFavorite(this.newFavorite).then(response => {
            if (response.status === 201) {
              console.log("favorite updated");
            } else {
              console.log("favorite did not update");
            }
        })
          this.allFavorites.push(this.newFavorite);
      },

      unFavoritePost(post) {
        this.removeFavorite = {
          userId: this.$store.state.user.id,
          postId: post.postId
        }
        postService.removeFavorite(this.removeFavorite.userId, this.removeFavorite.postId).then(response => {
            if (response.status === 202) {
              console.log("Favorite updated");
            } else {
              console.log("Favorite did not update");
            }
        });
        this.allFavorites = this.allFavorites.filter((favorite) => {
          (favorite.userId !== this.removeFavorite.userId && favorite.postId !== this.removeFavorite.postId)});
      }

    
  }
  
}
</script>
<style>
#favoritebutton{
    height: 90%;
    width: 20%;
    margin-top: 1px;
    margin-left: 54%;
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
.lightmode #InteractionPanel{
  display: flex;
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
.darkmode #InteractionPanel{
  height: 15%;
background: orange;
}

#Username{
    font-family:'Open Sans', sans-serif;
    text-decoration: none;
    font-size: 20px;
    font-weight: 15px;
}
</style>