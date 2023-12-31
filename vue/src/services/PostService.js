import axios from 'axios';
//axios is a library can make HTTP request/response easily
//REST API is Representational state transfer API, and it is an interface that allows transfer of data between computer programs.
//JSON is javascript object notaion, has key-value pairs. Used widely because it's simple and readable for data-interchange
export default {

    updatePostLikes(post){
        return axios.put(`/posts/${post.postId}`, post)
    },

    getUser(userId){
        return axios.get(`/user/${userId}`);
    },

    getPostsByUser(userId){
        return axios.get(`/posts/user/${userId}`)
    },
    
    submitComment(comment) {
        return axios.post('/comments', comment);
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
    addLiked(like) {
        return axios.post('/likes', like)
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
    },
    
    addFavorite(postId) {
        return axios.post(`/favorites`, postId)
    },
    removeFavorite(userId, postId) {
        return axios.delete(`/favorite/${userId}/${postId}`)
    },
    listFavoritesByUser(userId) {
        return axios.get(`all-favorites/${userId}`)
    },

    getPostById(postId) {
        return axios.get(`posts/${postId}`)
    },

    getCommentByPostId(postId) {
        return axios.get(`/comments/${postId}`)
    }
}
