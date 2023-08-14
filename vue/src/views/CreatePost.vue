<template>
   <div id="Upload" :class="this.$store.state.isDark ? 'darkmode' : 'lightmode'">
       <section id="navbarSection">
              <nav-bar id="navbar"/>
       </section>

       <section id="uploadSection">    
           <upload-pic id="upload" />
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

</style>