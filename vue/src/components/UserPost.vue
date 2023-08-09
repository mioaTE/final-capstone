<template>
<div>
  <img v-bind:src="catPicURL"/>
  </div>
</template>

<script>
import catPicService from '../services/CatPictureServices.js';
export default {
    name: "user-post",
    data() {
        return {
        catPicURL: ''
        }
    },
    created() {
        catPicService.getCatPic().then((response) => {
        let data = response.data[0];
        this.catPicURL = data.url;
    })
  }
};
</script>

<style>
img {
    height: 200px;
    width: 200px;
}
</style>