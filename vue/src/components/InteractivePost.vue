<template>
  <div id="PostView">

      <section id="postImg">
      <img  v-bind:src="postDetails.urlImage" />
      </section>

      <section id="postdescription">
          
         {{ user.profileName }}: {{ postDetails.postDescription }}
      </section>

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

<style scoped>
#PostView{
display: flex;
justify-content: center;
align-items: center;
flex-direction: column;
margin: 25px;

border-radius: 20px;
}

.lightmode #PostView{
background: rgb(255, 150, 167);
border: 2px solid gold;
}

.darkmode #PostView{
background: grey;
border: 2px solid black;

}


.darkmode Img{
margin: 20px;
border: 2px solid black;
}

.lightmode Img{
margin: 20px;
border: 2px solid gold;
}

.lightmode #postdescription{
margin: 20px;
}

.darkmode #postdescription{
margin: 20px;
}

</style>