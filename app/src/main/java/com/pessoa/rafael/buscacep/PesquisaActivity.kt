package com.pessoa.rafael.buscacep

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pessoa.rafael.buscacep.api.EnderecoService
import com.pessoa.rafael.buscacep.model.Endereco
import kotlinx.android.synthetic.main.activity_pesquisa.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit



class PesquisaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)

        btPesquisar.setOnClickListener{
            pesquisar()
        }

    }

    fun pesquisar(){
        val retrofit = Retrofit.Builder()
                .baseUrl("https://viacep.com.br/")
                .build()

        val service = retrofit.create(EnderecoService::class.java)

        service.buscar(etCEP.text.toString())
                .enqueue(object : Callback<Endereco> {

                    override fun onFailure(call: Call<Endereco>?, t: Throwable?) {
                        Toast.makeText(
                                this@PesquisaActivity,
                                t?.message,
                                Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<Endereco>?, response: Response<Endereco>?) {
                        if(response?.isSuccessful == true){
                            tvResultado.text = response.body()?.logradouro
                        }
                    }

                })

    }

}
