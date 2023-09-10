import axios from "axios";
import cookie from "react-cookies";

const SERVER_CONTEXT = "/SpringMVCThueNha1";
const SERVER = "http://localhost:8080";

export const endpoints =  {
    "posts": `${SERVER_CONTEXT}/api/posts/`,
    "user": `${SERVER_CONTEXT}/api/user/`,
    "comments": `${SERVER_CONTEXT}/api/comments/`,
    "login": `${SERVER_CONTEXT}/api/login/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/`,
    "register": `${SERVER_CONTEXT}/api/users/`,
    "details": (idPost) => `${SERVER_CONTEXT}/api/posts/${idPost}/`,
    "comments": (idPost) => `${SERVER_CONTEXT}/api/posts/${idPost}/comments/`,
    "add-comment": `${SERVER_CONTEXT}/api/comments/`,

}

export const authApi = () => {
    return axios.create({
        baseURL: SERVER,
        headers: {
            "Authorization": cookie.load("token")
        }
    })
}

export default axios.create({
    baseURL: SERVER
});