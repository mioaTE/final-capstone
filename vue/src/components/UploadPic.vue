<template>
<div>
    <section id="header">
       <h3>Post Something Fun!</h3>
    </section>   
    <section id="postContent">
      <button v-on:click="upload">Choose a Picture</button>
      <img v-if="this.newPost.urlImage !== ''" v-bind:src="this.newPost.urlImage" />
      <form v-on:submit.prevent="submitPost">
      <label for="postDescription">Write a Description</label>
      <textarea id="postDescription" name="postDescription" type="text" v-model="newPost.postDescription"/>
      <button class="button" type="submit">Post</button>
      </form>
    </section>
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
              this.$router.push('/');
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
      sendToHomepage(){
        this.$router.push('/');
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
form {
  width: auto;
  height: 40%;
  font-family: 'Open Sans', sans-serif;
  max-height: 400px;
  border-style: solid;
  border-radius: 25px;
}
.lightmode button{
   display: inline-block;
  width: 5%;
  height: 25px;
  justify-content: center;
  align-items: center;
  font-family:'Open Sans', sans-serif;
  background-color: rgb(252, 142, 160);
  border: none; /* Remove borders */
  color: white; /* White text */
  padding: 10px; /* Some padding */
  margin: 5px;
  font-size: 16px; /* Set a font size */
  cursor: pointer; /* Mouse pointer on hover */
  border: 2px solid black;
  border-radius: 25px;
  width: auto;
  height: auto;
}
.lightmode button:hover {
  top: 3px;
  background-color:#e83e8c;
  -webkit-box-shadow: none;
  -moz-box-shadow: none;
  box-shadow: none;
}
.lightmode .btn{
  display: inline-block;
  width: 5%;
  height: 25px;
  justify-content: center;
  align-items: center;
  font-family:'Open Sans', sans-serif;
  background-color: rgb(252, 142, 160);
  border: none; /* Remove borders */
  color: white; /* White text */
  padding: 10px; /* Some padding */
  margin: 5px;
  font-size: 16px; /* Set a font size */
  cursor: pointer; /* Mouse pointer on hover */
  text-decoration: none;
  border-radius: 25px;
}
.lightmode .btn:hover {
  top: 3px;
  background-color:#e83e8c;
  -webkit-box-shadow: none;
  -moz-box-shadow: none;
  box-shadow: none;
}
.darkmode button{
   display: inline-block;
  justify-content: center;
  align-items: center;
  font-family:'Open Sans', sans-serif;
  background-color: rgb(255, 164, 79);
  border: none; /* Remove borders */
  color: white; /* White text */
  padding: 10px; /* Some padding */
  margin: 5px;
  font-size: 16px; /* Set a font size */
  cursor: pointer; /* Mouse pointer on hover */
  text-decoration: none;
  border-radius: 25px;
  border: 2px solid black;
  width: auto;
  height: auto;
}
.darkmode button:hover {
  top: 3px;
  background-color:#ff9419;
  box-shadow: none;
}
.darkmode .btn{
  display: inline-block;
  justify-content: center;
  align-items: center;
  font-family:'Open Sans', sans-serif;
  background-color: rgb(255, 164, 79);
  border: none; /* Remove borders */
  color: white; /* White text */
  padding: 10px; /* Some padding */
  margin: 5px;
  font-size: 16px; /* Set a font size */
  cursor: pointer; /* Mouse pointer on hover */
  text-decoration: none;
  border-radius: 25px;
}
.darkmode .btn:hover {
  top: 3px;
  background-color:#ff9419;
  box-shadow: none;
}
#header{
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>