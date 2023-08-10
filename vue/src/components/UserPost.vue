<template>
  <div id="Post" >
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
    <div v-for="user in $store.state.users" v-bind:key="user.id">
      <section id="PostHeader" >
      <img id="ProfilePicture" v-bind:src="catPicURL" />
      <router-link id="Username" v-bind:to="{name: 'user-detail', params: {id: user.id} }">
        {{ user.username }}
        </router-link>
      </section>
      <section id="UserPicture">
      <img id="Picture"  v-bind:src="catPicURL"/>
      </section>
      <section id="InteractionPanel">
        <h4>Likes</h4>
  </section>
    </div>
  
  </div>
</template>

<script>
import catPicService from '../services/CatPictureServices.js';
export default {
    name: "user-post",
    methods: {
      viewPostDetails(){
        this.$router.push(`/user`);
      }
    },
    data() {
        return {
        catPicURL: ''
        }
    },
    created() {
        catPicService.getCatPic().then((response) => {
        let data = response.data[0];
        this.catPicURL = data.url;
    })
  }
};
</script>

<style>
#Post{
  height: 100%;
  width: 100%;
}
#PostHeader{
  height: 15%;
  background-image: linear-gradient(to right, rgb(255, 110, 134), rgb(255, 135, 155));
}
h3{
  font-family:'Open Sans', sans-serif;
}
img {
    height: 100%;
    width: 200px;
}
#UserPicture{
height: 75%;
width: 100%;
}

#ProfilePicture{
  display: inline-block;
  height: 15px;
  width: 15px;
  border-radius: 10%;
  margin-left: 5%;
  border: 1px solid grey;
}
#Username{
  display: inline-block;
  font-size: 15px;
  padding-left: 5%;
}
#InteractionPanel{
  height: 10%;
   background-image: linear-gradient(to right, rgb(255, 110, 134), rgb(255, 135, 155));
}
h4{
  height: auto;
  margin: 0px;
  margin-left: 5%;
  font-family:'Open Sans', sans-serif;
}

</style>