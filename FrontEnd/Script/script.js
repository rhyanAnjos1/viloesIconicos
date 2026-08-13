const API_URL = "http://localhost:8080/viloes";

const form = document.getElementById("formVilao");
const tabelaViloes = document.getElementById("tabelaViloes");
const mensagem = document.getElementById("mensagem");

const btnSalvar = document.getElementById("btnSalvar");
const btnCancelar = document.getElementById("btnCancelar");

const tituloFormulario =
    document.getElementById("tituloFormulario");

const contadorViloes =
    document.getElementById("contadorViloes");


document.addEventListener(
    "DOMContentLoaded",
    listarViloes
);


form.addEventListener(
    "submit",
    salvarVilao
);


function listarViloes() {

    fetch(API_URL)

        .then(response => {

            if (!response.ok) {

                throw new Error(
                    "Erro ao buscar os vilões."
                );

            }

            return response.json();

        })

        .then(viloes => {

            tabelaViloes.innerHTML = "";

            contadorViloes.textContent =
                viloes.length;


            if (viloes.length === 0) {

                tabelaViloes.innerHTML = `
                    <tr>
                        <td
                            colspan="6"
                            class="sem-registros"
                        >
                            <div>
                                <span>☠</span>
                                <p>Nenhum vilão cadastrado.</p>
                            </div>
                        </td>
                    </tr>
                `;

                return;
            }


            viloes.forEach(vilao => {

                const linha =
                    document.createElement("tr");


                linha.innerHTML = `

                    <td>
                        <span class="id-badge">
                            #${vilao.idVilao}
                        </span>
                    </td>


                    <td>

                        <div class="vilao-nome">

                            <div class="vilao-avatar">
                                ${vilao.nomeVilao.charAt(0).toUpperCase()}
                            </div>

                            <strong>
                                ${vilao.nomeVilao}
                            </strong>

                        </div>

                    </td>


                    <td>
                        <span class="franquia">
                            ${vilao.franquiaObra}
                        </span>
                    </td>


                    <td>
                        ${criarBadgeAmeaca(
                            vilao.nivelAmeaca
                        )}
                    </td>


                    <td>

                        <span class="${vilao.possuiSuperpoderes
                            ? "poder-sim"
                            : "poder-nao"}">

                            <span class="status-dot"></span>

                            ${vilao.possuiSuperpoderes
                                ? "Sim"
                                : "Não"}

                        </span>

                    </td>


                    <td>

                        <div class="acoes">

                            <button
                                class="btn-editar"
                                onclick="editarVilao(${vilao.idVilao})"
                                title="Editar"
                            >
                                ✎
                            </button>


                            <button
                                class="btn-excluir"
                                onclick="excluirVilao(${vilao.idVilao})"
                                title="Excluir"
                            >
                                ×
                            </button>

                        </div>

                    </td>

                `;


                tabelaViloes.appendChild(linha);

            });

        })

        .catch(error => {

            mostrarMensagem(
                error.message,
                "erro"
            );

        });
}


function salvarVilao(event) {

    event.preventDefault();


    const id =
        document.getElementById("idVilao").value;


    const nomeVilao =
        document.getElementById("nomeVilao").value.trim();


    const franquiaObra =
        document.getElementById("franquiaObra").value.trim();


    const nivelAmeaca =
        document.getElementById("nivelAmeaca").value;


    const superpoderesSelecionado =
        document.querySelector(
            'input[name="possuiSuperpoderes"]:checked'
        );


    if (!superpoderesSelecionado) {

        mostrarMensagem(
            "Informe se o vilão possui superpoderes.",
            "erro"
        );

        return;
    }


    const possuiSuperpoderes =
        superpoderesSelecionado.value === "true";


    if (
        nivelAmeaca === "UNIVERSO" &&
        !possuiSuperpoderes
    ) {

        mostrarMensagem(
            "Ameaças de nível Universo precisam possuir superpoderes.",
            "erro"
        );

        return;
    }


    const vilao = {

        nomeVilao: nomeVilao,

        franquiaObra: franquiaObra,

        nivelAmeaca: nivelAmeaca,

        possuiSuperpoderes: possuiSuperpoderes

    };


    let url = API_URL;

    let metodo = "POST";


    if (id) {

        url = `${API_URL}/${id}`;

        metodo = "PUT";

    }


    btnSalvar.disabled = true;

    btnSalvar.innerHTML = `
        <span>⏳</span>
        Salvando...
    `;


    fetch(url, {

        method: metodo,

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(vilao)

    })

        .then(async response => {

            if (!response.ok) {

                const texto =
                    await response.text();


                throw new Error(
                    texto ||
                    "Erro ao salvar o vilão."
                );

            }


            return response.json();

        })

        .then(() => {

            mostrarMensagem(

                id
                    ? "Vilão atualizado com sucesso!"
                    : "Vilão cadastrado com sucesso!",

                "sucesso"

            );


            limparFormulario();

            listarViloes();

        })

        .catch(error => {

            mostrarMensagem(
                error.message,
                "erro"
            );

        })

        .finally(() => {

            btnSalvar.disabled = false;

            btnSalvar.innerHTML = `
                <span>⚡</span>
                Cadastrar Vilão
            `;

        });
}



function editarVilao(id) {

    fetch(`${API_URL}/${id}`)

        .then(response => {

            if (!response.ok) {

                throw new Error(
                    "Vilão não encontrado."
                );

            }

            return response.json();

        })

        .then(vilao => {

            document.getElementById(
                "idVilao"
            ).value = vilao.idVilao;


            document.getElementById(
                "nomeVilao"
            ).value = vilao.nomeVilao;


            document.getElementById(
                "franquiaObra"
            ).value = vilao.franquiaObra;


            document.getElementById(
                "nivelAmeaca"
            ).value = vilao.nivelAmeaca;


            const radio =
                document.querySelector(
                    `input[name="possuiSuperpoderes"][value="${vilao.possuiSuperpoderes}"]`
                );


            if (radio) {

                radio.checked = true;

            }


            tituloFormulario.textContent =
                "Editar Vilão";


            btnSalvar.innerHTML = `
                <span>✓</span>
                Atualizar Vilão
            `;


            btnCancelar.style.display =
                "inline-flex";


            window.scrollTo({

                top: 0,

                behavior: "smooth"

            });

        })

        .catch(error => {

            mostrarMensagem(
                error.message,
                "erro"
            );

        });
}



function excluirVilao(id) {

    const confirmar =
        confirm(
            "Deseja realmente excluir este vilão?"
        );


    if (!confirmar) {

        return;

    }


    fetch(`${API_URL}/${id}`, {

        method: "DELETE"

    })

        .then(response => {

            if (!response.ok) {

                throw new Error(
                    "Erro ao excluir o vilão."
                );

            }

        })

        .then(() => {

            mostrarMensagem(
                "Vilão excluído com sucesso!",
                "sucesso"
            );


            listarViloes();

        })

        .catch(error => {

            mostrarMensagem(
                error.message,
                "erro"
            );

        });
}



function cancelarEdicao() {

    limparFormulario();

}


function limparFormulario() {

    form.reset();


    document.getElementById(
        "idVilao"
    ).value = "";


    tituloFormulario.textContent =
        "Novo Vilão";


    btnSalvar.innerHTML = `
        <span>⚡</span>
        Cadastrar Vilão
    `;


    btnCancelar.style.display =
        "none";

}


function criarBadgeAmeaca(nivel) {

    let classe = "";

    let texto = "";


    switch (nivel) {

        case "CIDADE":

            classe = "cidade";
            texto = "Cidade";

            break;


        case "PAIS":

            classe = "pais";
            texto = "País";

            break;


        case "PLANETA":

            classe = "planeta";
            texto = "Planeta";

            break;


        case "UNIVERSO":

            classe = "universo";
            texto = "Universo";

            break;


        default:

            classe = "";
            texto = nivel;

    }


    return `
        <span class="ameaca ${classe}">
            ${texto}
        </span>
    `;
}


function mostrarMensagem(texto, tipo) {

    mensagem.textContent = texto;

    mensagem.className = tipo;


    setTimeout(() => {

        mensagem.className = "";

        mensagem.textContent = "";

    }, 4000);
}