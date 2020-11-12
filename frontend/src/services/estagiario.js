import {http} from './config'

export default {

    listar:() => {
        return http.get('estagiarios')
    },


    salvar:(estagiario) => {
        return http.post('estagiario',estagiario)
    },

    atualizar:(estagiario) => {
        return http.put('estagiario',estagiario)
    },

    apagar:(estagiario) => {
        return http.delete('estagiario/id',{data:estagiario})
    }

}
