<template>
    <div class="btn">
        <button id="changeColors" onclick="changeColor(rgb(255, 225, 230), rgb(255, 171, 185))">Change Colors</button>
    </div>
</template>

<script>
export default {
  name: "color-change"
}
</script>

<style>
body {
  background-image: radial-gradient(rgb(255, 225, 230), rgb(255, 171, 185));
  display: flex;
  height: 100vh;
  width: 98%;
  align-items: center;
  justify-content: center;
  color: goldenrod;
}
#changeColors {
  width: 350px;
  height: 100px;
  color: orange;
  font-size: 2rem;
  background-image: radial-gradient(rgb(58, 53, 54), rgb(31, 26, 27)) ;
  border-radius: 25px;
  border: 0;
  outline: 0;
}
</style>