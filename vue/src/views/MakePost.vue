<template>
<div>
    <h3>Upload Picture</h3>
  <button v-on:click="upload">Upload</button>
  <br />
  <img v-if="this.newPost.picUrl !== ''" v-bind:src="this.newPost.picUrl" />
<form v-on:submit.prevent="submitPost">
  
  <label for="description">Write a Description</label>
  <textarea id="description" name="description" type="text" v-model="newPost.description"/>
  <br />
   <button class="button" type="submit">Post</button>
</form>
</div>
</template>

<script>
import postService from "../services/PostService";
export default {
    
    sameSite:'none', 
    secure:true,
    httpOnly:true,
    name: 'CloudinaryComp',
  data() {
    return {
      myWidget : {},
      newPost: {
          userId: this.$store.state.userId,
          picUrl: '',
          description: '',
      }
    }
  },
  methods: {
      upload() {
        this.myWidget.open();
      },
      submitPost() {
          this.newPost = {
              userId: this.newPost.userId,
              picUrl: this.newPost.picUrl,
              description: this.newPost.description
          }
          postService.addPost(this.newPost).then(response => {
              if (response.status === 201) {
              this.$router.push('/posts');
            }
          })
          .catch(error => {
            this.handleErrorResponse(error, "adding");
          });
          this.newPost = {
            userId: this.$store.state.userId,
            picUrl: '', 
            description: ''}


      },
      ResetPost() {
          this.newPost = {
            user: this.user,
            picUrl: '',
            description: ''

          };  
      }
  },
  mounted() {
       this.myWidget = window.cloudinary.createUploadWidget(
      {
        // Insert your cloud name and presets here, 
        // see the documentation
        cloudName: 'dmxisezmv', 
        uploadPreset: 'j63cbjrs'
      }, 
      (error, result) => { 
        if (!error && result && result.event === "success") { 
          console.log('Done! Here is the image info: ', result.info); 
          console.log("Image URL: " + result.info.url);
          this.newPost.picUrl = result.info.url;
          this.newPost.user = this.$store.state.user;
          console.log("pic url: " + this.newPost.picUrl);
        //   this.$store.commit("ADD_POST", this.newPost);
          console.log(this.newPost);
          
        }
       
      }
    );

  }

}
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>