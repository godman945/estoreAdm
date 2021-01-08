$(document).ready(function(){
	console.log("開始取得初始資料");
	
	var data_address = {"A01": "中文","A02": "英文"};
	console.log(data_address);
	
	
	
	 var app = new Vue({
		  el: '#app3',
		  data: {
		    message: [
		     'A'
		    ]
		  }
		});
            
		var language_select = new Vue({
		  el: '#language_select',
		  data: {
		    message: [
		     {"A":"A01"},
		     {"A":"A02"}
		    ]
		  }
		});
		
		//console.log(language_select.ClassName);
		
		
		 console.log("-----AAAAAAA------");
		let genderData = {
		    selectName : '',
		    lists : [
		        {val:"M",item:'男'},
		        {val:"W",item:'女'},
		    ]
		}

		let gender = new Vue({
		    el:'#gender',
		    data:genderData,
			mounted() {
			/* */
			 console.log(this);
			 console.log(this.$refs);
			 console.log(this.$refs.comp_option);
			 console.log(this.$refs.comp_option[0]);
			 console.log(this.$refs.comp_option[1]);
			 console.log($("#ALEX").css("easyui-combobox"););
			}
		});
		
	//	console.log(gender);
		
		//console.log(gender.$children);
		
		
		
		
		
		
		
		
		
		
		
		
////////////////////////////////////////////END	
})




document.addEventListener("DOMContentLoaded", function(){
	console.log("start vue");
	let firstVueObj = new Vue({
	    el:'#firstVue',
	    data:{
	        content:'Hello!world!',
	    },
	})
})


