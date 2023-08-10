<template>
  <user-detail />
</template>

<script>
import UserDetail from '../components/UserDetail.vue'
export default {
  components: { UserDetail },
  computed: {
    user() {
      return this.$store.state.users.find((user) => {
        return user.id == this.$store.state.users;
      })
    }
  }
}
</script>

<style>

</style>