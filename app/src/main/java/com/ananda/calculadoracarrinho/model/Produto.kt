package com.ananda.calculadoracarrinho.model

data class Produto(
    val nome: String,
    val precoUnitario: Double,
    val descricao: String? = null,
    val descontoPercentual: Double = 0.0
) : Pagável {
    override fun calcularValorTotal(): Double {
        val desconto = precoUnitario * (descontoPercentual / 100.0)
        return precoUnitario - desconto
    }
}