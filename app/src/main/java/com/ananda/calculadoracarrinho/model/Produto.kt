package com.ananda.calculadoracarrinho.model

import com.ananda.calculadoracarrinho.domain.calcularValorFinalProduto

data class Produto(
    val nome: String,
    val precoUnitario: Double,
    val descricao: String? = null,
    val descontoPercentual: Double = 0.0
) : Pagável {
    override fun calcularValorTotal(): Double {
        return calcularValorFinalProduto(this)
    }
}