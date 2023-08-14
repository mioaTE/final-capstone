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
    postList: []

  },
  mutations: {
    GET_USERS(state, users) {
      state.users = users;
    },
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
    UPDATE_POST_LIST(state, postList) {
      state.postList = postList;
    }
  },
  getters: {
    product(state) {
      return state.users.find(p => p.id == state.activeProduct);
    },

    getUsers: (state) => state.users
  },

  actions: {
    async fetchUsers({ commit }) {
      const response = await axios.get('/users');
      commit('GET_USERS', response.data);
    }

  }
})
