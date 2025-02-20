// Dados de exemplo de usuários (normalmente, você obteria isso de um servidor)
const usuarios = [
    { nome: "Arthur", email: "arthur@exemplo.com", status: "Ativo", grupo: "Admin" },
    { nome: "Gih", email: "gih@exemplo.com", status: "Ativo", grupo: "Estoquista" },
    { nome: "Vinicius", email: "vinicius@exemplo.com", status: "Ativo", grupo: "Estoquista" },
    { nome: "kaio", email: "kaio@exemplo.com", status: "Ativo", grupo: "Admin" },
];

// Função para listar os usuários
function listarUsuarios() {
    const filtro = document.getElementById('filtroNome').value.toLowerCase();
    const tabelaBody = document.getElementById('tabelaBody');
    tabelaBody.innerHTML = '';

    const usuariosFiltrados = usuarios.filter(usuario =>
        usuario.nome.toLowerCase().includes(filtro)
    );

    usuariosFiltrados.forEach(usuario => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${usuario.nome}</td>
            <td>${usuario.email}</td>
            <td><span class="status ${usuario.status.toLowerCase()}">${usuario.status}</span></td>
            <td>${usuario.grupo}</td>
            <td>
                <button class="btnInput" onclick="alterarUsuario('${usuario.nome}')">Alterar</button>
                <button class="btnInput" onclick="alterarStatus('${usuario.nome}')">${usuario.status === 'Ativo' ? 'Inativar' : 'Ativar'}</button>
            </td>
        `;
        tabelaBody.appendChild(tr);
    });
}

// Função para alterar o status do usuário
function alterarStatus(nome) {
    const usuario = usuarios.find(u => u.nome === nome);
    if (usuario) {
        usuario.status = usuario.status === 'Ativo' ? 'Inativo' : 'Ativo';
        listarUsuarios();
    }
}

// Função para navegar para a página de cadastro
function novoUsuario() {
    window.location.href = "/cadastroUsuario"; // Altere para o caminho correto da página de cadastro
}

// Função para alterar o usuário
function alterarUsuario(nome) {
    window.location.href = `/alterarUsuario?nome=${nome}`; // Altere para o caminho correto da página de alteração
}

// Atualiza a lista ao carregar a página
window.onload = listarUsuarios;

// Filtro de busca
document.getElementById('filtroNome').addEventListener('input', listarUsuarios);
