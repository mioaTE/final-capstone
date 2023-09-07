<template>
  <div
    :class="$store.state.isDark ? 'darkmode' : 'lightmode'"
    id="login"
    class="text-center"
  >
    <link
      href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css"
      rel="stylesheet"
    />
    <nav-bar
      :class="$store.state.isDark ? 'darkmode' : 'lightmode'"
      id="navbar"
    />
    <section
      :class="$store.state.isDark ? 'darkmode' : 'lightmode'"
      id="loginform"
    >
      <form
        :class="$store.state.isDark ? 'darkmode' : 'lightmode'"
        @submit.prevent="login"
      >
        <h1>Please Sign In</h1>
        <div role="alert" v-if="invalidCredentials">
          Invalid email and password!
        </div>
        <div role="alert" v-if="this.$route.query.registration">
          Thank you for registering, please sign in.
        </div>
        <div class="form-input-group">
          <label id="icon" for="name"><i class="icon-envelope"></i></label>
          <input
            type="email"
            id="email"
            placeholder="Email"
            v-model="user.username"
            required
            autofocus
          />
        </div>
        <div class="form-input-group">
          <label id="icon" for="name"><i class="icon-shield"></i></label>
          <input
            type="password"
            id="password"
            placeholder="Password"
            v-model="user.password"
            required
          />
        </div>
        <section id="signinButton">
          <button class="button" type="submit">Sign in</button>
        </section>
        <section id="signupLink">
          <p>
            <router-link :to="{ name: 'register' }"
              >Need an account? Sign up.</router-link
            >
          </p>
        </section>
      </form>
    </section>
  </div>
</template>

<script>
import NavBar from "../components/NavBar.vue";
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {
    NavBar,
  },
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
             // Set the authentication token in the store
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            // Set the user data in the store
            this.$store.commit("SET_USER", response.data.user);
            // Redirect to the home page
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>
.lightmode {
  background-image: radial-gradient(rgb(255, 225, 230), rgb(255, 171, 185));
}
.darkmode {
  background-image: linear-gradient(
    to bottom,
    rgb(65, 65, 65),
    rgb(83, 83, 83),
    rgb(99, 99, 99)
  );
}
.lightmode form {
  background-image: radial-gradient(#ffa2cd, #ff62ab);
  border-color: gold;
}
.darkmode form {
  background: orange;
  border-color: rgb(44, 44, 44);
}

#signinButton {
  display: flex;
  justify-content: center;
  align-items: center;
}
#signupLink {
  display: flex;
  justify-content: flex-start;
  align-items: center;
  margin-left: 5%;
  margin-bottom: 5px;
}
form {
  width: 40%;
  height: 40%;
  font-family: "Open Sans", sans-serif;
  max-height: 400px;
  border-style: solid;
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
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 1fr 3fr;
  grid-template-areas:
    "navbar"
    "login";
}
#navbar {
  grid-area: navbar;
  display: flex;
  justify-content: center;
  align-items: center;
  background: pink;
}
#loginform {
  grid-area: login;
  display: flex;
  justify-content: center;
  align-items: center;
}
h1 {
  font-size: 32px;
  font-weight: 300;
  text-align: center;
  padding-top: 10px;
  margin-bottom: 10px;
}
#login > form > p {
  font-size: 12px;
  width: 150px;
  display: inline-block;
  margin-left: 18px;
  text-align: center;
}

.darkmode .button:hover {
  background-color: rgb(255, 207, 135);
}
.darkmode .button {
  background-color: rgb(255, 152, 18);
  -webkit-box-shadow: 0 3px rgb(95, 95, 95);
  -moz-box-shadow: 0 3px rgb(87, 87, 87);
  box-shadow: 0 3px rgb(90, 90, 90);
}

.lightmode .button:hover {
  background-color: rgb(255, 211, 219);
}

.lightmode .button {
  background-color: rgb(255, 125, 147);
  -webkit-box-shadow: 0 3px pink;
  -moz-box-shadow: 0 3px pink;
  box-shadow: 0 3px pink;
}

.button {
  font-size: 12px;
  font-weight: 600;
  width: 30%;
  color: white;
  padding: 6px 25px 6px 20px;
  margin: 10px 8px 20px 8px;
  display: inline-block;
  margin-left: auto;
  margin-right: auto;
  /* float: right; */
  text-decoration: none;
  /* width: 50px; height: 27px;  */
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  border-radius: 5px;
  transition: all 0.1s linear 0s;
  top: 0px;
  position: relative;
  border: none;
}
.button:hover {
  top: 3px;
  -webkit-box-shadow: none;
  -moz-box-shadow: none;
  box-shadow: none;
}
</style>