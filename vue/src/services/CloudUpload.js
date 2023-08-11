import axios from 'axios'; 

//axios instance with no base URL
const axiosInstance = axios.create(); 

export default { 

    getCatPic() { 
        //getting a random picture
        return axiosInstance.get('https://api.thecatapi.com/v1/images/search');
    }
}