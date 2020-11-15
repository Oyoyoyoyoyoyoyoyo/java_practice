// 封装axios
import axios from 'axios'
import Element from 'element-ui'
import router from './router'
import store from './store'
axios.defaults.baseURL = "http://localhost:8081"

// 前置拦截
axios.interceptors.request.use(config => {
    return config
})

// 后置拦截
axios.interceptors.response.use(response => {
    let res = response.data;
    console.log(res);

    if (res.code === 200) {
        return response
    } else {
        Element.Message.error(response.data.message, {
            duration: 3000
        })
        // 跳出执行逻辑
        return Promise.reject(response.data.message)
    }
}, error => {
    
    // 清楚用户信息，并跳转登陆页面
    if (error.response.status === 401) {
        store.commit("REMOVE_INFO")
        router.push("/login")
    }
    Element.Message.error(error.response.data.message, {
        duration: 3000
    })
    return Promise.reject(response)
})