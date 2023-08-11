<template>
  <div class="post">
      <img v-bind:src="this.post.picUrl" />
      </div>
</template>

<script>
export default {
    sameSite:'none', 
    secure:true,
    httpOnly:true,
    name: 'cloud-post',
    props: ["post"]

}
</script>

<style>

</style>