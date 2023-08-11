import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    activeUser: 0,
    token: currentToken || '',
    user: currentUser || {},
    isDark: true,
    posts: [
      {

      }
    ],
    users: [
      {
          id: 0,
          username: "Jimbo"
      },
      {
          id: 1,
          username: "Bob",
          posts: [
            {
              postId: 1001,
              postImage: require('../assets/dog1.jpg'),
              description: "this is user1's post postId:1001"
            },
            {
              postId: 1002,
              postImage: require('../assets/dog1.jpg'),
              description: "this is user1's post postId:1002"
            },
            {
              postId: 1003,
              postImage: require('../assets/dog1.jpg'),
              description: "this is user1's post postId:1003"
            },
          ]
      },
      {
          id: 2,
          username: "Bill"
      },
      {
        id: 3,
        username: "Jackie Chan"
      },
      {
        id: 4,
        username: "LargeArms42"
      },
      {
        id: 5,
        username: "BigOlBucketLover"
      },
      {
        id: 6,
        username: "Cheese?"
      },
      {
        id: 7,
        username: "Ryan Reynolds"
      },
      {
        id: 8,
        username: "Bill Gates"
      },
      {
        id: 9,
        username: "Forrest Gump"
      }
      
    ]
  },
  mutations: {
    SET_ACTIVE_USER(state, userId){
      state.activeUser = userId;
    },
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    TOGGLE_DARK_MODE(state) {
      state.isDark = ! state.isDark;
    },
    ADD_POST(state, post) {
      state.posts.unshift(post);
    }
  },
  getters: {
    product(state) {
      return state.users.find(p => p.id == state.activeProduct);
    }
  }
})
