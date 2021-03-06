package com.pessoa.rafael.buscacep.api

import com.pessoa.rafael.buscacep.model.Endereco
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EnderecoService {

    @GET("ws/{cep}/json")

    fun buscar(@Path("cep") cep: String) : Call<Endereco>

}