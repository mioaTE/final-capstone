<template>
 <div>

    <section id="profileHeader">

     <h1>Welcome to {{user.profileName}}'s Profile</h1>

    </section>

    <section id="userPost">
        <div v-for="post in posts" v-bind:key="post.postId">
       <router-link id="post" v-bind:to="{name: 'post', params: {id: post.postId} }">
         <img class="image" v-bind:src="post.urlImage" />
       </router-link>
        </div>
    </section>

 </div>
</template>

<script>
import postService from '../services/PostService';
export default {
    name: 'user-detail',
    data() {
        return {
            user: { },
            posts: []
        }
    },    
    created() {
        postService.getUser(this.$route.params.id).then((response) => {
          this.user = response.data;
          console.log(this.user);
        })
        postService.getPostsByUser(this.$route.params.id).then((response) => {
          this.posts = response.data;
          console.log(this.posts);
        })
    },
    
}
</script>

<style>
.lightmode {
    background-image: radial-gradient(rgb(255, 225, 230), rgb(255, 171, 185)) ;
}
.darkmode {
    background-image: linear-gradient(to bottom, rgb(65, 65, 65),rgb(83, 83, 83),rgb(99, 99, 99) );
}
#navbar{
    grid-area: navbar;
    height: auto;
    background: rgb(255, 154, 171);
}
#profileHeader {
    display: flex;
    width: 100%;
    flex-direction: row;
    /* background-color: white; */
    /* background-color: #616161; */
    align-items: center;
    font-family: 'Open Sans', sans-serif;
    box-shadow: 0px 2px 10px rgb(184, 184, 184);
    justify-content: center;
    height: 100px;
}

.lightmode #profileHeader{
    background: rgb(255, 154, 171);
}

.darkmode #profileHeader{
    background: rgb(110, 110, 110);
}
.settings-icon {
    margin-top: 15px;
    margin-right: 10px;
    max-height: 30px;
    max-width: 30px;
    border-radius: 100%;
    background: rgb(255, 154, 171);
    background-clip: border-box;
}
#userPost{
    display: flex;
    justify-content: flex-start;
    align-items: center;
    flex-wrap: wrap;
    margin-top: 10px;
}

#userPost div{
    display: flex;
    justify-content: center;
    align-items: center;
    width: 20%;

}

.lightmode #userPost img{
    width: 230px;
    height: 200px;
    border: 2px solid gold;
    margin: 5px;
}

.darkmode #userPost img{
    width: 230px;
    height: 200px;
    border: 2px solid black;
    margin: 5px;
}

</style>