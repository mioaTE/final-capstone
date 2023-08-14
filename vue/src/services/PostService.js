import axios from 'axios';

export default {

    getUser(userId){
        return axios.get(`/user/${userId}`);
    },

    getPostsByUser(userId){
        return axios.get(`/posts/user/${userId}`)
    },
    
    submitComment(comment) {
        return axios.post(`/comments`, comment);
    },
    deleteComment(commentId) {
        return axios.delete(`/comments/${commentId}`);
    },
    listPosts() {
        return axios.get('/posts')
    },
    getPost(postId) {
        return axios.get(`/posts/${postId}`)
    },
    getUserById(userId){
        return axios.get(`/users/${userId}`)
    },
    addPost(thePost) {
        return axios.post('/posts', thePost)
    },
    listFavorites() {
        return axios.get('/favorites')
    },
    addFavorite(postId) {
        return axios.post(`/favorites/${postId}`)
    },
    removeFavorite(postId) {
        return axios.delete(`/favorites/${postId}`)
    },
    addLiked(postId) {
        return axios.post('/likes', postId)
    },
    removeLiked(userId, postId) {
        return axios.delete(`like/${userId}/${postId}`)
    },
    listFollowing() {
        return axios.get(`/following`)
    },
    computeLiked(userId, postId) {
        return axios.get(`like/${userId}/${postId}`)
    },
    getAllLikes() {
        return axios.get('/all-likes')
    }
}
