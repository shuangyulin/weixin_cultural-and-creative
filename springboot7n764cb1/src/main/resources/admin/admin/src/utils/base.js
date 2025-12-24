const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot7n764cb1/",
            name: "springboot7n764cb1",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot7n764cb1/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于微信小程序的博物馆文创系统的设计与实现"
        } 
    }
}
export default base
