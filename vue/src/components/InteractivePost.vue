<template>
  <div id="PostView">
         {{ user.profileName }}
      <img  v-bind:src="postDetails.urlImage" />
         {{ postDetails.postDescription }}
  </div>
</template>

<script>
import PostService from '../services/PostService'

export default {
    name: "interactPost",
    props: ['postDetails'],
    data() {
        return {
        user: {}
          
        }
    },
    updated() {
        PostService.getUserById(this.postDetails.userId).then((response) => {
          this.user = response.data;
        })
    }
}
</script>

<style>
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