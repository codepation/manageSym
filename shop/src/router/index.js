import { createRouter,createWebHashHistory,createWebHistory } from "vue-router";
import hello from '../components/HelloWorld.vue'
import { compareTime } from "element-plus/es/components/time-select/src/utils.mjs";
import component from "element-plus/es/components/tree-select/src/tree-select-option.mjs";
import { pa } from "element-plus/es/locales.mjs";

const routes = [
    {
        path:'/login',
        name:'login',
        component:()=> import('../../src/login.vue'),
    },
    {
        path:'/logout',
        name:'logout',
        component:()=>import('../components/logout.vue')
    },
    
    {
        path:'/hello',
        name:'hello',
        component:()=>import('../components/hello.vue'),
        children:[
            {
                path:'/page/:id',
                name:'page',
                component:()=> import('../components/page.vue'),
                props:true
            },
        ]
            
        
    }
]
const router = createRouter({
    history: createWebHashHistory(),
    routes
})

// router.beforeEach((to,from,next)=>{
//     if(to.name !== 'about'&&to.meta){
//         alert("loging!")
//         next({name:'about'});
//     }else{
//         next();
//     }
// })
export default router