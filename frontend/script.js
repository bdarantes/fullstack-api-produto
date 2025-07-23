document.addEventListener('DOMContentLoaded', () => {
function mostrarSecao(secaoId) {
    document.querySelectorAll('.secao').forEach(secao => {
        secao.style.display='none';
    });

    const secao = document.getElementById(secaoId);
    if(secao) secao.style.display='block';

    if(secaoId ==='lista') {
        carregarProdutos();
    }
}

window.mostrarSecao = mostrarSecao;


const API_URL ='http://localhost:8080/api/produtos';

const form = document.getElementById('produto-form');
const descricaoInput = document.getElementById('descricao');
const valorInput = document.getElementById('valor');
const listarProdutos = document.getElementById('lista-produtos');


async function carregarProdutos() {
    listarProdutos.innerHTML = '';
    try {
        const resposta = await fetch(API_URL);
        const produtos = await resposta.json();

        produtos.forEach(produto => {
            console.log(produto);
            const item = document.createElement('li');
            item.textContent = `#${produto.id}-${produto.descricao} - R$ ${produto.valor.toFixed(2)}`;

            const botaoRemover = document.createElement('button');
            botaoRemover.textContent = 'Remover';
            botaoRemover.onclick = ()=>deletarProduto(produto.id);

            item.appendChild(botaoRemover);
            listarProdutos.appendChild(item);
            
        });
    } catch(erro) {
        console.error('Erro ao carregar produtos: ', erro);
    }
    
}

form.addEventListener('submit', async(e)=> {
    e.preventDefault();
    const produto = {
        descricao: descricaoInput.value,
        valor: parseFloat(valorInput.value)
    };

    try {
        const resposta = await fetch(API_URL, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(produto)
        });

        if(resposta.ok) {
            descricaoInput.value ='';
            valorInput.value='';
            carregarProdutos();
        } else {
            console.error('Erro ao cadastrar produto');
        }
    } catch (erro) {
        console.error('Erro ao enviar produto:', erro);
    }
});

async function deletarProduto(id) {
    try {
        const resposta = await fetch(`${API_URL}/${id}`, {
            method: 'DELETE'
        });

        if(resposta.status ===204) {
            carregarProdutos();
        } else {
            console.error('Erro ao deletar produto');
        }
    } catch(erro) {
        console.error('Erro ao deletar produto:',erro);
    }
  
}
carregarProdutos();

async function buscarProdutoPorId() {
    const id = document.getElementById('buscar-id').value;
    const resultado = document.getElementById('resultado-busca');
    resultado.innerHTML='';

    if(!id) {
        resultado.textContent = 'Digite um ID válido.';
        return;
    }
    try {
        const resposta = await fetch(`${API_URL}/${id}`);
        if(resposta.ok) {
            const produto = await resposta.json();
            resultado.innerHTML =`Produto encontrado: ${produto.descricao } -R$ ${produto.valor.toFixed(2)} `;
    } else {
        resultado.textContent = 'Produto não econtrado.';
        }
    } catch(erro) {
        resultado.textContent ='Erro ao buscar produto.';
        console.error(erro);
    }
    
}
window.buscarProdutoPorId = buscarProdutoPorId;

});