import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import router from './router'
import axios from 'axios'

axios.defaults.baseURL='http://localhost:8080/user/login'
axios.defaults.timeout = 5000

const app = createApp(App)
app.use(router)
app.use(ElementPlus)
app.mount('#app')


router.beforeEach((to,from,next)=>{
    const token = localStorage.getItem("token")
    if(to.name == 'login'){
        next()
    }else{
        if(token == null || token ==''){
            alert("relogin")
            next('/login')
        }else{
            next()
        }
        
    }
})


