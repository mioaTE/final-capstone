<template>
  <div id="Post" :class="$store.state.isDark ? 'darkmode' : 'lightmode'">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
      
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
</template>

<script>
import catPicService from '../services/CatPictureServices.js';
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