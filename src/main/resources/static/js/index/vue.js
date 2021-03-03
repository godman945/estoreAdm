$(document).ready(function(){

console.log("----------------------");






		var data_address = {"A01": "中文","A02": "英文"};
		console.log(data_address);
	
	
		 var app3Start = new Vue({
		  el: '#app3',
		  data: {
		    message: [
		     'TEST1','TEST2','TEST3'
		    ]
		  },
		   mounted: function(){
			 console.log(this);
		   },
		   components: {
		   
		   }
		});
		
		
		Vue.component('my-component', {
		  template: '#my-component'
		});
		
		
		let vm = new Vue({
		    el:'#app9',
		    template:'<v-btn block>Block Button</v-btn>'
		})
		
	
})