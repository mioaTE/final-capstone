<template>
<div>
    <h3>Upload Picture</h3>
  <button v-on:click="upload">Upload</button>
  <br />
  <img v-if="this.newPost.urlImage !== ''" v-bind:src="this.newPost.urlImage" />
<form v-on:submit.prevent="submitPost">
  
  <label for="postDescription">Write a Description</label>
  <textarea id="postDescription" name="postDescription" type="text" v-model="newPost.postDescription"/>
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
          userId: this.$store.state.user.id,
          urlImage: '',
          postDescription: '',
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
              urlImage: this.newPost.urlImage,
              postDescription: this.newPost.postDescription
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
            userId: this.$store.state.user.id,
            urlImage: '', 
            postDescription: ''}


      },

      handleErrorResponse(error, verb) {
      if (error.response) {
        this.errorMsg =
          "Error " + verb + " post. Response received was '" +
          error.response.statusText +
          "'.";
      } else if (error.request) {
        this.errorMsg =
          "Error " + verb + " post. Server could not be reached.";
      } else {
        this.errorMsg =
          "Error " + verb + " post. Request could not be created.";
      }
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
          this.newPost.urlImage = result.info.url;
          this.newPost.userId = this.$store.state.user.id;
          console.log("pic url: " + this.newPost.urlImage);
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