function verificaEmail(){

    let inputEmail = document.getElementById("inputEmail").value
    const regexValidEmail = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

        if (!regexValidEmail.test(inputEmail)){
            document.getElementById("inputEmail").classList.add("is-invalid");
            document.getElementById("inputEmail").value ='';
        }   
            else{
            document.getElementById("inputEmail").classList.remove("is-invalid");
            document.getElementById("inputEmail").classList.add("is-valid");
            }
}

           function verificaCPF() {
            
            let inputCpf = document.getElementById("inputCpf").value;
            const cpf = inputCpf.replace(/[^\d]+/g, '');
            let soma = 0;
            let resto;
    
            if (
                cpf === '00000000000' ||
                cpf === '11111111111' ||
                cpf === '22222222222' ||
                cpf === '33333333333' ||
                cpf === '44444444444' ||
                cpf === '55555555555' ||
                cpf === '66666666666' ||
                cpf === '77777777777' ||
                cpf === '88888888888' ||
                cpf === '99999999999'
            ) {
                document.getElementById("inputCpf").classList.add("is-invalid");
                document.getElementById("inputCpf").value ='';
                return false;
            }
    
            for (let i = 1; i <= 9; i++) soma = soma + parseInt(cpf.substring(i - 1, i)) * (11 - i);
            resto = (soma * 10) % 11;
    
            if (resto === 10 || resto === 11) resto = 0;
            if (resto !== parseInt(cpf.substring(9, 10))){
                document.getElementById("inputCpf").classList.add("is-invalid");
                document.getElementById("inputCpf").value ='';
                return false;
            } 
    
            soma = 0;
            for (let i = 1; i <= 10; i++) soma = soma + parseInt(cpf.substring(i - 1, i)) * (12 - i);
            resto = (soma * 10) % 11;
    
            if (resto === 10 || resto === 11) resto = 0;
            if (resto !== parseInt(cpf.substring(10, 11))){
                document.getElementById("inputCpf").classList.add("is-invalid");
                document.getElementById("inputCpf").value ='';
                return false;
            } 
            
            document.getElementById("inputCpf").classList.remove("is-invalid");
            document.getElementById("inputCpf").classList.add("is-valid");
            return true;
        }

        function verificaSenha(){
            let senha = document.getElementById("inputSenha");

            if(senha.value.length > 6 & senha.value.length < 20 ){
                senha.classList.add("is-valid");
            }
            else{
                senha.classList.remove('is-valid');
                senha.classList.add('is-invalid');
                senha.value = '';
            }

            }

           function showSenha(){
               let senha = document.getElementById("inputSenha");
               senha.setAttribute("type", "text");
           }

           function hideSenha(){
               let senha = document.getElementById("inputSenha");
               senha.setAttribute("type", "password");


           }






     

