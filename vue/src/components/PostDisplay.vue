<template>
  <div v-bind:key="hedgehog.postId">
      <h3>{{ hedgehog.postId }}</h3>
  </div>
</template>

<script>
export default {
    name: "post-display",
    props:["hedgehog"]

}
</script>

<style>

</style>