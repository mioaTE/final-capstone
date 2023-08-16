<template>
   <div id="Upload" :class="this.$store.state.isDark ? 'darkmode' : 'lightmode'">
       <section id="navbar">
              <nav-bar />
       </section>

       <section id="uploadSection">    
           <upload-pic id="uploadpicture" />
       </section>    
       </div>
</template>

<script>

import NavBar from '../components/NavBar.vue';
import UploadPic from '../components/UploadPic.vue';

export default {
    sameSite:'none', 
    secure:true,
    httpOnly:true,
  name: "createpost",
components: {
    NavBar,
    UploadPic
},
props: ['isDark'],
}
</script>

<style>

#Upload{
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 1fr 3fr;
  grid-template-areas:
    "navbar"
    "uploadpicture"
}
#navbar{
    height: 100%;
}
#uploadSection{
  display: flex;
  justify-content: center;
  align-content: center;
  height: auto;
  width: 100%;
}
#postContent{
  display: flex;
  justify-content: center;
  align-content: center;
  align-items: center;
  flex-direction: column;
  margin-top: 10%;
}

#postContent button{
    margin-bottom: 5%;
}

#postContent img{
    margin-bottom: 5%;
    border: 2px solid black;
}

#postContent form{
    display: flex;
    justify-content: center;
    align-content: center;
    align-items: center;
    flex-direction: column;
    margin-top: 15%;
    width: 100%;
}
#postContent textarea{
    height: 100px;
    width: 350px;
    margin: 10%;
}

.lightmode #postContent textarea{
    background: #ffaddf;
}

.darkmode #postContent textarea{
    background: rgb(201, 201, 201);
}

.lightmode #header{
    color: rgb(0, 0, 0);
}

.darkmode #header{
    color: white;
}
.lightmode form label{
    color: rgb(2, 2, 2);
}

.darkmode form label{
    color: white;
}
</style>