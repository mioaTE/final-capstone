<template>
  <div id="login" class="text-center">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
    <form @submit.prevent="login">
      <h1>Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label id="icon" for="name"><i class="icon-envelope "></i></label>
        <input type="email" id="email" placeholder="Email" v-model="user.email" required autofocus />
        </div>
      <div class="form-input-group">
        <label id="icon" for="name"><i class="icon-shield"></i></label>
        <input type="password" id="password" placeholder="Password" v-model="user.password" required />
      </div>
      <button class="button" type="submit">Sign in</button>
      <br>
      <p>
      <router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
form {
  background-color: #e83e8c;
  font-family: 'Open Sans', sans-serif;
  max-height: 400px;
  border-style: solid;
  border-color: gold;
  border-radius: 25px;
}
.form-input-group {
  display: flex;
  margin-bottom: 1rem;
  justify-content: center;
}
label {
  margin-right: 0.5rem;
}
#login {
  display: flex;
  background-color: pink;
  color: gold;
  justify-content: center;
  height: 100vh;
  width: 100%;
  align-items: center;
}
h1 {
  font-size: 32px;
  font-weight: 300;
  text-align: center;
  padding-top: 10px;
  margin-bottom: 10px;
}
p {
  font-size: 12px;
  width: 150px;
  display: inline-block;
  margin-left: 18px;
  text-align: center;
}
.button {
  font-size: 14px;
  font-weight: 600;
  color: white;
  padding: 6px 25px 0px 20px;
  margin: 10px 8px 20px 0px;
  display: inline-block;
  /* float: right; */
  text-decoration: none;
  /* width: 50px; height: 27px; */
  -webkit-border-radius: 5px; 
  -moz-border-radius: 5px; 
  border-radius: 5px; 
  background-color: pink; 
  -webkit-box-shadow: 0 3px pink; 
  -moz-box-shadow: 0 3px pink; 
  box-shadow: 0 3px pink;
  transition: all 0.1s linear 0s; 
  top: 0px;
  position: relative;
  border: none;
  left: 24%;
}
.button:hover {
  top: 3px;
  background-color:pink;
  -webkit-box-shadow: none; 
  -moz-box-shadow: none; 
  box-shadow: none;
}
</style>