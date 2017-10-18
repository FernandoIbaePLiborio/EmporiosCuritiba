	function masc_idade(objeto){
		var numero="";
		var padrao=/\D/g;

		numero=objeto.value.replace(padrao, "");
		objeto.value = numero;
		}
	function masc_cep(objeto){
		var retorno="";
		var numero;
		var padrao=/\D/g;

		numero=objeto.value.replace(padrao, ""); 

		parte1=numero.substr(0,2);
		if(parte1.length>0)
			retorno=parte1;
		
		parte2=numero.substr(2,3);
		
		if(parte2.length>0)
			retorno+="-" +parte2;

		parte3=numero.substr(5,3);

		if(parte3.length>0)
			retorno+="-" + parte3;
		objeto.value=retorno;
		}
	function masc_cpf(objeto){
		var retorno="";
		var numero;
		var padrao=/\D/g;

		numero=objeto.value.replace(padrao, "");

		parte1=numero.substr(0,3);
		if(parte1.length>0)
			retorno=parte1;
		
		parte2=numero.substr(3,3);
		
		if(parte2.length>0)
			retorno+="." +parte2;

		parte3=numero.substr(6,3);

		if(parte3.length>0)
			retorno+="." + parte3;
		objeto.value=retorno;

		parte4=numero.substr(9,2);
		
		if(parte4.length>0)
			retorno+="-" + parte4;
		objeto.value=retorno;
		}
	/* Máscaras ER */
	function mascara(o,f){
	    v_obj=o
	    v_fun=f
	    setTimeout("execmascara()",1)
	}
	function execmascara(){
	    v_obj.value=v_fun(v_obj.value)
	}
	function mcep(v){
	    v=v.replace(/\D/g,"")                    //Remove tudo o que não é dígito
	    v=v.replace(/^(\d{2})(\d)/,"$1.$2")
	    v=v.replace(/(\d{3})(\d{1,3})$/,"$1-$2")
	    return v
	}
	function mtel(v){
	    v=v.replace(/\D/g,"")                 //Remove tudo o que não é dígito
	    v=v.replace(/^(\d\d)(\d)/g,"($1) $2") //Coloca parênteses em volta dos dois primeiros dígitos
	    if(v.length>13){
	    	v=v.replace(/(\d{5})(\d)/,"$1-$2")    //Coloca hífen entre o quarto e o quinto dígitos
	    }else{
	    	v=v.replace(/(\d{4})(\d)/,"$1-$2")
	    	
	    }
	    return v
	}
	function cnpj(v){
	    v=v.replace(/\D/g,"")                           //Remove tudo o que não é dígito
	    v=v.replace(/^(\d{2})(\d)/,"$1.$2")             //Coloca ponto entre o segundo e o terceiro dígitos
	    v=v.replace(/^(\d{2})\.(\d{3})(\d)/,"$1.$2.$3") //Coloca ponto entre o quinto e o sexto dígitos
	    v=v.replace(/\.(\d{3})(\d)/,".$1/$2")           //Coloca uma barra entre o oitavo e o nono dígitos
	    v=v.replace(/(\d{4})(\d)/,"$1-$2")              //Coloca um hífen depois do bloco de quatro dígitos
	    return v
	}
	function mcpf(v){
	    v=v.replace(/\D/g,"")                    //Remove tudo o que não é dígito
	    v=v.replace(/(\d{3})(\d)/,"$1.$2")       //Coloca um ponto entre o terceiro e o quarto dígitos
	    v=v.replace(/(\d{3})(\d)/,"$1.$2")       //Coloca um ponto entre o terceiro e o quarto dígitos
	                                             //de novo (para o segundo bloco de números)
	    v=v.replace(/(\d{3})(\d{1,2})$/,"$1-$2") //Coloca um hífen entre o terceiro e o quarto dígitos
	    return v
	}
	function mdata(v){
	    v=v.replace(/\D/g,"");                    //Remove tudo o que não é dígito
	    v=v.replace(/(\d{2})(\d)/,"$1/$2");       
	    v=v.replace(/(\d{2})(\d)/,"$1/$2");       
	                                             
	    v=v.replace(/(\d{2})(\d{2})$/,"$1$2");
	    return v;
	}
	function mtempo(v){
	    v=v.replace(/\D/g,"");                    //Remove tudo o que não é dígito
	    v=v.replace(/(\d{1})(\d{2})(\d{2})/,"$1:$2.$3");	
	    return v;
	}
	function mhora(v){
	    v=v.replace(/\D/g,"");                    //Remove tudo o que não é dígito
	    v=v.replace(/(\d{2})(\d)/,"$1h$2");       
	    return v;
	}
	function mrg(v){
	    v=v.replace(/\D/g,"");					//Remove tudo o que não é dígito
		v=v.replace(/(\d)(\d{7})$/,"$1.$2");	//Coloca o . antes dos últimos 3 dígitos, e antes do verificador
		v=v.replace(/(\d)(\d{4})$/,"$1.$2");	//Coloca o . antes dos últimos 3 dígitos, e antes do verificador
		v=v.replace(/(\d)(\d)$/,"$1-$2");		//Coloca o - antes do último dígito
	    return v;
	}
	function mnum(v){
	    v=v.replace(/\D/g,"");					//Remove tudo o que não é dígito
	    return v;
	}