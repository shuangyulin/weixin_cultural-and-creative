import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import yuyinjiangjie from '@/views/modules/yuyinjiangjie/list'
	import news from '@/views/modules/news/list'
	import aboutus from '@/views/modules/aboutus/list'
	import goumaidingdan from '@/views/modules/goumaidingdan/list'
	import wenchuangjiaohuan from '@/views/modules/wenchuangjiaohuan/list'
	import wenchuanghuodong from '@/views/modules/wenchuanghuodong/list'
	import jifenpaixingbang from '@/views/modules/jifenpaixingbang/list'
	import storeup from '@/views/modules/storeup/list'
	import forum from '@/views/modules/forum/list'
	import forumtype from '@/views/modules/forumtype/list'
	import chanpinfenlei from '@/views/modules/chanpinfenlei/list'
	import systemintro from '@/views/modules/systemintro/list'
	import yonghu from '@/views/modules/yonghu/list'
	import wenchuangshangpin from '@/views/modules/wenchuangshangpin/list'
	import forumreport from '@/views/modules/forumreport/list'
	import messages from '@/views/modules/messages/list'
	import config from '@/views/modules/config/list'
	import discusswenchuangshangpin from '@/views/modules/discusswenchuangshangpin/list'
	import huodongcanyu from '@/views/modules/huodongcanyu/list'
	import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/yuyinjiangjie',
		name: '语音讲解',
		component: yuyinjiangjie
	}
	,{
		path: '/news',
		name: '文创资讯',
		component: news
	}
	,{
		path: '/aboutus',
		name: '关于我们',
		component: aboutus
	}
	,{
		path: '/goumaidingdan',
		name: '购买订单',
		component: goumaidingdan
	}
	,{
		path: '/wenchuangjiaohuan',
		name: '文创交换',
		component: wenchuangjiaohuan
	}
	,{
		path: '/wenchuanghuodong',
		name: '文创活动',
		component: wenchuanghuodong
	}
	,{
		path: '/jifenpaixingbang',
		name: '积分排行榜',
		component: jifenpaixingbang
	}
	,{
		path: '/storeup',
		name: '我的收藏',
		component: storeup
	}
	,{
		path: '/forum',
		name: '交流论坛',
		component: forum
	}
	,{
		path: '/forumtype',
		name: '论坛分类',
		component: forumtype
	}
	,{
		path: '/chanpinfenlei',
		name: '产品分类',
		component: chanpinfenlei
	}
	,{
		path: '/systemintro',
		name: '系统简介',
		component: systemintro
	}
	,{
		path: '/yonghu',
		name: '用户',
		component: yonghu
	}
	,{
		path: '/wenchuangshangpin',
		name: '文创商品',
		component: wenchuangshangpin
	}
	,{
		path: '/forumreport',
		name: '举报记录',
		component: forumreport
	}
	,{
		path: '/messages',
		name: '知识问答',
		component: messages
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	,{
		path: '/discusswenchuangshangpin',
		name: '文创商品评论',
		component: discusswenchuangshangpin
	}
	,{
		path: '/huodongcanyu',
		name: '活动参与',
		component: huodongcanyu
	}
	,{
		path: '/newstype',
		name: '文创资讯分类',
		component: newstype
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
