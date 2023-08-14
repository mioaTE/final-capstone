<template>
<div id="userProfile" :class="this.$store.state.isDark ? 'darkmode' : 'lightmode'">
  <nav-bar id="navbar" />
  <user-detail id="profile" />
</div>
</template>

<script>
import UserDetail from '../components/UserDetail.vue'
import NavBar from '../components/NavBar.vue'
export default {
  sameSite:'none', 
    secure:true,
    httpOnly:true,
  name: "user",

  props: ['isDark'],
  components: {
    UserDetail,
    NavBar,
  },

  computed: {
    user() {
      return this.$store.state.users.find((user) => {
        return user.id == this.$store.state.users;
      })
    }
  }
};
</script>

<style>

#userProfile{
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 1fr 3fr;
  grid-template-areas:
    "navbar"
    "profile"
}
#navbar{
  grid-area: navbar;
  height: auto;
}
#profile{
  grid-area: profile;
}

 .darkmode {
 background-image: linear-gradient(to bottom, rgb(65, 65, 65),rgb(83, 83, 83),rgb(99, 99, 99) );
  }
  .lightmode {
  background-image: radial-gradient(rgb(255, 225, 230), rgb(255, 171, 185)) ;

}
</style>