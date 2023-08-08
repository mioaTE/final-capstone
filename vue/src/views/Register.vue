<template>
  <div id="register" class="text-center">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
    <form @submit.prevent="register">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label id="icon" for="name"><i class="icon-envelope "></i></label>
        <input type="email" id="email" placeholder="Email" v-model="user.email" required autofocus />
        </div>
      <div class="form-input-group">
        <label id="icon" for="name"><i class="icon-user"></i></label>
        <input type="text" id="username" placeholder="Name" v-model="user.username" required autofocus />
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
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
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
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
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


form {
 
  background-color: #e83e8c;
  font-family:'Open Sans', sans-serif;
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

#register {
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: pink;
  color: gold;
  height: 100vh;
  width: 100%;
  
  
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
  font-size: 12px;
  font-weight: 600;
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
