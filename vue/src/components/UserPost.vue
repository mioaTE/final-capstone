<template>
  <div id="Post" :class="$store.state.isDark ? 'darkmode' : 'lightmode'">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
      <div v-for="post in postList" v-bind:key="post.postId">
      <section id="PostHeader" >
      <img id="ProfilePicture" v-bind:src="post.urlImage" />
      <router-link id="Username" v-bind:to="{name: 'user-detail', params: {id: user.id} }">
        {{ user.username }}
        </router-link>
      </section>
      <section id="UserPicture">
      <img id="Picture"  v-bind:src="post.urlImage"/>
      </section>
      <section id="InteractionPanel">

      </section>
      </div>
    </div>
</template>

<script>
// import catPicService from '../services/CatPictureServices.js';
import postService from "../services/PostService.js";
export default {
    name: "user-post",
    props: ['user'],
    methods: {
      viewPostDetails(){
        this.$router.push(`/user`);
      }
    },
    data() {
        return {
        postList: [],
        }
    },
    created() {
        postService.listPosts().then((response) => {
          this.postList = response.data;
          console.log(this.postList);
        })
    },
    likePost() {
      console.log(this.post.images);
      postService
        .addLiked(this.post.postId)
        .then((response) => {
          if (response.status == 201) {
            this.$store.commit("TOGGLE_LIKE", this.post);
          }
        })
        .catch((error) => {
          console.log(error.response);
        });
    },
    unlikePost() {
      postService
        .removeLiked(this.post.postId)
        .then()
        .catch((error) => {
          console.log(error.response);
        });
      this.$store.commit("TOGGLE_LIKE", this.post);
    },
    favoritePost() {
      postService
        .addFavorite(this.post.postId)
        .then()
        .catch((error) => {
          console.log(error.response);
        });

      this.$store.commit("TOGGLE_FAVORITE", this.post);
    },
    unfavoritePost() {
      postService
        .removeFavorite(this.post.postId)
        .then()
        .catch((error) => {
          console.log(error.response);
        });
      this.$store.commit("TOGGLE_FAVORITE", this.post);
    },
};
</script>

<style>
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
.lightmode #ProfilePicture{
  display: inline-block;
  height: 15px;
  width: 15px;
  border-radius: 10%;
  margin-left: 5%;
  border: 1px solid grey;
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
background-image: linear-gradient(to right, rgb(255, 191, 71),rgb(82, 82, 82) );
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
  height: 10%;
background-image: linear-gradient(to right, rgb(255, 191, 71),rgb(82, 82, 82) );
}
</style>