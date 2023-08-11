<template>
  <body>
    <h1>Your Favorites</h1>
    <ul class="favorites-list">
        <li class="favorite-item">
            <p class="item-name">Favorite Item 1</p>
            <button class="remove-button">Remove</button>
        </li>
        <li class="favorite-item">
            <p class="item-name">Favorite Item 2</p>
            <button class="remove-button">Remove</button>
        </li>
        <li class="favorite-item">
            <p class="item-name">Favorite Item 3</p>
            <button class="remove-button">Remove</button>
        </li>
    </ul>
</body>
</template>

<script>
export default {

}
</script>

<style>
body {
    font-family: 'Open Sans', sans-serif;
    margin: 0;
    padding: 20px;
}
.favorites-list {
    list-style: none;
    padding: 0;
}
.favorite-item {
    display: flex;
    align-items: center;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    padding: 10px;
}
.item-name {
    flex: 1;
    margin: 0;
}
.remove-button {
    background-color: #f2f2f2;
    border: none;
    padding: 5px 10px;
    cursor: pointer;
}
</style>