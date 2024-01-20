import axios from "axios";

const apiClient = axios.create({
    baseURL:"http://localhost:8090/api/client"
})
export default apiClient;