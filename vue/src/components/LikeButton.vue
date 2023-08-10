<template>
    <div id="like-button-container"></div>
</template>

<script>
function createLikeButton(containerId) {
    var container = document.getElementById(containerId);
    var button = document.createElement("button");
    button.className = "like-button";
    button.textContent = "Like";
            
    var isLiked = false;
    var likeCount = 0;
            
    button.addEventListener("click", function() {
        if (isLiked) {
            button.textContent = "Like";
            button.classList.remove("liked");
            likeCount--;
        } else {
            button.textContent = "Unlike";
            button.classList.add("liked");
            likeCount++;
        }
        isLiked = !isLiked;
        updateLikeCount();
    });
            
    var likeCountElement = document.createElement("span");
    likeCountElement.className = "like-count";
    updateLikeCount();
            
    container.appendChild(button);
    container.appendChild(likeCountElement);
            
    function updateLikeCount() {
        likeCountElement.textContent = likeCount + (likeCount === 1 ? " like" : " likes");
    }
}
createLikeButton("like-button-container");
</script>

<style>
.photo {
    border: 1px solid #ccc;
    padding: 10px;
    margin: 10px;
    display: inline-block;
}
.like-button {
    background-color: #f2f2f2;
    border: none;
    padding: 5px 10px;
    cursor: pointer;
}
</style>