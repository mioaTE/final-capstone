<template>
 <div>
     <h1>This is UserDetail</h1>
     <h2>User ID: {{ user.id }}</h2>
     <h2>User name: {{ user.username}}</h2>
 </div>
</template>

<script>
export default {
    name: 'user-detail',
    props: ['users'],
    computed: {
        user(){
            return this.$store.state.users.find((user) => {
                    return user.id == this.$store.state.activeUser;
                })
        }
    },
    created() {
      const activeUserId = this.$route.params.id;
      this.$store.commit('SET_ACTIVE_USER', activeUserId);
    }
}
</script>

<style>

</style>