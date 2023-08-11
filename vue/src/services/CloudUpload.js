import axios from 'axios'; 

//axios instance with no base URL
const axiosInstance = axios.create(); 

export default { 

    getUserPost() { 
        //getting a random picture
        return axiosInstance.get('$store.state.post.picUrl');
    }
}