<template>
  <button v-on:click="upload">Upload</button>
</template>

<script>
export default {
    sameSite:'none', 
    secure:true,
    httpOnly:true,
    name: 'CloudinaryComp',
  data() {
    return {
      myWidget : {},
      newPost: {
          user: this.$store.state.user,
          picUrl: ''
      }
    }
  },
  methods: {
      upload() {
        this.myWidget.open();
      },
      ResetPost() {
          this.newPost = {
            user: this.user,
            picUrl: ''

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
          this.$store.commit("ADD_POST", this.newPost);
          console.log(this.newPost);
          this.newPost = {
            user: this.$store.state.user,
            picUrl: '' }
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