<template>
    <div class="flexbox">
	<div class="fav-btn">
		<span href="" class="favme dashicons dashicons-heart"></span>
	</div>
</div>
</template>

<script>
function createFavoriteButton(containerId) {
    var container = document.getElementById(containerId);
    var button = document.createElement("button");
    button.className = "favorite-button";
    button.textContent = "Add to Favorites";
            
    var isFavorited = false;
            
    button.addEventListener("click", function() {
        if (isFavorited) {
            button.textContent = "Add to Favorites";
            button.classList.remove("favorited");
        } else {
            button.textContent = "Remove from Favorites";
            button.classList.add("favorited");
        }
        isFavorited = !isFavorited;
    });
    container.appendChild(button);
}
createFavoriteButton("favorite-button-container", "item-123");
</script>

<style>
add-fav {
  display: inline-block;
  padding: 5px;
  cursor: pointer;
  border: 1px solid #ccc;
  background: -webkit-linear-gradient( top,#fff,#ddd) #ddd;
  position: relative;
  transition: all .5s ease;
  border-radius: 3px;
  box-shadow: inset 0 -1px 1px #eee;
}
flexbox.hover {
    background: -webkit-linear-gradient( top,#fff,#ccc) #ddd;
}
.icon-heart {
    font-size: 24px;
    color: #666;
    position: relative;
    transition: all .5s ease-in-out;
}
.icon-plus-sign {
    font-size: 10px;
    color: #333;
    background: #fff;
    border-radius: 100%;
    position: absolute;
    bottom: 2px;
    right: 2px;
    height: 11px;
    width: 11px;
    line-height: 11px;
    text-align: center;
    transition: all 1s ease-in-out;
}
input[type="checkbox"] { 
    position: absolute;
    opacity: 0;
}
flexbox.checked + .icon-heart {
    color: orange;
}
.icon-plus-sign {
     display:none;
}
</style>