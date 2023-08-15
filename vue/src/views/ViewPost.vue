<template>


    <div id="postView" :class="this.$store.state.isDark ? 'darkmode' : 'lightmode'">


      <section id="navbarSection"> 

            <nav-bar id="navbar"/>

      </section>


      <section id="usersPost">


      </section>   


    </div>


</template>

<script>

import NavBar from '../components/NavBar.vue';

export default {
    name: 'view-post',
    data() {
    },
    components: {
        NavBar
    }
}
</script>

<style>
#postView{
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 1fr 3fr;
  grid-template-areas:
    "navbar"
    "post"
}

#navbar{
    grid-area: navbar;
}

#usersPost{
    grid-area: post;
}
</style>