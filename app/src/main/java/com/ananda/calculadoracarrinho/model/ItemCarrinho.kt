package com.ananda.calculadoracarrinho.model

data class ItemCarrinho(
    val produto: Produto,
    val quantidade: Int
) : Pagável {
    override fun calcularValorTotal(): Double {
        return produto.calcularValorTotal() * quantidade
    }
}