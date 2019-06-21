function validate(){
			
			var name=document.form1.name.value;
			var pass=document.form1.pass.value;
			
			if(name=="" || pass==""  ){
			alert("fields  not be blank..");
			
			return false;
			}
			return true;
			
		}