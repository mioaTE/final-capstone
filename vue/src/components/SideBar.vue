<template>
  <div>
      <nav id="sidebar">
          <h3>View Pictures</h3>
          <h3>User Posts</h3>
    </nav>
</div>
</template>

<script>
export default {
    name: "side-bar",

}
</script>

<style>
.sidebar {
    height: 100%;
    width: 150px;
    top: 0;
    left: 0;
    padding-top: 40px;
    background-color: lightblue;
    display: flex;
    justify-content: space-between;
    align-items: center;
}
div {
    padding: 8px;
    font-size: 24px;
    display: block;
}
.body-text {
    margin-left: 150px;
    font-size: 18px;
}
</style>