<template>
  <div id="app">

    <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center">Estagiarios Front</a>
      </div>
    </nav>

    <div class="container">


      <ul>
        <li v-for="(erro,index) of errors" :key="index">
          campo <b>{{ erro.field }}</b> - {{ erro.defaultMessage }}
        </li>
      </ul>

      <form @submit.prevent="salvar">

        <label>Nome</label>
        <input type="text" placeholder="Nome" v-model="estagiario.nome">
        <label>Email</label>
        <input type="text" placeholder="email" v-model="estagiario.email">
        <label>Telefone</label>
        <input type="text" placeholder="telefone" v-model="estagiario.telefone">
        <label>Foto</label>
        <input type="text" placeholder="Foto" v-model="estagiario.foto">
        <label>Comprovante Matricula</label>
        <input type="text" placeholder="Comprovante Matricula" v-model="estagiario.comprovanteMatricula">

        <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

      </form>

      <table>

        <thead>

        <tr>
          <th>NOME</th>
          <th>Email</th>
          <th>TELEFONE</th>
          <th>FOTO</th>
          <th>COMPROVANTE MATRICULA</th>
          <th>OPÇÕES</th>
        </tr>

        </thead>

        <tbody>

        <tr v-for="estagiario of estagiarios" :key="estagiario.id">

          <td>{{ estagiario.nome }}</td>
          <td>{{ estagiario.email }}</td>
          <td>{{ estagiario.telefone }}</td>
          <td> <img v-bind:src="'data:image/jpeg;base64,'+estagiario.foto" height="100" width="100" alt="img"></td>
          <td><embed v-bind:src="'data:arquivo.pdf;base64,'+estagiario.comprovanteMatricula" height="100" width="100"></td>

          <td>
            <button @click="editar(estagiario)" class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i>
            </button>
            <button @click="remover(estagiario)" class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i>
            </button>
          </td>

        </tr>

        </tbody>

      </table>

    </div>

  </div>
</template>

<script>
import Estagiario from './services/estagiario'
export default {
  data() {
    return {
      estagiario: {
        id: '',
        nome: '',
        email: '',
        telefone: '',
        foto: '',
        comprovanteMatricula: '',
        areasInteresse: [],
        areasDominio: [],
      },
      estagiarios: [],
      errors: []
    }
  },
  mounted() {
    this.listar()
  },
  methods: {
    listar() {
      Estagiario.listar().then(resposta => {
        this.estagiarios = resposta.data
      }).catch(e => {
        console.log(e)
      })
    },
    salvar() {
      if (!this.produto.id) {
        // eslint-disable-next-line no-unused-vars
        Estagiario.salvar(this.estagiario).then(resposta => {
          this.estagiario = {}
          alert('Salvo com sucesso!')
          this.listar()
          this.errors = []
        }).catch(e => {
          this.errors = e.response.data.errors
        })
      } else {
        // eslint-disable-next-line no-unused-vars
        Estagiario.atualizar(this.estagiario).then(resposta => {
          this.estagiario = {}
          alert('Atualizado com sucesso!')
          this.listar()
          this.errors = []
        }).catch(e => {
          this.errors = e.response.data.errors
        })
      }
    },
    editar(estagiario) {
      this.estagiario = estagiario
    },
    remover(estagiario) {
      if (confirm('Deseja excluir o produto ?')) {
        // eslint-disable-next-line no-unused-vars
        Estagiario.apagar(estagiario).then(resposta => {
          this.listar();
          this.errors = []
        }).catch(e => {
          this.errors = e.response.data.errors
        })
      }
    }
  }
}
</script>

<style>
</style>
