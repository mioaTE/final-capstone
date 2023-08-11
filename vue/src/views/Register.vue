<template>
  <div :class="$store.state.isDark ? 'darkmode' : 'lightmode'" id="register" class="text-center">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
    <nav-bar :class="$store.state.isDark ? 'darkmode' : 'lightmode'" id="navbar"/>
    <section :class="$store.state.isDark ? 'darkmode' : 'lightmode'" id="registerform">
    <form :class="$store.state.isDark ? 'darkmode' : 'lightmode'" @submit.prevent="register">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label id="icon" for="name"><i class="icon-envelope "></i></label>
        <input type="email" id="email" placeholder="Email" v-model="user.email" required autofocus />
        </div>
        <div class="form-input-group">
          <label id="username"><i class="icon-user"></i></label>
          <input type="text" id="username" placeholder="User name" v-model="user.profileName" required autofocus />
          </div>
      <div class="form-input-group">
        <label id="icon" for="name"><i class="icon-shield"></i></label>
        <input type="password" id="password" placeholder="Password"  v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label id="icon" for="name"><i class="icon-shield"></i></label>
        <input type="password" id="confirmPassword" placeholder="Confirm Password"  v-model="user.confirmPassword" required />
      </div>
      
      <!-- <button type="submit">Create Account</button> -->
      <p><router-link :to="{ name: 'login' }" class="already-have-account">Already have an account? Log in.</router-link></p>
      <br>
      <p>By clicking Register, you agree on our <a href="#">terms and condition</a>.</p>
      
      <input class="button" type="submit" value="Register"/>
    </form>
    </section>
    </div>
</template>

<script>
import authService from '../services/AuthService';
import NavBar from '../components/NavBar.vue';
export default {
  name: 'register',
  components: {
    NavBar
  },
  data() {
    return {
      user: {
        profileName: '',
        username: '',
        password: '',
        confirmPassword: '',
        email: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    hasUpperCase(str) {
      return str !== str.toLowerCase();
    },
   hasNumbers(str) {
    var regex = /\d/g;
    return regex.test(str);
    },

    register() {
      // if(this.user.password.length < 8 || !this.hasUpperCase(this.user.password) || !this.hasNumbers(this.user.password)) {
      //   this.registrationErrors = true;
      //   this.registrationErrorMsg = 'Password must contain at least 8 characters, one uppercase, and one number.';
      // } change if to else if on line 70 when turning strong passwords on
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        this.user.username = this.user.email;
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
#register {
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 1fr 3fr;
  grid-template-areas:
    "navbar"
    "register"
}
#registerform{
  grid-area: register;
  display:flex;
  justify-content: center;
  align-items: center;
}
#navbar{
  grid-area: navbar;
}

form {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
    width: 40%;
  height: 75%;
  font-family:'Open Sans', sans-serif;
  border-style: solid;
  border-radius: 25px;
}
.lightmode form{
  background-image: radial-gradient( #ffa2cd,#ff62ab) ;
    border-color: gold;
}
.darkmode form{
    background-image: radial-gradient( #4b4b4b,#303030) ;
    border-color: rgb(255, 179, 39);
}
.form-input-group {
  display: flex;
  margin-bottom: 1rem;
  justify-content: center;
}
label {
  margin-right: 0.5rem;
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
  width: auto;
  display: inline-block;
  text-align: center;
}
.button {
  font-size: 12px;
  font-weight: 600;
  width: 30%;
  color: white;
  padding: 6px 25px 6px 20px;
  margin: 10px 8px 20px 8px;
  display: inline-block;
  /* float: right; */
  text-decoration: none;
  /* width: 50px; height: 27px;  */
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
}
.button:hover {
  top: 3px;
  background-color:pink;
  -webkit-box-shadow: none; 
  -moz-box-shadow: none; 
  box-shadow: none;
}
</style>