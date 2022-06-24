
function telaInicial(){
     window.location.href = "index.html";
}
function telaCadastro(){
    window.location.href = "/cadastroCriar";
}
function telaConsulta(){
    window.location.href = "/consulta";
}

function buscaCliente(){
    let inputNome = document.querySelector('input[name=nUsuario]');
     nome = inputNome.value;
    let url = '/consultaBuscar?nUsuario=' + nome;
    let xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.onload = function(){
                if(xhr.responseText == "null"){
                    document.getElementById("spanNull").textContent = "Cliente não encontrado!"
                    document.getElementById("divConsulta").hidden = true;
                }else{
                    objJson = JSON.parse(xhr.responseText);
                    document.getElementById("thId").textContent = objJson.id;
                    document.getElementById("tdNome").textContent = objJson.nome;
                    document.getElementById("tdEmail").textContent = objJson.email;
                    document.getElementById("tdCpf").textContent = objJson.cpf;
                    document.getElementById("tdSenha").textContent = objJson.senha;
                    document.getElementById("tdDtNasc").textContent = objJson.dataNascimento.split(' ')[0];
                    document.getElementById("tdSexo").textContent = objJson.sexo;
                    document.getElementById("divConsulta").hidden = false;
                    document.getElementById("spanNull").textContent = ""
                    document.getElementById("inputId").value = objJson.id;




                }

            }        


    xhr.send();
}




function telaUpdate(){
    document.getElementById("divPrimaria").hidden = true;
    document.getElementById("divSecundaria").hidden = false;

    document.getElementById("inputIdUp").value =  objJson.id;
    document.getElementById("inputUsuarioUp").value = objJson.nome;
    document.getElementById("inputEmailUp").value = objJson.email;
    document.getElementById("inputSenhaUp").value = objJson.senha;
}



