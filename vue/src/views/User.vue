<template>
  <div class="profile">
    <img class="profile-img" src="profile-picture.jpg" alt="Profile Picture">
        <div class="profile-info">
            <h1></h1>
            <p></p>
        </div>
    </div>
  <!-- <div class="post">
    <p></p>
  </div> -->
</template>

<script>
export default {

}
</script>

<style>
.profile {
  display: flex;
  align-items: center;
  padding: 20px;
}
.profile-img {
  width: 100px;
  height: 100px;
  border-radius: 50%;
  object-fit: cover;
  margin-right: 20px;
}
.profile-info {
  flex: 1;
}
.profile-info h1 {
  margin: 0;
  font-size: 24px;
}
.profile-info p {
  margin: 5px 0;
  font-size: 16px;
}
.posts {
  padding: 20px;
  border-top: 1px solid #ddd;
}
.post {
  margin-bottom: 15px;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 5px;
}
</style>