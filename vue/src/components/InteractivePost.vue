<template>
  <div id="PostView">

      <section id="username">
         {{ user.profileName }}
      </section>

      <section id="postImg">
      <img  v-bind:src="postDetails.urlImage" />
      </section>

      <section id="postdescription">
         {{ postDetails.postDescription }}
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

<style>
#PostView{
display: flex;
justify-content: center;
align-items: center;
flex-direction: column;
}

#username{
margin: 20px;
}

#postImg{

}

.lightmode #postdescription{
margin: 20px;
}

.darkmode #postdescription{
    
}

</style>